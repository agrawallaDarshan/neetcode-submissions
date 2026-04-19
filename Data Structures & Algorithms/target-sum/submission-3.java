class Solution {
    public int solution(int[] nums, int index, int n, int sum, int target, int[][] dp) {
        if (index == n) {
            if (target == sum)
                return 1;
            return 0;
        }
        int dpIndex = sum >= 0 ? sum : dp[0].length + sum;
        if (dp[index][dpIndex] != -1)
            return dp[index][dpIndex];

        return dp[index][dpIndex] = solution(nums, index + 1, n, sum + nums[index], target, dp)
                + solution(nums, index + 1, n, sum - nums[index], target, dp);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][2001];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solution(nums, 0, nums.length, 0, target, dp);
    }
}