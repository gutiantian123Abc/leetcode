<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Hit Counter
Design a hit counter which counts the number of hits
received in the past 5 minutes.
Each function accepts a timestamp parameter (in seconds
granularity)
and you may assume that calls are being made to the system
in chronological order
(ie, the timestamp is monotonically increasing). You may
assume that the earliest timestamp starts at 1.
It is possible that several hits arrive roughly at the same
time.
Example:
HitCounter counter = new HitCounter();
// hit at timestamp 1.
counter.hit(1);
// hit at timestamp 2.
counter.hit(2);
// hit at timestamp 3.
counter.hit(3);
// get hits at timestamp 4, should return 3.
counter.getHits(4);
// hit at timestamp 300.
counter.hit(300);
// get hits at timestamp 300, should return 4.
counter.getHits(300);
// get hits at timestamp 301, should return 3.
counter.getHits(301);
*/
    /** Initialize your data structure here. */
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds
granularity). */
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds
granularity). */
/**
 * Your HitCounter object will be instantiated and called as
such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class HitCounter {
    private Queue<Integer> q;

    public HitCounter() {
        q = new LinkedList<Integer>();
    }
    
    public void hit(int timestamp) {
        if(!q.isEmpty()) {
            int minTime = q.peek();
            if(timestamp - minTime > 300) {
                q.poll();
            }  
        }
        
         q.offer(timestamp);        
    }
    
    public int getHits(int timestamp) {

        while(!q.isEmpty() && (timestamp - q.peek() >= 300)) {
            q.poll();
        }
        
        return q.size();
    }
}

</code></pre>
</div>
</div>
