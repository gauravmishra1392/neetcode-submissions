class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            sum = sum + nums[i];
        }
        if(sum % 2 !=0){
            return false;
        }
        int target = sum/2;
        Boolean cache[][] = new Boolean[target+1][n];

    

        return partition(nums, target ,n-1,cache);
        //return cache[sum][n];
    }

    boolean partition(int nums[], int sum, int n, Boolean cache[][]){
        if(sum == 0){
            return true;
        }
        if(sum < 0 || n < 0){
            return false;
        }
        if(cache[sum][n] != null){
            return cache[sum][n];
        }
        

        cache[sum][n] =  partition(nums,sum-nums[n],n-1,cache) 
        || partition(nums,sum,n-1,cache);

        return cache[sum][n];
    }
}
