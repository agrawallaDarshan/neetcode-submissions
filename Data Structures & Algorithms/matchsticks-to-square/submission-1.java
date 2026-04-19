class Solution {
    // can we split the array into 4 buckets such that the sum of the elements in each bucket is equal
    public boolean solution(int[] nums, int index, int sum1, int sum2, int sum3, int sum4) {
        // System.out.println("index = " + index);
        if (index == nums.length) {
            return sum1 == sum2 && sum2 == sum3 && sum3 == sum4;
        }
        boolean result = false;
        result |= solution(nums, index + 1, sum1 + nums[index], sum2, sum3, sum4)
                || solution(nums, index + 1, sum1, sum2 + nums[index], sum3, sum4)
                || solution(nums, index + 1, sum1, sum2, sum3 + nums[index], sum4)
                || solution(nums, index + 1, sum1, sum2, sum3, sum4 + nums[index]);
        return result;
    }

    public boolean makesquare(int[] matchsticks) {
        return solution(matchsticks, 0, 0, 0, 0, 0);
    }
}