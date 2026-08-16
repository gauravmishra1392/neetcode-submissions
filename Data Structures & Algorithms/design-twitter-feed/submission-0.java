class Node{
    int tweetId;
    int time;
    Node(int tweetId,int time){
        this.tweetId = tweetId;
        this.time = time;
    }
}

class Twitter {
    Map<Integer,List<Node>> userTweets = null;
    Map<Integer,Set<Integer>> followers = null;
    int timestamp = 0;

    public Twitter() {
        userTweets = new HashMap<>();
        followers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
       Node node = new Node(tweetId,timestamp++);
       userTweets.computeIfAbsent(userId,val -> new ArrayList<Node>()).add(node);
    }
    
    public List<Integer> getNewsFeed(int userId) {
          PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->  (b.time - a.time));
          List<Node> list = new ArrayList();
          if (userTweets.containsKey(userId)) {
                list.addAll(userTweets.get(userId));
           }
          if(followers.get(userId)!= null){
          for(int fol:followers.get(userId)){
            if (userTweets.containsKey(fol)) {
            list.addAll(userTweets.get(fol));
            }
          }
          }
          for(Node node: list){
            pq.offer(node);
          }

          int k  = 10;
          List<Integer> flist = new ArrayList();
          while(k>0){
            Node node = pq.poll();
            if(node == null) break;
            flist.add(node.tweetId);
            k--;
          }
          return flist;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        Set<Integer> fol = followers.get(followerId);
        if(fol == null){
            fol = new HashSet<>();
            fol.add(followeeId);
        }else{
            fol.add(followeeId);
        }
        followers.put(followerId,fol);
    }
    
    public void unfollow(int followerId, int followeeId) {
          Set<Integer> fol = followers.get(followerId);
        if(fol!=null){
        System.out.println(fol +" "+followers.get(followerId));
        fol.remove(Integer.valueOf(followeeId));
        System.out.println(fol +" "+followers.get(followerId));
            if(fol.size() == 0){
                followers.remove(followerId);
            }
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