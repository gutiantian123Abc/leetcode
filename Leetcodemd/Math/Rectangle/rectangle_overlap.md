<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 80%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 836. Rectangle Overlap
https://leetcode.com/problems/rectangle-overlap/

An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], 
where (x1, y1) is the coordinate of its bottom-left corner, 
and (x2, y2) is the coordinate of its top-right corner. 
Its top and bottom edges are parallel to the X-axis, 
and its left and right edges are parallel to the Y-axis.

Two rectangles overlap if the area of their intersection is positive. 
To be clear, two rectangles that only touch 
at the corner or edges do not overlap.

Given two axis-aligned rectangles rec1 and rec2, 
return true if they overlap, otherwise return false.

 

Example 1:

Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
Example 2:

Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false
Example 3:

Input: rec1 = [0,0,1,1], rec2 = [2,2,3,3]
Output: false
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int ax1 = rec1[0], ay1 = rec1[1], ax2 = rec1[2], ay2 = rec1[3];
        int bx1 = rec2[0], by1 = rec2[1], bx2 = rec2[2], by2 = rec2[3];
        
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        
        return left < right && bottom < top;
    }
}</code></pre>
</div>
</div>
