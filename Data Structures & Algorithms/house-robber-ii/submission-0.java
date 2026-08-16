class Solution {
   // 1 1 3 3 
   // 1 1 4 4
   // 2 9 8 3 6
   // 2 9 10 12 15 
    public int rob(int[] nums) {
        if(nums == null){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
       return Math.max(robInternal(0,nums.length-2,nums),
       robInternal(1,nums.length-1,nums));
    }

    private int robInternal(int start,int end,int[] nums){
       int robHouse[] = new int[end+1];
       robHouse[start] = nums[start];
       robHouse[start+1] = Math.max(nums[start],nums[start+1]);

        for(int i=start+2;i<= end;i++){
            robHouse[i] = Math.max(robHouse[i-1] ,
             nums[i]+robHouse[i-2]);
        }
        return robHouse[end];

    }
}
