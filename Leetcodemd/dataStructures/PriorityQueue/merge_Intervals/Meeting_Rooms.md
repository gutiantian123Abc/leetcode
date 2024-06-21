<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
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
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

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
}</code></pre>
</div>
</div>
