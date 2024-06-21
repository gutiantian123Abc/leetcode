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
/* Largest Triangle Area
You have a list of points in the plane.
Return the area of the largest triangle that can be formed by any 3 of the
points.
Example:
Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
Output: 2
Explanation:
The five points are show in the figure below. The red triangle is the largest.
Notes:
3 <= points.length <= 50.
No points will be duplicated.
 -50 <= points[i][j] <= 50.
Answers within 10^-6 of the true value will be accepted as correct.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
//讲解： 
// https://leetcode.com/problems/largest-triangle-area/discuss/122711/C++JavaPython-Solution-with-Explanation-and-Prove
class Solution {
    public double largestTriangleArea(int[][] points) {
        double res = 0;
        for (int[] i: points) {
            for (int[] j: points) {
                for (int[] k: points) {
                    res = Math.max(res, 0.5 * Math.abs(i[0] * j[1] + j[0] * k[1] + k[0] * i[1]- j[0] * i[1] - k[0] * j[1] - i[0]
                    * k[1]));
                }
            }            
        }
        return res;       
    }
}</code></pre>
</div>
</div>
