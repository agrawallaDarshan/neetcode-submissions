class Solution {
    public int largestRectangleArea(int[] heights) {
        // store the index of the smallest number greater than the current number from left and right
        // [2,1,5,6,2,3]
        Stack<Integer> st = new Stack<>();
        int[] left = new int[heights.length];
        st.push(0);
        // 5 5 5 5 5
        for (int i = 1; i < heights.length; i++) {
            int lastIndex = i;
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                lastIndex = st.pop();
            }
            left[i] = st.isEmpty() ? 0 : st.peek() + 1;
            if (st.isEmpty() || heights[st.peek()] != heights[i]) {
                st.push(i);
            }
        }
        int[] right =  new int[heights.length];
        st = new Stack<>();
        right[heights.length - 1] = heights.length - 1;
        st.push(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--) {
            int lastIndex = i;
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                lastIndex = st.pop();
            }
            right[i] = st.isEmpty() ? heights.length - 1 : st.peek() - 1;
            if (st.isEmpty() || heights[st.peek()] != heights[i]) {
                st.push(i);
            }
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int totalArea = Math.min(heights[i], Math.min(heights[left[i]], heights[right[i]])) * (right[i] - left[i] + 1);
            maxArea = Math.max(maxArea, totalArea);
        }
        return maxArea;
    }
}