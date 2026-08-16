class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list  = new ArrayList();
        List<Integer> newList= new ArrayList();
         rec(candidates,target,0, list,newList);
         return list;
    }

   void rec(int[] candidates,int target,int index,List<List<Integer>> list, List<Integer> newlist){
        if(target == 0){
            list.add(new ArrayList<>(newlist));
            return;
        }
        if(index>=candidates.length || target <0){
            return ;
        }
        newlist.add(candidates[index]);
        rec(candidates,target-candidates[index],index,list,newlist);
        newlist.remove(newlist.size() - 1);
        rec(candidates,target,index+1,list,newlist);
    }
}