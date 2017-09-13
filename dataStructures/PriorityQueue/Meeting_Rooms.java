/* Meeting Rooms I
Given an array of meeting time intervals consisting of start and end times 
[[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    private Comparator<Interval> com = new Comparator<Interval>() {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    };
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length < 1) {
            return true;
        }
        Arrays.sort(intervals, com);
        int latest_end = intervals[0].end;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start < latest_end) {
                return false;
            }
            
            latest_end = Math.max(latest_end, intervals[i].end);
        }
        
        return true;        
    }
}