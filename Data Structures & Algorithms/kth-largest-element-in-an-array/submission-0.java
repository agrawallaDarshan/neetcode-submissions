class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        int index = 0;
        while (index < k) {
            pq.add(nums[index]);
            index++;
        }
        while (index < nums.length) {
            if (nums[index] > pq.peek()) {
                pq.poll();
                pq.add(nums[index]);
            }
            index++;
        }
        return pq.peek();
    }
}