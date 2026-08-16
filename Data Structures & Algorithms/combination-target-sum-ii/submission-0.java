class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> list  = new HashSet();
        Arrays.sort(candidates); 
        List<Integer> newList= new ArrayList();
         rec(candidates,target,0, list,newList);
         return new ArrayList(list);
    }

   void rec(int[] candidates,int target,int index,Set<List<Integer>> list, List<Integer> newlist){
        if(target == 0){
            list.add(new ArrayList<>(newlist));
            return;
        }
        if(index>=candidates.length || target <0){
            return ;
        }
        newlist.add(candidates[index]);
        rec(candidates,target-candidates[index],index+1,list,newlist);
        newlist.remove(newlist.size() - 1);
        int newIndex = index+1;
        while(newIndex<candidates.length-1 && candidates[newIndex]==candidates[index]){
            newIndex++;
        }
        rec(candidates,target,newIndex,list,newlist);
    }
}