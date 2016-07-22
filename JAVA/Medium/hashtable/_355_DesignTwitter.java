package hashtable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Design a simplified version of Twitter where users can post tweets, 
 * follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. 
 * Your design should support the following methods:
 * 
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 * Each item in the news feed must be posted by users who the user followed or by the user herself. 
 * Tweets must be ordered from most recent to least recent.
 * 
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * 
 * Example:
 * 
 * Twitter twitter = new Twitter();
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * 
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * 
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * 
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * 
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 *
 */

public class _355_DesignTwitter {
    HashMap<Integer, HashSet<Integer>> users;
    ArrayList<int[]> tweets;
    /** Initialize your data structure here. */
    public _355_DesignTwitter() {
        users = new HashMap<Integer, HashSet<Integer>>();
        tweets = new ArrayList<int[]>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) users.put(userId, new HashSet<Integer>());
        tweets.add(new int[]{userId, tweetId});
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        int cnt = 0;
        HashSet<Integer> followed = users.get(userId);
        int len = tweets.size();
        for (int idx = len - 1; idx >= 0 && cnt < 10; idx--) {
            int[] info = tweets.get(idx);
            int user = info[0];
            if (user == userId || followed != null && followed.contains(user)) {
                res.add(info[1]);
                cnt++;
            }
        }
        
        return res;
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        
        if (!users.containsKey(followerId)) {
            users.put(followerId, new HashSet<Integer>());
        } 
        HashSet<Integer> followed = users.get(followerId);
        if (!followed.contains(followeeId)) followed.add(followeeId);
        
        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        
        if (users.containsKey(followerId)) {
            HashSet<Integer> followed = users.get(followerId);
            if (followed.contains(followeeId)) followed.remove(followeeId);
        }
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */