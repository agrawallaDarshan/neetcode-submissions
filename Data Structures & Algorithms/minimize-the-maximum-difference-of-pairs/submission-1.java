class Solution {
    public boolean canFormPairs(int[] nums, int p, int target) {
        // 1 1 2 3 7 10
        int count = 0;
        int index = 0;
        while (index + 1 < nums.length) {
            if (nums[index + 1] - nums[index] <= target) {
                count++;
                index += 2;
            } else {
                index++;
            }
        }
        return count >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length, low = 0, high = nums[n - 1];
        int result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFormPairs(nums, p, mid)) {
                high = mid - 1;
                result = mid;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}