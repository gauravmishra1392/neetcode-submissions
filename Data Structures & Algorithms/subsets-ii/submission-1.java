class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> solution = new ArrayList();
        List<Integer> sublist = new ArrayList();
        Arrays.sort(nums);
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
        while(start+1 <= length && nums[start] == nums[start+1]){
            start++;
        }
        dfs(nums,start+1,length,solution,sublist);
    }
}
