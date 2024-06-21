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
/* 354. Russian Doll Envelopes
You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
One envelope can fit into another if and only if both the width and height of one envelope 
is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3 
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int maxEnvelopes(int[][] envelopes) {   
        if(envelopes.length < 1) {
            return 0;
        }
        
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] A, int[] B) {//From small to large
                if(A[0] == B[0]) {
                    return A[1] - B[1];
                }else {
                    return A[0] - B[0];
                }
            }
        });
        
        int max = 1;
        
        int[] dp = new int[envelopes.length];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
            
        for(int i = 1; i < envelopes.length; i++) {
            int[] newEnv = envelopes[i];
            for(int j = 0; j < i; j++) {
                int[] oldEnv = envelopes[j];
                if(newEnv[0] > oldEnv[0] && newEnv[1] > oldEnv[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            max = Math.max(max, dp[i]);
            
        }
        
        return max;
        
    }
}</code></pre>
</div>
</div>
