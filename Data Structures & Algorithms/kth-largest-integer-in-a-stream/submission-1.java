class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int capacity = 0;
    public KthLargest(int k, int[] nums) {
        this.capacity =k;
        for(int i=0;i<nums.length;i++){  
          add(nums[i]);
        }
    }
    
    public int add(int val) {
         pq.add(val);
         if(pq.size()>this.capacity){
            pq.poll();
         }
         return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */