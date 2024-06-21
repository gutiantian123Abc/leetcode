<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 600px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Jump Game I
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Notice

This problem have two method which is Greedy and Dynamic Programming.

The time complexity of Greedy method is O(n).

The time complexity of Dynamic Programming method is O(n^2)

Example
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public boolean canJump(int[] A) {
        // wirte your code here
        
        boolean[] can = new boolean[A.length]; //长度不一定比原数组长，看情况：这里A[0]有意义
        can[0] = true;
        
        for(int i = 1; i < can.length; i++) {
            for(int j = 0; j < i; j++) {
                if(can[j] == true && j + A[j] >= i) {
                    can[i] = true;
                    break;
                }
            }
        }
        
        return can[A.length - 1];
    }
}
</code></pre>
</div>
</div>
