class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                if(nums[i]+nums[start]+nums[end] == 0){
                    List<Integer> tempList = new ArrayList();
                    tempList.add(nums[i]);
                    tempList.add(nums[start]);
                    tempList.add(nums[end]);
                    list.add(tempList);
                }
                if(nums[i]+nums[start]+nums[end] >0){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return new ArrayList(list);
    }
}
