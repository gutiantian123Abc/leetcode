<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Merge Two Sorted Interval Lists
Merge two sorted (ascending) lists of interval and return it as a new sorted list. 
The new sorted list should be made by splicing together the intervals of the two lists and sorted in ascending order.

Example
Given list1 = [(1,2),(3,4)] and list2 = [(2,3),(5,6)], return [(1,4),(5,6)].

Notice
The intervals in the given list do not overlap.
The intervals in different lists may overlap.
*/
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


//这道题的本质也是 Merge Overlapped Intervials

public class Solution {
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> res = new ArrayList<Interval>();
        
        // write your code here
        Comparator<Interval> comp = new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return b.end - a.end;
            }
        };
        
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(comp);
        
        int p1 = 0, p2 = 0;
        
        while(p1 < list1.size() && p2 < list2.size()) {
            Interval cur = null;
            Interval a = list1.get(p1);
            Interval b = list2.get(p2);
            
            if(pq.isEmpty()) {
                if(a.start < b.start) {
                    pq.offer(a);
                    p1++;
                }else {
                    pq.offer(b);
                    p2++;
                }
            }else {
                Interval prev = pq.poll();
                if(a.start < b.start) {
                    if(a.start <= prev.end) {
                        prev.end = Math.max(prev.end, a.end);
                    }else {
                        pq.offer(a);
                    }
                    pq.offer(prev);
                    p1++;
                }else {
                    if(b.start <= prev.end) {
                        prev.end = Math.max(prev.end, b.end);
                    }else {
                        pq.offer(b);
                    }
                    pq.offer(prev);
                    p2++;                   
                }
            }
        }
        
        while(p1 < list1.size()) {
            Interval cur = list1.get(p1);
            Interval prev = pq.poll();
            if(cur.start <= prev.end) {
                prev.end = Math.max(prev.end, cur.end);
            }else {
                pq.offer(cur);
            }
            
            pq.offer(prev);
            p1++;
        }
        
        while(p2 < list2.size()) {
            Interval cur = list2.get(p2);
            Interval prev = pq.poll();
            if(cur.start <= prev.end) {
                prev.end = Math.max(prev.end, cur.end);
            }else {
                pq.offer(cur);
            }
            
            pq.offer(prev);
            p2++;
        }       
        
        Stack<Interval> stack = new Stack<Interval>();
        
        while(!pq.isEmpty()) {
            stack.push(pq.poll());
        }
        
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }
        
        return res;
    }
}</code></pre>
</div>
</div>
