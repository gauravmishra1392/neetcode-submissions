class Solution {
    public int jump(int[] nums) {
        int n = nums.length; // Fix: define 'n'
        if (n <= 1) return 0;

        int cur = nums[0];
        int max = 0;
        int count = 1;

        for (int i = 1; i < n; i++) {
            max = Math.max(i + nums[i], max);

            if (i == cur && i != n - 1) { // Avoid extra jump at the end
                cur = max;
                max = 0;
                count++;
            }
        }

        if (cur < n - 1) {
            return -1;
        } else {
            return count;
        }
    }
}
