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
/* The Smallest DifferenceGiven two array of integers(the first array is array A,the second array is array B), now we are going to find a element in array A which is A[i],and another element in array B which is B[j], so that the differencebetween A[i] and B[j] (|A[i] - B[j]|) is as small as possible, return their smallest difference.ExampleFor example, given array A = [3,6,7,4], B = [2,8,9,3], return 0ChallengeO(n log n) time*/    /**     * @param A: An integer array     * @param B: An integer array     * @return: Their smallest difference.     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        Arrays.sort(A);
        Arrays.sort(B);
        int min = Integer.MAX_VALUE;
        int ai = 0, bi = 0;
        while(ai < A.length && bi < B.length) {
            min = Math.min(min, Math.abs(A[ai] - B[bi]));
            if(A[ai] < B[bi]) {
                ai++;
            }else {
                bi++;
            }
        }
        
        return min;
    }
}</code></pre>
</div>
</div>
