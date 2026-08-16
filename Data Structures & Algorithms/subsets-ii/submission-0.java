class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> newList = new ArrayList();
        Arrays.sort(nums);
        rec(nums,0,nums.length,list,newList);
        return list;
    }

    void rec(int[] nums,int start,int length,List<List<Integer>> list,List<Integer> newList){
        list.add(new ArrayList(newList));
        for(int i=start;i<length;i++){
            if(i!=start && nums[i]==nums[i-1]){
                continue;
            }
            newList.add(nums[i]);
            rec(nums,i+1,length,list,newList);
            newList.remove(newList.size()-1);
        }
    }
}
