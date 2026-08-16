class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.offer(stones[i]);
        }

        while(pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            if(a!=b){
               int x = Math.abs(a-b);
                pq.offer(x);
            }
        }

        return pq.size()== 1?pq.peek():0;
    }
}