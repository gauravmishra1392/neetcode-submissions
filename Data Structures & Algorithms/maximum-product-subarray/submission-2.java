class Solution {
    //-1 0 -3
    // 1 2 -3 4
    // 1 2  2
    

    // -2 -1 2
    // -2  1 -3
    //-2 0 1
    //1 0 -2

    public int maxProduct(int[] nums) {
        int minProd = nums[0];
        int maxProd = nums[0];
        int result = nums[0];
        
        for(int i=1;i<nums.length;i++){
            int tempMax = maxProd;
             maxProd = Math.max(nums[i],Math.max(maxProd*nums[i]
            ,minProd*nums[i]));
             minProd = Math.min(nums[i],Math.min(tempMax*nums[i],
            minProd*nums[i]));
            result = Math.max(result,maxProd); 
        }

        return result;
    }
}
