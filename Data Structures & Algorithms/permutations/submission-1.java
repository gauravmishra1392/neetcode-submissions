class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> solution = new ArrayList();
        List<Integer> subList = new ArrayList();
        backtrack(nums, solution, subList);
        return solution;
    }

    void backtrack(int nums[],List<List<Integer>> solution,
    List<Integer> sublist){
        if(sublist.size() == nums.length){
            solution.add(new ArrayList(sublist));
        }
        if(sublist.size() > nums.length){
            return;
        }
       for(int i=0; i<nums.length; i++){
            if(!sublist.contains(nums[i])){
                sublist.add(nums[i]);
                backtrack(nums,solution,sublist);
                sublist.remove(sublist.size()-1);
            }
       }
    }
}
