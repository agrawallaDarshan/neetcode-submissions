class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int leftMax = height[0], rightMax = height[n - 1];
        int index = 1;
        while (index < n) {
            maxLeft[index] = leftMax;
            leftMax = Math.max(leftMax, height[index]);
            maxRight[n - 1 - index] = rightMax;
            rightMax = Math.max(rightMax, height[n - 1 - index]);
            index++;
        }
        int result = 0;
        for (int i = 1; i < n - 1; i++) {
            int maxBarSize = Math.min(maxLeft[i], maxRight[i]);
            if (height[i] < maxBarSize)
                result += maxBarSize - height[i];
        }
        return result;
    }
}
