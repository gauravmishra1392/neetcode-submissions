// 3 4 5 6 1 2
// 1 2 3 4 5 6

// 1 2 3 4 5 6
// 3 4 5 6 1 2

class Solution {
    public int findMin(int[] nums) {
        
      int pivot = findPivot(nums,0,nums.length-1);
      
      return nums[pivot];

    }

    int findPivot(int[] nums,int left,int right){

        while(left < right){
            int mid = (left+right)/2;
            System.out.println(nums[mid]+" "+ nums[right]);
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
