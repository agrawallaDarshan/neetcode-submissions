class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>(); // cache the results
        for (int num: nums) set.add(num);
        int result = 0;
        for (int num: set) {
            int count = 1;
            if (map.containsKey(num + 1)) {
                count += map.get(num + 1);
            } else {
                int temp = num;
                while (set.contains(temp + 1)) {
                    count++;
                    temp++;
                }
            }
            map.put(num, count);
            result = Math.max(result, count);
        }
        return result;
    }
}
