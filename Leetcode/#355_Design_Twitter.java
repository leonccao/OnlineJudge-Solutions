class Twitter {
    
    private class Msg {
        private int userId, tweetId;
        public Msg(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    private Map<Integer, Set> map;
    private List<Msg> list;
    
    private boolean checkUser(int userId) {
        if (map.containsKey(userId)) return true;
        Set<Integer> set = new HashSet<Integer>();
        set.add(userId);
        map.put(userId, set);
        return false;
    }
    
    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<Integer, Set>();
        list = new ArrayList<Msg>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        checkUser(userId);
        list.add(new Msg(userId, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> rtn = new LinkedList<Integer>();
        if (!checkUser(userId)) return rtn;
        Set<Integer> set = map.get(userId);
        for (int i = list.size() - 1; i >= 0; i --) {
            if (set.contains(list.get(i).userId)) {
                rtn.add(list.get(i).tweetId);
                if (rtn.size() >= 10) break;
            }
        }
        return rtn;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        checkUser(followerId);
        checkUser(followeeId);
        map.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        checkUser(followerId);
        checkUser(followeeId);
        if (followerId == followeeId) return;
        map.get(followerId).remove(followeeId);
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