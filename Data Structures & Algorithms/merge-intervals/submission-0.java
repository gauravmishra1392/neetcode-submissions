class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) ->  a[0]-b[0]);
        LinkedList<int[]> merge = new LinkedList<>();
        for(int[] interval:intervals){
            if(merge.size()==0 ||
              merge.getLast()[1]< interval[0]){
                merge.add(interval);
            }else{
                merge.getLast()[0] = Math.min(merge.getLast()[0],
                interval[0]);
                 merge.getLast()[1] = Math.max(merge.getLast()[1],
                interval[1]);
            }

           // System.out.println(interval[0]+" "+interval[1]);
        }
       

        return merge.toArray(new int[merge.size()][]);
    }
}
