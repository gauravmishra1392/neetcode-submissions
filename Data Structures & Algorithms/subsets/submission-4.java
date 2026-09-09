class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        
        subset(nums,0,list,finalList);

        return finalList;
    }

   void subset(int nums[],int start, List<Integer> list, List<List<Integer>> finalList){
  
        finalList.add(new ArrayList(list));

        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            subset(nums,i+1,list,finalList);
            list.remove(list.size() - 1);
        }

    }
}
