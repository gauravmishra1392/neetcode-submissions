class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList();
        List<Integer> list = new ArrayList();

        for(int i=0;i<nums.length;i++){
           if(queue.size()>0 && queue.peekFirst() <= i-k ){
                queue.pollFirst();
           }

           while(!queue.isEmpty() && nums[i]> nums[queue.peekLast()]){
            queue.pollLast();
           }

           queue.offerLast(i);

           if(i>=k-1){
            list.add(nums[queue.peekFirst()]);
           }
        }
        
        int val[]= new int[list.size()];

        for(int i=0;i<list.size();i++){
            val[i]=list.get(i);
        }
        return val;
    }
}
