class Solution {
    public boolean canJump(int[] nums) {
        int index = 0, max = nums[index];
        while (index < nums.length && index <= max) {
            max = Math.max(max, index + nums[index]);
            index++;
        }
        return index == nums.length;
    }
}