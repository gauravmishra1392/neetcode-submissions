class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
       
       List<List<Integer>> solution = new ArrayList<>();
       List<Integer> sublist = new ArrayList();
       Arrays.sort(nums);
       backtrack(nums,target,solution,sublist,0,0);
    
       return new ArrayList(solution);
    }

    void backtrack(int nums[], int target, List solution,List sublist
    ,int localsum,int start){
       
        if(localsum == target){
            solution.add(new ArrayList<>(sublist));
            return;
        }
      if (localsum > target) return;

        for(int i=start ; i<nums.length; i++){
            if(i > start && nums[i]==nums[i-1])
            {
                continue;
            }
            sublist.add(nums[i]);
             backtrack(nums,target,solution,sublist,localsum + nums[i],i+1);
            sublist.remove(sublist.size()-1);
        }
    }
}
