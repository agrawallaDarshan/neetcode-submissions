class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            if (st.isEmpty() || asteroid > 0)
                st.add(asteroid);
            else {
                boolean isAsteroidExists = true;
                while (!st.isEmpty() && asteroid < 0 && st.peek() > 0) {
                    int collision = st.pop();
                    if (collision >= Math.abs(asteroid)) {
                        if (collision != Math.abs(asteroid))
                            st.add(collision);
                        isAsteroidExists = false;
                        break;
                    }
                }
                if (isAsteroidExists) {
                    st.add(asteroid);
                }
            }
        }
        int[] result = new int[st.size()];
        int index = st.size() - 1;
        while (!st.isEmpty()) {
            result[index--] = st.pop();
        }
        return result;
    }
}