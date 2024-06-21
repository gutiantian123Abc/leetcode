<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 600px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*Paths of target Sum

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.

*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        bt(nums, target, 0, 0);
        return count;
    }
    
    private void bt(int[] nums, int target, int index, int sum) {
        if(index == nums.length) {
            if(sum == target) {
                count++;
            }
            return;
        }
        
        // Try +
        sum += nums[index];
        bt(nums, target, index + 1, sum);
        sum -= nums[index];
        
        // Try -
        sum -= nums[index];
        bt(nums, target, index + 1, sum);
        sum += nums[index];
    }
}




</code></pre>
</div>
</div>
