class Solution {
    public int maxSubArray(int[] nums) {
        int csum = nums[0];
        int osum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            csum = Math.max(csum + nums[i], nums[i]);
            osum = Math.max(osum, csum);
        }
        return osum;
    }
}