class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
    int KthValue = -1;

    public KthLargest(int k, int[] nums) {
        KthValue = k;
        int index = 0;
        while (index < k && index < nums.length) {
            pq.add(nums[index]);
            index++;
        }

        while (index < nums.length) {
            if (nums[index] > pq.peek()) {
                pq.remove();
                pq.add(nums[index]);
            }
            index++;
        }
    }

    public int add(int val) {
        System.out.println(pq);
        if (pq.size() < KthValue)
            pq.add(val);
        else if (val > pq.peek()) {
            pq.remove();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */