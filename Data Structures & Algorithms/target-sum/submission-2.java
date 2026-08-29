class Solution {
    public int findTargetSumWays(int[] nums, int target) {
         int offset = 0;
         for(int i=0; i<nums.length; i++){
            offset = offset + nums[i];
         }

        if(Math.abs(target)> offset){
          return 0;
        }
        
        int row = nums.length;
        int col = 2 * offset + 1;
        int arr[][] = new int[row + 1][col];
        
        arr[0][offset] = 1;

        for(int i = 1 ; i<= row; i++){
            for(int j=0 ; j<col ; j++){
             if (j + nums[i - 1] < col) {
                arr[i][j] += arr[i-1][j + nums[i-1]];
             }

             if(j - nums[i-1] >=0 ){
                arr[i][j] += arr[i-1][j - nums[i-1]];
             }
            }
        }

        return arr[row][target+offset];
    }
}
