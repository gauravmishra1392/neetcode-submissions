class Solution {
    public int findTargetSumWays(int[] nums, int target) {
         int offset = 0;

         for(int i=0;i<nums.length;i++){
            offset = offset + nums[i];
         }

         if(Math.abs(target)> offset){
            return 0;
         }

        int n = nums.length;
        Integer memo[][] = new Integer[n][2*offset+1];
        return findTargetSumWaysRecur(0,0,nums,target,memo,offset);
    }

    int findTargetSumWaysRecur(int i, int sum,int[] nums,int target,
    Integer[][] memo,int offset){

        if(i == nums.length){
           return (target == sum) ? 1 : 0;
        }
      if (memo[i][sum + offset] != null) {
            return memo[i][sum + offset];
        }
        int add = findTargetSumWaysRecur(i+1 , sum +    nums[i],nums,target,memo,offset);

        int sub = findTargetSumWaysRecur(i+1 , sum -   nums[i],nums,target,memo,offset);

        memo[i][offset+sum]= add+sub;
        return memo[i][offset+sum];
    }
}
