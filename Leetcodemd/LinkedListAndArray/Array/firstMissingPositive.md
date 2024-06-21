<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* First Missing Positive
Given an unsorted integer array, find the first missing positive integer.

Example
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A == null ) {
            return 1;
        }
        
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != i + 1) {
                if (A[A[i] - 1] == A[i]) {
                    break;
                }
                swap(A, A[i] - 1, i);
            }
        }
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) {
                return i + 1;
            }
        }
        
        return A.length + 1;
    }
    
    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}</code></pre>
</div>
</div>
