class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        result[n - 1] = 0;
        st.add(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int temp = temperatures[i];
            int currentMax = temperatures[st.peek()];
            if (temp >= currentMax) {
                boolean isResultFound = false;
                while (!st.isEmpty()) {
                    int index = st.peek();
                    if (temperatures[index] > temp) {
                        result[i] = index - i;
                        isResultFound = true;
                        break;
                    }
                    st.pop();
                }
                if (!isResultFound) result[i] = 0;
            } else {
                result[i] = st.peek() - i;
            }
            st.add(i);
        }
        return result;
    }
}
