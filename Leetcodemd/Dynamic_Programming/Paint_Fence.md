<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 700px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 514. Paint FenceThere is a fence with n posts, each post can be painted with one of the k colors.You have to paint all the posts such that no more than two adjacent fence posts have the same color.Return the total number of ways you can paint the fence.ExampleGiven n=3, k=2 return 6      post 1,   post 2, post 3way1    0         0       1way2    0         1       0way3    0         1       1way4    1         0       0way5    1         0       1way6    1         1       0*/    /**     * @param n: non-negative integer, n posts     * @param k: non-negative integer, k colors     * @return: an integer, the total number of ways     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int numWays(int n, int k) {
        // write your code here
        if(n == 0 || k == 0) {
            return 0;
        }
        if(n == 1) {
            return k;
        }
// same[i] means the ith post has the same color with the (i-1)th post.
// diff[i] means the ith post has a different color with the (i-1)th post.
        int[] same = new int[n];
        int[] diff = new int[n];
        //前两个要initialize完全是试出来的
        same[0] = k;//出于n==2时的需要
        same[1] = k;//出于n==2时的需要
        diff[0] = k;//出于n==2时的需要
        diff[1] = (k - 1) * k;//出于n==2时的需要
        
        for(int i = 2; i < same.length; i++) {
            same[i] = diff[i - 1];
            diff[i] = (k - 1) * diff[i - 1] + (k - 1) * same[i - 1];
        }
        
        return diff[n - 1] + same[n - 1];
    }
}</code></pre>
</div>
</div>
