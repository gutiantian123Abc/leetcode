<style>
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Sqrt(x)
Implement int sqrt(int x).
Compute and return the square root of x.
Example
sqrt(3) = 1
sqrt(4) = 2
sqrt(5) = 2
sqrt(10) = 3

Challenge 
O(log(x))
*/
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int sqrt(int x) {
        // write your code here
        long start = 1, end = x;  // 注意long的使用
        
        while(start + 1 < end) { // Binary Search Format
            long mid = (start + end) / 2; // 就算 int x 是 Integer.MAX_VALUE, long 一样可以不overflow
            long result = mid * mid;
            if(result == x) {
                return (int)mid;
            }else if(result < x) {
                start = mid;
            }else {
                end = mid;
            }
        }
        if(end * end <= x) {  // Binary Search Format
            return (int)end;
        }
        return (int)start;
    }
}</code></pre>
</div>