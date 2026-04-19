/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 1) 
            return 1;
        Collections.sort(intervals, (interval1, interval2) -> {
            if (interval1.start != interval2.start)
                return interval1.start - interval2.start;
            else
                return interval1.end - interval2.end;
        });
        PriorityQueue<Integer> rooms = new PriorityQueue<Integer>((a, b) -> a - b); // end time of rooms
        int index = 0, ans = 0;
        while (index < intervals.size()) {
            Interval interval = intervals.get(index);
            while (!rooms.isEmpty() && rooms.peek() <= interval.start) {
                rooms.remove();
            }
            rooms.add(interval.end);
            ans = Math.max(ans, rooms.size());
            index++;
        }
        return ans;
    }
}
