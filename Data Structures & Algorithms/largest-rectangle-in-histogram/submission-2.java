class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        st.add(n - 1);
        right[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()])
                st.pop();
            right[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
            st.add(i);
        }
        int[] left = new int[n];
        st = new Stack<>();
        left[0] = -1;
        st.add(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()])
                st.pop();
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.add(i);
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        int ans = -1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i]) * heights[i]);
        }
        return ans;
    }
}