class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       
       List<List<Integer>> solution = new ArrayList();
       List<Integer> sublist = new ArrayList();

        backtrack(nums,target,solution,sublist,0,0);
       
       return solution;
    }

    void backtrack(int nums[], int target, List solution,List sublist
    ,int localsum,int start){
       
        if(localsum == target){
            solution.add(new ArrayList(sublist));
        }
  if (localsum > target) return;

        for(int i=start ; i<nums.length; i++){
            sublist.add(nums[i]);
             backtrack(nums,target,solution,sublist,localsum + nums[i],i);
            sublist.remove(sublist.size()-1);
        }
    }
}
