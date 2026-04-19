class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        int result = 0;
        for (int num: set) {
            int temp = num, count = 1;
            while (set.contains(temp + 1)) {
                count++;
                temp++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
