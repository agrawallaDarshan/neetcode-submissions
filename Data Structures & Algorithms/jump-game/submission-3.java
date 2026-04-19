class Solution {
    public boolean canJump(int[] nums, int index) {
        if (index >= nums.length - 1 || index + nums[index] >= nums.length - 1) return true;
        boolean ans = false;
        int jumps = nums[index];
        while (jumps-- > 0) {
            index++;
            ans |= canJump(nums, index);
        }
        return ans;
    }
    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }
}