class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.computeIfAbsent(nums[i],key -> 0);
            map.put(nums[i],map.get(nums[i])+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer> > pq = 
        new PriorityQueue<Map.Entry<Integer,Integer>>
        ((Map.Entry<Integer,Integer> a,Map.Entry<Integer,Integer> b) -> a.getValue()-b.getValue());
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }

        List<Integer> list = new ArrayList<>();
        while(pq.size()>0){
            list.add(pq.poll().getKey());
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
