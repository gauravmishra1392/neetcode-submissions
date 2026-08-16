class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return cost[0];
        }
        if(n == 2){
            return Math.min(cost[0],cost[1]);
        }
        int arr[] = new int[n];
        arr[0] = cost[0];
        arr[1] = cost[1];
        
        for(int i = 2 ; i<n ; i++){
            arr[i] = cost[i]+Math.min(arr[i-1],arr[i-2]);
        }


        return Math.min(arr[n-1],arr[n-2]);
    }
}
