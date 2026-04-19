class Solution {
    public int partitionSum(int[] nums, int index, int k, Integer[][] dp) {
        if (dp[index][k] != null) 
            return dp[index][k];
        if (k == 1) {
            dp[index][k] = 0;
            for (int i = index; i < nums.length; i++) {
                dp[index][k] += nums[i];
            }
        } else {
            dp[index][k] = Integer.MAX_VALUE;
            int currentPartSum = 0;
            for (int i = index; i <= nums.length - k; i++) {
                currentPartSum += nums[i];
                int nextPartSum = partitionSum(nums, i + 1, k - 1, dp);
                dp[index][k] = Math.min(dp[index][k], Math.max(currentPartSum, nextPartSum));
            }
        }
        return dp[index][k];
    }

    public int splitArray(int[] nums, int k) {
        Integer[][] dp = new Integer[nums.length + 1][k + 1];
        return partitionSum(nums, 0, k, dp);
    }
}