class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solution = new ArrayList();
        List<Integer> sublist = new ArrayList();
        dfs(nums,0,nums.length-1,solution,sublist);
        return solution;
    }

    void dfs(int nums[],int start, int length, List solution,
    List sublist){

        if(start == length+1){
            solution.add(new ArrayList(sublist));
        }
        if(start > length){
            return;
        }

        sublist.add(nums[start]);
        dfs(nums,start+1,length,solution,sublist);
        sublist.remove(sublist.size() - 1);
        dfs(nums,start+1,length,solution,sublist);
    }
}
