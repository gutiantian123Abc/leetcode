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
/* Reverse Integer
Reverse digits of an integer. Returns 0 when the
reversed integer overflows (signed 32-bit
integer).
Example
Given x = 123, return 321
Given x = -123, return -321
Note:
Have you thought about this? Here are some good
questions to ask before coding.
Bonus points for you if you have already thought
through this!
If the integer's last digit is 0, what should the
output be? ie, cases such as 10, 100 ?
If 100, then should be 1
Did you notice that the reversed integer might
overflow? Assume the input is a 32-bit integer,
then the reverse of 1000000003 overflows. How
should you handle such cases? Return 0
*/
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int reverseInteger(int n) {
        int result = 0;

        while (n != 0)
        {
            int tail = n % 10;
            int newResult = result * 10 + tail;
            
            // 防止overflow
            if ((newResult - tail) / 10 != result) {
                return 0; }
            result = newResult;
            n = n / 10;
        }

        return result;
    }
}</code></pre>
</div>
</div>
