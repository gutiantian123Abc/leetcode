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
/*
https://leetcode.com/problems/container-with-most-
water/
You are given an integer array height of length n.
There are n vertical lines drawn such that the two
endpoints of the
ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form
a container,
such that the container contains the most water.
Return the maximum amount of water a container can
store.
Notice that you may not slant the container.
Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are
represented by array
[1,8,6,2,5,4,8,3,7]. In this case, the max area of
water (blue section)
the container can contain is 49.
Example 2:
Input: height = [1,1]
Output: 1
Constraints:
n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxVal = 0;

        int left = 0;
        int right = n -1;

        while(left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            maxVal = Math.max(maxVal, w*h);
            if(height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        

        return maxVal;
    }
}
</code></pre>
</div>
</div>
