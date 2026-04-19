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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 1) 
            return true;
        Collections.sort(intervals, (interval1, interval2) -> {
            if (interval1.start != interval2.start)
                return interval1.start - interval2.start;
            else
                return interval1.end - interval2.end;
        });
        int start = 0;
        while (start < intervals.size() - 1) {
            if (intervals.get(start).end > intervals.get(start + 1).start) return false;
            start++;
        }
        return true;
    }
}
