<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 50px auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Longest Increasing Continuous Subsequence
Give an integer array，find the longest increasing continuous subsequence in this array.

An increasing continuous subsequence:

Can be from right to left or from left to right.
Indices of the integers in the subsequence should be continuous.

Example
For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
*/
    /*
     * @param : An array of Integer
     * @return: an integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


//Time: O(n), Space:O(1)
public class Solution {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if(A.length == 0) {
            return 0;
        }
        int res = 1;
        int maxPre = 1;
        
        for(int i = 1; i < A.length; i++) {
            if(A[i] > A[i - 1]) {
                maxPre += 1;
            }else {
                maxPre = 1;
            }
        
            res = Math.max(res, maxPre);
        }
        
        maxPre = 1;
        for(int i = A.length - 2; i >= 0; i--) {
            if(A[i] > A[i + 1]) {
                maxPre += 1;
            }else {
                maxPre = 1;
            }
            
            res = Math.max(res, maxPre);
            
            
        }
        
        return res;
    }
};</code></pre>
</div>
</div>
