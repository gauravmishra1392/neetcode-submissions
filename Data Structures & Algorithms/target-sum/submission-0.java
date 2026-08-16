
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;

        // If target is out of range, no way to reach it
        if (Math.abs(target) > sum) return 0;

        // Use Integer array to distinguish between 0 (not computed) and computed 0
        // Offset is 'sum' because the range of possible sums is [-sum, sum]
        Integer[][] memo = new Integer[nums.length][2 * sum + 1];
        
        return dfs(0, 0, nums, target, memo, sum);
    }

    private int dfs(int i, int total, int[] nums, int target, Integer[][] memo, int offset) {
        // Base case: If we've processed all numbers, check if total matches target
        if (i == nums.length) {
            return total == target ? 1 : 0;
        }

        // Check if already computed (using offset to handle negative indices)
        if (memo[i][total + offset] != null) {
            return memo[i][total + offset];
        }

        // Recursive steps: add or subtract the current number
        int add = dfs(i + 1, total + nums[i], nums, target, memo, offset);
        int sub = dfs(i + 1, total - nums[i], nums, target, memo, offset);

        // Store and return result
        return memo[i][total + offset] = add + sub;
    }
}