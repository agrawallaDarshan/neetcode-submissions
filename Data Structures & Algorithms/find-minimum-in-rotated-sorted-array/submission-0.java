class Solution {
    public void findDeflectionPoint(int low, int high, int[] nums, int[] deflectionPoint) {
        if (low > high) return;
        int mid = low + (high - low) / 2;
        if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
            deflectionPoint[0] = mid;
        } else {
            findDeflectionPoint(mid + 1, high, nums, deflectionPoint);
            if (deflectionPoint[0] == -1)
                findDeflectionPoint(low, mid - 1, nums, deflectionPoint);
        }
    }
    public int findMin(int[] nums) {
        // Find a mid such that mid > mid + 1; if no such mid exists, then the array is rotated
        // n or multiple of n times
        int[] deflectionPoint = new int[1];
        deflectionPoint[0] = -1;
        findDeflectionPoint(0, nums.length - 1, nums, deflectionPoint);
        if (deflectionPoint[0] == -1) return nums[0];
        else return nums[deflectionPoint[0] + 1];
    }
}
