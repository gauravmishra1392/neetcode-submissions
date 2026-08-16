class Solution {
    public int lengthOfLIS(int[] nums) {

        int lis[] = new int[nums.length];
        Arrays.fill(lis,1);
        for(int i=0;i<nums.length;i++){
            for( int j=0 ;j< i;j++){
                if(nums[i]>nums[j]){
                    lis[i] = Math.max(lis[i],lis[j] + 1);
                }
            }
        }

        int mx = Integer.MIN_VALUE;

        for(int i = 0; i< lis.length; i++){
            mx = Math.max(mx,lis[i]);
        }
        return mx;
    }
}
