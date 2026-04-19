class Solution {
    public int minJumps(int[] nums, int index) {
        if (index >= nums.length - 1) return 0;
        if (index + nums[index] >= nums.length - 1) return 1;
        int jumps = 1;
        int minJ = 100000;
        while (jumps <= nums[index]) {
            minJ = Math.min(minJ, 1 + minJumps(nums, index + jumps));
            jumps++;
        }
        return minJ;
    }

    public int jump(int[] nums) {
        return minJumps(nums, 0);
    }
}