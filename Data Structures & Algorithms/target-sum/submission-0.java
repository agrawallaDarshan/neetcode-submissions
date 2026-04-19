class Solution {
    public int solution(int[] nums, int index, int n, int sum, int target) {
        if (index == n) {
            if (target == sum)
                return 1;
            return 0;
        }

        return solution(nums, index + 1, n, sum + nums[index], target)
                + solution(nums, index + 1, n, sum - nums[index], target);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solution(nums, 0, nums.length, 0, target);
    }
}