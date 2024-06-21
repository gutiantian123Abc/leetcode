<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 700px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
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


//这道题的本质是 Merge overlapping intervals!!!
class Solution {
    private Comparator<Interval> sort_com = new Comparator<Interval>() {
      public int compare(Interval a, Interval b) { //最早开始排序
          return a.start - b.start;
      }  
    };
    
    private Comparator<Interval> pq_com = new Comparator<Interval>() { //最晚结束， max pq
      public int compare(Interval a, Interval b) {
          return b.end - a.end;
      }  
    };    
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<Interval>();
        if(intervals == null || intervals.size() < 1) {
            return ans;
        }
        Collections.sort(intervals, sort_com);
        
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(pq_com);
        
        pq.offer(intervals.get(0));
        
        for(int i = 1; i < intervals.size(); i++) {
            Interval prev = pq.poll();//最晚结束
            Interval cur = intervals.get(i);
            if(cur.start <= prev.end) {
                prev.end = Math.max(cur.end, prev.end);
            }else {
                pq.offer(cur);
            }
            
            pq.offer(prev);
        }
        
        while(!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        
        return ans; 
    }
}</code></pre>
</div>
</div>
