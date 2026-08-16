class Solution {
    public int coinChange(int[] coins, int amount) {
           int[] memo = new int[amount+1];
           Arrays.fill(memo,-2);
           int result =  dfs(coins,amount,memo);
           return result == Integer.MAX_VALUE ? -1 : result;
    }

    int  dfs(int[] coins, int amount, int memo[]){
        
        if(amount == 0){
            return 0;
        }

        if(amount < 0){
            return Integer.MAX_VALUE;
        }

        if(memo[amount] != -2){
          return memo[amount];
        }

        int best = Integer.MAX_VALUE;
        for(int coin: coins){
          int sub = dfs(coins,amount-coin,memo);
          if(sub != Integer.MAX_VALUE){
            best = Math.min( 1 + sub ,best);
          }
          
        }
        return memo[amount] = best;
    }
}
