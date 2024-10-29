class Twitter {
    public HashMap<Integer,List<int[]>> userHash;
    public HashMap<Integer, List<Integer>> followeesHash; 
    public int tweetFrame = 0;
    public Twitter() {
        userHash = new HashMap<>();
        followeesHash = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        System.out.println(userId + " posted tweet " + tweetId);
        int[] tweet = new int[2];
        tweet[0] = tweetFrame++;
        tweet[1] = tweetId;
        if (userHash.containsKey(userId)){    
            userHash.get(userId).add(tweet);
        }
        else {
            List<int[]> newTweetList = new ArrayList<>();
            newTweetList.add(tweet);
            userHash.put(userId, newTweetList);
        }
        System.out.println("Tweets of "+ userId + " : " + userHash.get(userId).toString());
    }
    
    public List<Integer> getNewsFeed(int userId) {
        System.out.println(userId + " is getting his feed");
        List<Integer> res = new ArrayList<>();
        List<int[]> posts = new ArrayList<>();
        // posts of self
        if (userHash.containsKey(userId)) {
            List<int[]> postsOfSelf = userHash.get(userId);
            for (int[] postId : postsOfSelf){
                posts.add(postId);
            }
        }
        // posts of followees
        if (followeesHash.containsKey(userId)){
            List<Integer> followees = followeesHash.get(userId);
            for (Integer followee : followees){
                if (userHash.containsKey(followee)){
                    List<int[]> postsOfUser = userHash.get(followee);
                    for (int[] postId : postsOfUser){
                        posts.add(postId);
                    }
                }
            }
        }
        Collections.sort(posts, (a,b) -> b[0]-a[0]);

        int len = Math.min(10, posts.size());
        for (int i=0; i<len; i++){
            res.add(posts.get(i)[1]);
        }
        System.out.println("Feed of user " + userId + " is " + res.toString());
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        System.out.println(followerId + " followed " + followeeId);
        if (followeesHash.containsKey(followerId)){
            List<Integer> followees = followeesHash.get(followerId);
            boolean contains = false;
            for (Integer followee : followees){
                if (followee == followeeId){
                    contains = true;
                }
            }
            if (!contains){
                followeesHash.get(followerId).add(followeeId);
            }
        }
        else {
            List<Integer> newFolloweeList = new ArrayList<>();
            newFolloweeList.add(followeeId);
            followeesHash.put(followerId, newFolloweeList);
        }
        System.out.println("Followees of "+followerId + " : " + followeesHash.get(followerId).toString());
    }
    
    public void unfollow(int followerId, int followeeId) {
        System.out.println(followerId + " unfollowed " + followeeId);
        if (followeesHash.containsKey(followerId)){
            List<Integer> followees = followeesHash.get(followerId);
            int index = -1;
            for (int i=0; i<followees.size(); i++){
                if (followees.get(i) == followeeId){
                    index = i;
                }
            }
                
            if (index != -1){
                followees.remove(index);
            }
            System.out.println("Followees of "+followerId + " : " + followeesHash.get(followerId).toString());
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
