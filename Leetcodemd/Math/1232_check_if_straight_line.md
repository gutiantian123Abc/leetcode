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
https://leetcode.com/problems/check-if-it-is-a-
straight-line/description/
You are given an array coordinates, coordinates[i]
= [x, y], where [x, y] represents the coordinate
of a point. Check if these points make a straight
line in the XY plane.
Example 1:
Input: coordinates =
[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:
Input: coordinates =
[[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
Constraints:
2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <=
10^4
coordinates contains no duplicate point.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0]; 
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        for(int i = 2; i < coordinates.length; i++ ) {
            int xn = coordinates[i][0];
            int yn = coordinates[i][1];

            if (((xn - x0) * (y1 - y0)) != ((yn - y0) * (x1 - x0))) {
                return false;
            }

        }

        return true;
        
    }
}</code></pre>
</div>
</div>
