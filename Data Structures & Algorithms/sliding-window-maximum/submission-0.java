class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int startIndex = 0;
        int index = 0;
        while (index < k) {
            pq.add(nums[index]);
            index++;
        }
        result[startIndex] = pq.peek();
        pq.remove(nums[startIndex]);
        startIndex++;
        while (index < nums.length) {
            pq.add(nums[index]);
            result[startIndex] = pq.peek();
            pq.remove(nums[startIndex]);
            index++;
            startIndex++;
        }
        return result;
    }
}
