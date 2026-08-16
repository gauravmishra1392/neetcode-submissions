class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       Arrays.sort(intervals,
       (a,b)->a[0]-b[0]);
       int[] pre = intervals[0];
       int c=0;
      for(int[] interval:intervals){
        if(interval[0]<pre[1]){
            c++;
            if(pre[1]>interval[1]){
                pre=interval;
            }
        }else{
            pre = interval;
        }
      }
      return c-1;
    }
}