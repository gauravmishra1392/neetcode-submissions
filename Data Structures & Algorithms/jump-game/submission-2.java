// 2,3,1,1,4
// 0 1 2 3 4
// 2,5,0,0
// 0 1 2 3
// 
class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        int no=0;
        for(int i=0;i<nums.length;i++){
             no = Math.max(no,nums[i] + i);
            if(i == max ){
                 max = Math.max(no,max);
            }
        }
        return max >= nums.length-1?true:false;
    }
}
