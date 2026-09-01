class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int newNums[] = new int[n+2];
        newNums[0] = newNums[n+1] =1;

        for(int i= 0;i<n;i++){
            newNums[i+1] = nums[i];
        }
        int dp[][] = new int[n+2][n+2];

        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=n; j++){
                dp[i][j] = -1;
            }
        }

        return dfs(newNums,1,n,dp);
    }

    int dfs(int newNums[],int start,int end,int dp[][]){
        if(start>end){
            return 0;
        }
        if(dp[start][end]!=-1){
            return dp[start][end];
        }
        dp[start][end] = 0;
        for(int i=start;i<=end;i++){
            int sum = newNums[start-1]*newNums[i]*newNums[end+1];
            sum = sum + dfs(newNums,start,i-1,dp) + 
            dfs(newNums,i+1,end,dp);
            dp[start][end] = Math.max(sum,dp[start][end]);
     
        }
        return dp[start][end];
    }
}
