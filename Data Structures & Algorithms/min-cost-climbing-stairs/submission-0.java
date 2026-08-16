class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 0){
            return 0;
        }
        if(cost.length == 1){
            return cost[0];
        }
        if(cost.length == 2){
            return Math.min(cost[0],cost[1]);
        }
        int newCost[] = new int[cost.length+1];
        newCost[0] = cost[0];
        newCost[1] = cost[1];
        
        for(int i=2;i<cost.length;i++){
            newCost[i] = cost[i] + Math.min(newCost[i-1]
            , newCost[i-2]);
        }
        return Math.min(newCost[cost.length-1],newCost[cost.length-2]);
    }
}
