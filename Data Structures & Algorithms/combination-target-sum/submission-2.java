class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       // 2 5 6 9
       // 9
       // [2 2 5]
       // [9]
       List<List<Integer>> results = new ArrayList();
       List<Integer> result = new ArrayList();

       this.backtrack(target,result,results,0,nums);
        return results;
    }

    private void backtrack(int target,List<Integer> local,
    List<List<Integer>> finallist,int start, int[] candidates){
        if(target == 0){
            finallist.add(new ArrayList(local));
            return;
        }else if(target<0){
            return;
        }
        for(int i = start;i<candidates.length;i++){
            local.add(candidates[i]);
            this.backtrack(target-candidates[i],local,finallist,i,candidates);
            local.remove(local.size()-1);
        }
        
    }



}
