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
/* Jump GameGiven an array of non-negative integers, you are initially positioned at the first index of thearray.Each element in the array represents your maximum jump length at that position.Determine if you are able to reach the last index.NoticeThis problem have two method which is Greedy and Dynamic Programming.The time complexity of Greedy method is O(n).The time complexity of Dynamic Programming method is O(n^2).We manually set the small data set to allow you pass the test in both ways. This is just to let youlearn how to use this problem in dynamic programming ways.If you finish it in dynamic programming ways,you can try greedy method to make it accept again.ExampleA = [2,3,1,1,4], return true.A = [3,2,1,0,4], return false.*/    /**     * @param A: A list of integers     * @return: The boolean answer     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public boolean canJump(int[] A) {
        // wirte your code here
        //Greedy
        int farthest = 0;
        for(int i = 0; i < A.length; i++) {
            if(i <= farthest && farthest < i + A[i]) {
                farthest = i + A[i];
            }
        }
        
        return farthest >= A.length - 1;
    }
}

</code></pre>
</div>
</div>
