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
/* Longest Increasing Subsequence
Given a sequence of integers, find the longest increasing subsequence (LIS).

You code should return the length of the LIS.

Clarification
What's the definition of longest increasing subsequence?

The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.

https://en.wikipedia.org/wiki/Longest_increasing_subsequence

Example
For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4

Challenge 
Time complexity O(n^2) or O(nlogn)
*/
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] f = new int[nums.length];
        f[0] = 1;
        int max = 1;
        for(int i = 1; i < nums.length; i++) { //接龙回马枪式
            f[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            
            if (f[i] > max) {
                max = f[i];
            }
        }
        
        return max;
    }
}
</code></pre>
</div>
</div>
