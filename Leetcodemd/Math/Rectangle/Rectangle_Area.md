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
/* Rectangle Area
https://leetcode.com/problems/rectangle-area/
Find the total area covered by two rectilinear rectangles in a 2D plane.
Each rectangle is defined by its bottom left corner and top right corner as
shown in the figure.
Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
//https://leetcode.com/problems/rectangle-area/description/
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaRec1 = (ax2 - ax1) * (ay2 - ay1);
        int areaRec2 = (bx2 - bx1) * (by2 - by1);
        
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        
        int overlapArea = 0;
        if(left < right && bottom < top) {
            overlapArea = (right - left) * (top - bottom);
        }
        
        return areaRec1 + areaRec2 - overlapArea;
    }
}</code></pre>
</div>
</div>
