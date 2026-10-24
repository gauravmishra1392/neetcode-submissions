// 2,20,4,10,3,4,5

// 2,20,4,10,3,4,5
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> arSet = new HashSet();
        int maxlen = 0;

        for(int i=0;i<nums.length;i++){
            arSet.add(nums[i]);
        }

        for(int i=0;i<nums.length;i++){

            int k = nums[i];
            int len = 0;

            if(!arSet.contains(nums[i]-1)){
                while(arSet.contains(k)){
                    k++;
                    len++;
                }
            }

            maxlen = Math.max(maxlen,len);

        }
        return maxlen;
    }
}
