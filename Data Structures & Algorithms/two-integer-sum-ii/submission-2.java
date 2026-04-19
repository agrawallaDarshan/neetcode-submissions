class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int right = 1;
        int[] result = new int[2];
        while (right < n) {
            int left = 0;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    result[0] = left + 1;
                    result[1] = right + 1;
                    return result;
                }
                if (sum < target) left++;
                else break;
            }
            right++;
        }
        return result;
    }
}
