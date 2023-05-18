package com.lura.leetcode.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 355. 设计推特
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近 10 条推文。
 * 实现 Twitter 类：
 * Twitter() 初始化简易版推特对象
 * void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId 创建一条新推文。每次调用此函数都会使用一个不同的 tweetId 。
 * List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近  10 条推文的 ID 。新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。
 * void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为 followeeId 的用户。
 * void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为 followeeId 的用户。
 *
 * @ description: DesignTwitter
 * @ author: Liu Ran
 * @ data: 5/18/23 16:01
 */
public class DesignTwitter {
    int globalTime = 0;

    Map<Integer, User> userMap = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        user.post(new Tweet(tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if (!userMap.containsKey(userId)) {
            return res;
        }

        User user = userMap.get(userId);
        Set<User> followedUserSet = user.followeeSet;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> {
            // 按照每条 tweet 的发布时间降序排序（最近发布的排在事件流前面）
            return b.timestamp - a.timestamp;
        });

        if (user.head != null) {
            pq.offer(user.head);
        }
        for (User other : followedUserSet) {
            if (other.head != null) {
                pq.offer(other.head);
            }
        }

        int count = 0;
        while (!pq.isEmpty() &&  count< 10) {
            Tweet tweet = pq.poll();
            res.add(tweet.id);
            if (tweet.next != null) {
                pq.offer(tweet.next);
            }
            count++;
        }
        return res;

    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);
        follower.follow(followee);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);
        follower.unfollow(followee);
    }

    static class User {
        int id;
        Tweet head;
        Set<User> followeeSet;

        public User(int id) {
            this.id = id;
            followeeSet = new HashSet<>();
        }

        public void post(Tweet tweet) {
            if (head == null) {
                head = tweet;
            }else {
                head.next = tweet;
            }
        }

        public void follow(User followee) {
            this.followeeSet.add(followee);
        }

        public void unfollow(User followee) {
            this.followeeSet.remove(followee);
        }
    }

    class Tweet {
        int id;
        Tweet next;
        int timestamp;
        public Tweet(int id) {
            this.id = id;
            this.timestamp = globalTime++;
        }


    }

    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();

        System.out.println(userMap.putIfAbsent(1, new User(1)));
    }


}
