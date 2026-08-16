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
        int[] robHouse = new int[nums.length];
        robHouse[0] = nums[0];
        robHouse[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            robHouse[i] = Math.max(robHouse[i-1],nums[i]+robHouse[i-2]);
        }
    return robHouse[nums.length-1];
    }
}