/*
   7 1 7 2 2 4
   
   7 1
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> st = new Stack();
         int area = 0;
         int maxArea =0;
        for(int i=0;i< heights.length; i++){
           
                while(!st.isEmpty() &&
                heights[i] < heights[st.peek()]){
                    int height = st.pop();
                    int last = st.isEmpty() ? i : i - st.peek()-1;
                    area = last * heights[height];
                    maxArea = Math.max(maxArea, area);
                }
             st.push(i);
        }

        int len = heights.length;
        while(!st.isEmpty()){
            int val = st.pop();
            int height = st.isEmpty()? len : len - st.peek() - 1;
            area = height * heights[val];
            maxArea = Math.max(maxArea, area);
        }
      return maxArea;
    }
}
