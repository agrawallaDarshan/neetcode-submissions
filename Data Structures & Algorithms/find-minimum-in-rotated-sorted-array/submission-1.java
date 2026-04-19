class Solution {
    public int findMin(int[] nums) {
        // DECIDE WHICH HALF TO GO
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid + 1 < n && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (mid - 1 > 0 && nums[mid - 1] > nums[mid]) return nums[mid];
            if (nums[mid] > nums[low]) low = mid + 1;
            else high = mid - 1;
        }
        return nums[0];
    }
}
