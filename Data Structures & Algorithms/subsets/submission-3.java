class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solution = new ArrayList();
        List<Integer> sublist = new ArrayList();
        dfs(nums,0,solution,sublist);
        return solution;
    }

    void dfs(int nums[],int start, List solution,
    List sublist){
        solution.add(new ArrayList(sublist));

        for(int i=start; i<nums.length; i++){
            sublist.add(nums[i]);
            dfs(nums,i+1,solution,sublist);
            sublist.remove(sublist.size()-1);
        }
    }
}
