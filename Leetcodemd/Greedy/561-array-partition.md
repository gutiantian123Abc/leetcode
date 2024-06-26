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
/* 561. Array Partition
https://leetcode.com/problems/array-
partition/description/
Given an integer array nums of 2n integers, group
these integers
into n pairs (a1, b1), (a2, b2), ..., (an, bn)
such that the sum
of min(ai, bi) for all i is maximized. Return the
maximized sum.
Example 1:
Input: nums = [1,4,3,2]
Output: 4
Explanation: All possible pairings (ignoring the
ordering of elements) are:
1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2
= 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2
= 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3
= 4
So the maximum possible sum is 4.
Example 2:
Input: nums = [6,2,6,5,1,2]
Output: 9
Explanation: The optimal pairing is (2, 1), (2,
5), (6, 6). min(2, 1) +
min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
Constraints:
1 <= n <= 104
nums.length == 2 * n
-104 <= nums[i] <= 104
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int arrayPairSum(int[] nums) {
        int i = nums.length - 1;
        int sum = 0;
        Arrays.sort(nums);

        while(i > 0) {
            sum += Math.min(nums[i], nums[i - 1]);
            i -= 2;
        }

        return sum;
    }
}</code></pre>
</div>
</div>
