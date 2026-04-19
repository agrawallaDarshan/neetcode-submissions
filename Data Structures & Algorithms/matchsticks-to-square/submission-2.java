class Solution {
    // can we split the array into 4 buckets such that the sum of the elements in each bucket is equal
    public boolean solution(int[] nums, int index, int sum1, int sum2, int sum3, int sum4,
            HashMap<String, Boolean> dp) {
        if (index == nums.length) {
            return sum1 == sum2 && sum2 == sum3 && sum3 == sum4;
        }
        StringBuilder sb = new StringBuilder(index);
        String key = sb.append(sum1).append(sum2).append(sum3).append(sum4).toString();
        if (dp.containsKey(key))
            return dp.get(key);
        boolean result = false;
        result |= solution(nums, index + 1, sum1 + nums[index], sum2, sum3, sum4, dp)
                || solution(nums, index + 1, sum1, sum2 + nums[index], sum3, sum4, dp)
                || solution(nums, index + 1, sum1, sum2, sum3 + nums[index], sum4, dp)
                || solution(nums, index + 1, sum1, sum2, sum3, sum4 + nums[index], dp);
        dp.put(key, result);
        return result;
    }

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int stick : matchsticks)
            sum += stick;
        HashMap<String, Boolean> dp = new HashMap<>();
        return sum % 4 == 0 ? solution(matchsticks, 0, 0, 0, 0, 0, dp) : false;
    }
}