class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int maxlen= 0;
        for(int i=0;i<nums.length;i++){
            int len=0;
            if(!set.contains(nums[i]-1)){
             int k = nums[i];   
             while(set.contains(k)){
                k++;
                len++;
             }
            }
            maxlen= Math.max(maxlen,len);
        }
        return maxlen;
    }
}
