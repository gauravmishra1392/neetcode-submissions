class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        System.out.println(";;;");
        int pivot = findPivot(nums,0,nums.length-1);
        System.out.println(nums[pivot]);
        if(nums[pivot] <= target && nums[right]>= target){
           return binarySearch(nums,pivot,right,target);
        }else{
           return binarySearch(nums,0,pivot-1,target);
        }
    }
     
    int binarySearch(int nums[],int left,int right,int target){
     
            while(left <= right){
                 int mid = (left+right)/2;
                 if(nums[mid]<target){
                    left = mid+1;
                 }else if(nums[mid] > target){
                    right = mid-1;
                 }else{
                    return mid;
                 }
            }
            return -1;
    }

    int findPivot(int[] nums,int left,int right){
        System.out.println("..");
        while(left<right){
            int mid = (left+right)/2;
            System.out.println(mid);
            if(nums[mid] > nums[right]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
