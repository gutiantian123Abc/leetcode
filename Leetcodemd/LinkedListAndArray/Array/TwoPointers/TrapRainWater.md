<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container {{ max-width: 100%; margin: 0 auto; padding: 10px; }}
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Trapping Rain Water： http://www.lintcode.com/en/problem/trapping-rain-water/
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

Example
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Challenge 
O(n) time and O(1) memory
O(n) time and O(n) memory is also acceptable.
*/
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int trapRainWater(int[] heights) {
        // write your code here
        if(heights == null || heights.length < 1) {
            return 0;
        }
        int left = 0, right = heights.length - 1;
        int leftHeight = heights[left];
        int rightHeight = heights[right];
        int res = 0;
        while(left < right) {
            if(rightHeight > leftHeight) {
                left++;
                if(leftHeight > heights[left]) {
                    res += leftHeight - heights[left];
                }else {
                    leftHeight = heights[left];
                }
            }else {
                right--;
                if(rightHeight > heights[right]) {
                    res += rightHeight - heights[right];
                }else {
                    rightHeight = heights[right];
                }
            }
        }
        
        return res;
    }
}</code></pre>
</div>
</div>
