class Solution {
    public int findGreatestSmallestElement(int[][] intervals, int target) {
        int low = 0, high = intervals.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target <= intervals[mid][1] && target >= intervals[mid][0])
                return mid;
            if (target > intervals[mid][1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public int findSmallestGreatestElement(int[][] intervals, int target) {
        int low = 0, high = intervals.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target >= intervals[mid][0] && target <= intervals[mid][1])
                return mid;
            if (target < intervals[mid][0])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] arr = { { newInterval[0], newInterval[1] } };
            return arr;
        }
        int index1 = findGreatestSmallestElement(intervals, newInterval[0]);
        int index2 = findSmallestGreatestElement(intervals, newInterval[1]);
        int starti = newInterval[0] > intervals[index1][1] ? newInterval[0]
                : Math.min(intervals[index1][0], newInterval[0]);
        int endi = newInterval[1] < intervals[index2][0] ? newInterval[1]
                : Math.max(intervals[index2][1], newInterval[1]);
        List<List<Integer>> finalList = new ArrayList<>();
        int index = 0;
        while (index < intervals.length) {
            List<Integer> interval = new ArrayList<>();
            if (intervals[index][0] >= starti && intervals[index][1] <= endi) {
                index++;
                continue;
            }
            interval.add(intervals[index][0]);
            interval.add(intervals[index][1]);
            finalList.add(interval);
            index++;
        }
        index = 0;
        boolean isInserted = false;
        int[][] result = new int[finalList.size() + 1][2];
        for (List<Integer> list : finalList) {
            if (!isInserted && endi < list.get(0)) {
                result[index][0] = starti;
                result[index][1] = endi;
                isInserted = true;
                index++;
            }
            result[index][0] = list.get(0);
            result[index][1] = list.get(1);
            index++;
        }
        if (!isInserted) {
            result[index][0] = starti;
            result[index][1] = endi;
        }
        return result;
    }
}