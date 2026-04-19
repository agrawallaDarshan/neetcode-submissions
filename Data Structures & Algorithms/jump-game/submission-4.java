class Solution {
    public boolean canJump(int[] nums, int index, int[] dp) {
        if (index >= nums.length - 1 || index + nums[index] >= nums.length - 1)
            return true;
        if (dp[index] != 0)
            return dp[index] == 1;
        boolean ans = false;
        int jumps = nums[index];
        while (jumps-- > 0) {
            index++;
            ans |= canJump(nums, index, dp);
        }
        dp[index] = ans ? 1 : 2;
        return ans;
    }

    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        return canJump(nums, 0, dp);
    }
}