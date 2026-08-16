/*
13 15 16 1 2 4 5 6 7 8 9
3 5 6 1 2   
1 2 3 4 5

*/

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while(l < r){
            int mid = (l+r)/2;

            if(nums[mid]< nums[r]){
                r = mid;
            }else{
                l = mid+1;
            }

        }
    return nums[l];
    }
}
