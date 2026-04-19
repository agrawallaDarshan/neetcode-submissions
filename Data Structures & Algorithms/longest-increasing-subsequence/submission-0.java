class Solution {
    public int solution(int[] nums, int index, int lastElement, HashMap<String, Integer> dp) {
        if (index == nums.length)
            return 0;
        String dpKey = "" + index + lastElement;
        if (dp.containsKey(dpKey))
            return dp.get(dpKey);
        int lengthOfIS = -1;
        if (nums[index] > lastElement)
            lengthOfIS = 1 + solution(nums, index + 1, nums[index], dp);
        int value = Math.max(lengthOfIS, solution(nums, index + 1, lastElement, dp));
        dp.put(dpKey, value);
        return value;
    }

    public int lengthOfLIS(int[] nums) {
        HashMap<String, Integer> dp = new HashMap<>();
        return solution(nums, 0, Integer.MIN_VALUE, dp);
    }
}