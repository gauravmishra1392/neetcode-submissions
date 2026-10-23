class Solution {
    public int[] productExceptSelf(int[] nums) {
        int countOfZero = 0;
        int allMultiple = 1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                countOfZero++;
            }else{
                allMultiple = allMultiple * nums[i];
            }
        }
        
        int[] newNums = new int[nums.length];
        
        if(countOfZero > 1){
            return newNums;
        }

        for(int i=0;i<nums.length;i++){

            if(countOfZero == 1){
                if(nums[i] == 0){
                   newNums[i] = allMultiple;
                }
            }else{
                newNums[i] = allMultiple/nums[i];
            }
        }

        return newNums;
    }
}  
