class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (n > m)
            return findMedianSortedArrays(nums2, nums1);
        int total = (n + m + 1) / 2;
        int low = 0, high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = total - mid1;
            int l1 = mid1 - 1 >= 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int r1 = mid1 < n ? nums1[mid1] : Integer.MAX_VALUE;
            int l2 = mid2 - 1 >= 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = mid2 < m ? nums2[mid2] : Integer.MAX_VALUE;
            if (l1 > r2)
                high = mid1 - 1;
            else if (l2 > r1)
                low = mid1 + 1;
            else
                return (n + m) % 2 == 0 ? (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0 : Math.max(l1, l2);

        }
        return 0;
    }
}