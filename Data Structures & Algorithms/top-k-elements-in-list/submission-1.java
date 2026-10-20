// 1 2 2 3 3 3
// k = 2
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> map = new HashMap();

       for(int num:nums){
          map.put(num,map.getOrDefault(num,0)+1);
       }
     
       PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b) -> {
                return Integer.compare(b.getValue(), a.getValue());
            });
       
      for(Map.Entry<Integer,Integer> mp: map.entrySet()){
            pq.offer(mp);
      }

      int answer[] = new int[k];

      for(int i=0;i<k;i++){
        answer[i] = pq.poll().getKey();
      }
      return answer;
    }
}
