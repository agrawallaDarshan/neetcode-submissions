class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) return 0;
        Arrays.sort(intervals, (nums1, nums2) -> {
            if (nums1[0] != nums2[0])
                return nums1[0] - nums2[0];
            else
                return nums1[1] - nums2[1];
        });
        int ans = 0;
        int current = 0, next = 1;
        while (next < intervals.length) {
            if (intervals[current][1] > intervals[next][0]) {
                if (intervals[current][1] >= intervals[next][1]) {
                    current = next;
                    next++;
                } else {
                    next++;
                }
                ans++;
            } else {
                current = next;
                next++;
            }
        }
        return ans;
    }
}