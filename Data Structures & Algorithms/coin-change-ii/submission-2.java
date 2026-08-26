class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer memo[][] = new Integer[amount+1][n];
        return changeRecur(amount,n-1,coins,memo);

    }

    int changeRecur(int sum,int n,int coins[],Integer memo[][]){
        if(sum == 0){
            return 1;
        }

        if(sum < 0 || n< 0){
            return 0;
        }
        
        if(memo[sum][n]!=null){
            return memo[sum][n];
        }

        memo[sum][n] =  changeRecur(sum,n-1,coins,memo) 
        + changeRecur(sum-coins[n],n,coins,memo);

        return memo[sum][n];

    }
}
