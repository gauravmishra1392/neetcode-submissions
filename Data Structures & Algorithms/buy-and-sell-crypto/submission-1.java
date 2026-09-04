// 10 1 5 6 7 1

class Solution {
    public int maxProfit(int[] prices) {
       int min= Integer.MAX_VALUE;
       int max= Integer.MIN_VALUE;
       int val =0;
       for(int i=0;i<prices.length;i++){
             min = Math.min(prices[i],min);
             val = prices[i] - min;
             max = Math.max(max,val);
       }   
       return max;
    }
}
