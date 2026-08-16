class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergeInterval = new ArrayList<>();
        int i=0;
        while(i<intervals.length && 
            intervals[i][1]<newInterval[0]){
            mergeInterval.add(intervals[i]);
            i++;
        }

        int merger[] = newInterval;


        while(i<intervals.length &&  intervals[i][0] <= merger[1] && intervals[i][1] >= merger[0] ){
            System.out.println(intervals[i][1]+" "+merger[0]);
            merger[0] = Math.min(merger[0],intervals[i][0]);
            merger[1] = Math.max(merger[1],intervals[i][1]);
            i++;
        }

        mergeInterval.add(merger);

        while(i<intervals.length){
            mergeInterval.add(intervals[i]);
            i++;
        }

        return mergeInterval.toArray(new int[mergeInterval.size()][]);
      
    }
}
