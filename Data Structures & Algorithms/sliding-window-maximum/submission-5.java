// 1 2 1 0 4 2 6 
// 2 2 4 4 6

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque<Integer> deque = new LinkedList<>();
       List<Integer> list = new ArrayList();

       for(int i=0;i<nums.length;i++){

            if(!deque.isEmpty() && 
               deque.peekFirst() <= i-k){
               deque.pollFirst();
            }
            
            while(!deque.isEmpty() && 
            nums[i]>nums[deque.peekLast()] ){
                deque.pollLast();
            }

            deque.offerLast(i);

            if(i>=k-1){
                list.add(nums[deque.peekFirst()]);
            }

       }
       int numsp[] = new int[list.size()];
       
       for(int i=0;i<list.size();i++){
        numsp[i] =  list.get(i); 
       }

       return numsp;
    }
}
