class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, (nums1, nums2) -> {
            if (nums1[0] == nums2[0])
                return nums1[1] - nums2[1];
            else
                return nums1[0] - nums2[0];
        });
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        // [1, 10] [2, 3] [4, 5] [6, 7] [8, 9]
        while (start < intervals.length) {
            int starti = intervals[start][0];
            int endi = intervals[start][1];
            while (start < intervals.length - 1 && endi >= intervals[start + 1][0]) {
                endi = Math.max(endi, intervals[start + 1][1]);
                start++;
            }
            result.add(Arrays.asList(starti, endi));
            start++;
        }
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i).get(0);
            ans[i][1] = result.get(i).get(1);
        }
        return ans;
    }
}