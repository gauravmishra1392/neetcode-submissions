class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int n= 1<<len;
        List<List<Integer>> finalList = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<len;j++){
                if((i&(1<<j))!=0){
                    list.add(nums[j]);
                }
            }
            finalList.add(list);
        }

        return finalList;
    }
}