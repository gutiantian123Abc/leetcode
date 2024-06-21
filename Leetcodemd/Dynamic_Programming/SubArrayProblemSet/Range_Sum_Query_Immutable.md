<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 400px; margin: 50px; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 50px; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Range Sum Query - Immutable
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
*/
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class NumArray {
    //Mutable 看 Segment Tree
    int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for(int i = 1; i < preSum.length; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        return preSum[j + 1] - preSum[i];
    }
}

</code></pre>
</div>
</div>
