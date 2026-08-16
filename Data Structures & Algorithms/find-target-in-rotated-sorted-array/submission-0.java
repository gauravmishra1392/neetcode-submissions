class Solution {
    int findPivot(int nums[]){
        int start =0;
        int end = nums.length-1;
        while(start<end){
            int mid = (start+end)/2;
            if(nums[end]<nums[mid]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }
    int binarySearch(int nums[],int start,int end,int target){
        while(start<=end){
            int mid  = (start+end)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]>target){
                end = mid-1;
            }else{
                start =mid+1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int pivot = findPivot(nums);
        if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, pivot, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, pivot - 1, target);
        }
        
    }
}