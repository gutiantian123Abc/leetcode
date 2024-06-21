<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Jump Game II
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int jump(int[] A) {
        // write your code here
        int[] steps = new int[A.length];
        for(int i = 1; i < steps.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        
        steps[0] = 0;
        
        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < i; j++) {
                if(steps[j] !=  Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = Math.min(steps[j] + 1, steps[i]);
                }
            }
        }
        
        return steps[A.length - 1];
    }
}
</code></pre>
</div>
</div>
