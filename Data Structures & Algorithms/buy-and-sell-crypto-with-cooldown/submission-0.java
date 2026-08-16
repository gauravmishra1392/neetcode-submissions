class Solution {
    // 1 3 4 0 4
    public int maxProfit(int[] prices) {
        Integer dp[][] = new Integer[prices.length][2];
        return maxPriceCoolDown(prices,0,0,prices.length,dp);
    }

    int maxPriceCoolDown(int[] prices,int buy,int i ,int n,Integer dp[][]){
        if (i >= n) {
            return 0;
        }
        if(dp[i][buy]!=null){
            return dp[i][buy];
        }
        int profit = 0;
      if(buy == 0){
        profit =  Math.max(-prices[i]+maxPriceCoolDown(prices,1,i+1,n,dp)
        ,maxPriceCoolDown(prices,0,i+1,n,dp));
      }else{
        profit =  Math.max(prices[i]+maxPriceCoolDown(prices,0,i+2,n,dp)
        ,maxPriceCoolDown(prices,1,i+1,n,dp));
      }
    
    dp[i][buy] = profit;
    return  Integer.valueOf(dp[i][buy]);
    }

}
