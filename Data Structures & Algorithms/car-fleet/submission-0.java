class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // sort the cars based on the position
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            List<Integer> pair = new ArrayList<>();
            pair.add(position[i]);
            pair.add(speed[i]);
            pairs.add(pair);
        }
        Collections.sort(pairs, (a, b) -> b.get(0) - a.get(0));
        Stack<Double> st = new Stack<>();
        for (int i = 0; i < pairs.size(); i++) {
            double time = (target - pairs.get(i).get(0)) / (pairs.get(i).get(1) * 1.0);
            if (st.isEmpty() || st.peek() < time) {
                st.add(time);
            }
        }
        return st.size();
    }
}
