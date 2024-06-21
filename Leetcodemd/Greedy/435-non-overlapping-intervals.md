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
/* 435. Non-overlapping Intervalshttps://leetcode.com/problems/non-overlapping-intervals/description/Given an array of intervals intervals where intervals[i] = [starti, endi],return the minimum number of intervals you need to remove to make therest of the intervals non-overlapping.Example 1:Input: intervals = [[1,2],[2,3],[3,4],[1,3]]Output: 1Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.Example 2:Input: intervals = [[1,2],[1,2],[1,2]]Output: 2Explanation: You need to remove two [1,2] to make the rest of the intervalsnon-overlapping.Example 3:Input: intervals = [[1,2],[2,3]]Output: 0Explanation: You don't need to remove any of the intervals since they'realready non-overlapping.Constraints:1 <= intervals.length <= 105intervals[i].length == 2-5 * 104 <= starti < endi <= 5 * 104*//* Tutorial:The primary reason to sort by end times first in this problemis to ensure that you are always considering the interval thatfinishes earliest as your first choice. This approach minimizesthe chance of overlap with subsequent intervals, as an intervalthat ends earlier frees up more space for others.Sorting by start time when end times are the same, however,is a secondary criterion and is less critical for the correctnessof the solution. The main idea behind this secondary sorting is tomaintain a consistent and predictable ordering of intervals thatshare the same end time. This can be helpful in certain edge cases,but for the majority of scenarios in this particular problem,it won't make a difference in the outcome.*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


class Solution {
    class Interval {
        int start;
        int end;
        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        int removedNum = 0;
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> {
            if(a.end == b.end) {
                return a.start - b.start; // doesn't matter a.start - b.start or b.start - a.start
            } else {
                return a.end - b.end;
            }
        });


        for(int i = 0; i < intervals.length; i++) {
            pq.offer(new Interval(intervals[i][0], intervals[i][1]));
        }

        Interval firstInterval = pq.poll();
        int prevEnd = firstInterval.end;
        
        while(!pq.isEmpty()) {
            Interval interval = pq.poll();
            int curStart = interval.start;
            int curEnd = interval.end;

            if(curStart < prevEnd) {
                removedNum++;
            } else {
                prevEnd = curEnd;
            }
        }

        return removedNum;
    }
}

</code></pre>
</div>
</div>
