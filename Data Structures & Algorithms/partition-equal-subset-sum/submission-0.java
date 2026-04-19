class Solution {
    public boolean solution(int[] nums, int index, int sum, int target, int[][] dp) {
        if (sum == target)
            return true;
        if (sum > target)
            return false;
        if (index == nums.length)
            return false;
        if (dp[index][sum] != 0)
            return dp[index][sum] == 1;
        boolean result = solution(nums, index + 1, sum + nums[index], target, dp) ||
                solution(nums, index + 1, sum, target, dp);
        dp[index][sum] = result ? 1 : 2;
        return result;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 == 1)
            return false;
        int[][] dp = new int[nums.length][20001];
        return solution(nums, 0, 0, sum / 2, dp);
    }
}