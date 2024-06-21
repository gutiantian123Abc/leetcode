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
/* Container With Most Water : https://leetcode.com/problems/container-with-most-water/
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, 
the max area of water (blue section) the container can contain is 49.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
*/
/* Explain:
Algorithm

The intuition behind this approach is that the area formed between the lines will always be limited by the height of the shorter line.
Further, the farther the lines, the more will be the area obtained.
We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines.
Futher, we maintain a variable maxareamaxarea to store the maximum area obtained till now. At every step, 
we find out the area formed between them, update maxareamaxarea and move the pointer pointing to the shorter line towards the other end by one step.
How this approach works?

Initially we consider the area constituting the exterior most lines. 
Now, to maximize the area, we need to consider the area between the lines of larger lengths.
If we try to move the pointer at the longer line inwards, we won't gain any increase in area, 
since it is limited by the shorter line. But moving the shorter line's pointer could turn out to be beneficial, 
as per the same argument, despite the reduction in the width. This is done since a relatively longer 
line obtained by moving the shorter line's pointer might overcome the reduction in area caused by the width reduction.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while(l < r) {
            int max = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(max, maxArea);
            
            if(height[l] < height[r]) {
                l++;
            }else {
                r--;
            }
        }
        
        return maxArea;
    }
}</code></pre>
</div>
</div>
