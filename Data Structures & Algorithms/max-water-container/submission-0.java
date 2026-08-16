// 1 7 2 5 4 7 3 6
// 1 7 7 7 7 7 7 7
// 7 7 7 7 7 7 6 6 
// 5 2 3 3 3

class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        int max = 0;
        int i = 0;
        int j = heights.length-1;
        while(i<j){
           area = Math.min(heights[i],heights[j])*(j-i);
           max = Math.max(area,max);

           if(heights[i]<heights[j]){
                i++;
           }else{
                j--;
           }

        }
        return max;
    }
}
