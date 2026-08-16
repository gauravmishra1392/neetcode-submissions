class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int memo[][] = new int[amount+1][n];

        for(int i=0; i<= amount; i++){
            for(int j=0 ; j< n ;j++){
                memo[i][j] = -1;
            }
        }

       return changeForCoin(amount,coins,n-1,memo);
    }

    int changeForCoin(int amount,int coins[],int n,int[][] memo){
        
      
        if(amount == 0){
            return 1;
        }
        if(amount < 0){
            return 0;
        }

        if(n<0){
            return 0;
        }
      if(memo[amount][n]!=-1){
            return memo[amount][n];
        }
        memo[amount][n] = changeForCoin(amount , coins, n-1, memo) 
        + changeForCoin(amount - coins[n], coins,n, memo);
        return memo[amount][n];
    }
}
