/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
    
    List<int[]> freq = new ArrayList<>();
        
        for(Interval interval:intervals){
            freq.add(new int[]{interval.start,1});
            freq.add(new int[]{interval.end,-1});
        }

        freq.sort(new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[0]!=b[0]){
                    return Integer.compare(a[0],b[0]);
                }
                return Integer.compare(a[1],b[1]);
            }
        });

        int maxLen =0;
        int sum=0;
        for(int[] freqArr: freq){
            sum = sum + freqArr[1];
            maxLen = Math.max(maxLen,sum);
        }
        return maxLen;
    }
    
}
