<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Moving Average from Data Stream (FIFO -> Queue)
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example
MovingAverage m = new MovingAverage(3);
m.next(1) = 1 // return 1.00000
m.next(10) = (1 + 10) / 2 // return 5.50000
m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
m.next(5) = (10 + 3 + 5) / 3 // return 6.00000
*/
    /*
    * @param size: An integer
    */public MovingAverage(int size) {
        // do intialization if necessary
        this.capcity = size;
        this.q = new LinkedList<Integer>();
        this.sum = 0;
    }

    /*
     * @param val: An integer
     * @return:  
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class MovingAverage {
    Queue<Integer> q;
    int capcity;
    double sum;
    public double next(int val) {
        // write your code here
        if(q.size() == capcity) {
            sum -= q.poll();
        }
        
        sum += val;
        q.offer(val);
        
        return sum / q.size();
    }
}</code></pre>
</div>
</div>
