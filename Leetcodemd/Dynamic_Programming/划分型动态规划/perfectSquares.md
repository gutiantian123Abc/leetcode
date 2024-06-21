<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*Perfect Squares 
Given a positive integer n, 
find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
Example
Given n = 12, return 3 because 12 = 4 + 4 + 4
Given n = 13, return 2 because 13 = 4 + 9
*/
    /**
     * @param n a positive integer
     * @return an integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int numSquares(int n) {
        // Write your code here
        if(n < 1) {
            return 0;
        }
        
        int[] f = new int[n + 1];//灵活运用长度
        Arrays.fill(f, Integer.MAX_VALUE);//注意
        
        for(int i = 0; i * i <= n; i++) {
            f[i * i] = 1;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                    f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        
        return f[n];
    }
}</code></pre>
</div>
</div>
