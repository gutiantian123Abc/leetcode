<style>
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*
Given a collection of intervals, merge all overlapping intervals.
[                     [
  [1, 3],               [1, 6],
  [2, 6],      =>       [8, 10],
  [8, 10],              [15, 18]
  [15, 18]            ]
]
*/
/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
       if(intervals == null || intervals.size() <= 1) {
           return intervals;
       } 
        
       Collections.sort(intervals, new IntervalComparator());
       List<Interval> result = new ArrayList<Interval>(); 
       Interval last = intervals.get(0);
       for(int i = 1; i < intervals.size(); i++) {
           Interval curr = intervals.get(i);
           if(curr.start <= last.end) {
               last.end = Math.max(last.end, curr.end);
           }else{
               result.add(last);
               last = curr;
           }
       }
       result.add(last);
       return result;
    }
    
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
                return a.start - b.start;
        }
    }
}</code></pre>
</div>