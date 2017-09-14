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

 
/* Meeting Rooms II

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

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

//这道题是 Merge all non-overlapping intervals!!!
class Solution {
    private Comparator<Interval> sort_com = new Comparator<Interval>() { //最早开始
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    };
    
    private Comparator<Interval> pq_com = new Comparator<Interval>() { //最早结束, min pq
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    };
    
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length < 1) {
            return 0; 
        }
        
        Arrays.sort(intervals, sort_com);
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(pq_com);
        pq.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            Interval prev = pq.poll(); //最早结束的
            Interval cur = intervals[i];
            if(cur.start < prev.end) { //如果下一场会议开始时间在最早结束会议之前， 就再开一个房间
                pq.offer(cur);
            }else {
                prev.end = cur.end; //如果下一场会议开始时间在最早结束会议之后， 就用这一个房间
            }
            pq.offer(prev);
        }
        
        return pq.size();
    }
}