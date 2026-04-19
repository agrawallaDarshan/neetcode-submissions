class Solution {
    public int minJumps(int[] nums, int index, int[] dp) {
        if (index >= nums.length - 1)
            return 0;
        if (index + nums[index] >= nums.length - 1)
            return 1;
        if (dp[index] > 0)
            return dp[index];
        int jumps = 1;
        int ans = 100000;
        while (jumps <= nums[index]) {
            ans = Math.min(ans, 1 + minJumps(nums, index + jumps, dp));
            jumps++;
        }
        return dp[index] = ans;
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        return minJumps(nums, 0, dp);
    }
}