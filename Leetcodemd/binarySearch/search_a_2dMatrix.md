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
/* Search a 2D Matrix
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example
Consider the following matrix:

[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
Given target = 3, return true.

Challenge 
O(log(n) + log(m)) time
*/
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length < 1) {
            return false;
        }
        
        
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(target == matrix[mid][0]) {
                return true;
            }else if(target < matrix[mid][0]) {
                end = mid;
            }else {
                start = mid;
            }
        }
        
        int row = 0;
        if(matrix[start][0] <= target && matrix[start][n - 1] >= target) {
            row = start;
        }else if(matrix[end][0] <= target && matrix[end][n - 1] >= target) {
            row = end;
        }else {
            return false;
        }
        
        
        start = 0;
        end = n - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(target == matrix[row][mid]) {
                return true;
            }else if(target < matrix[row][mid]) {
                end = mid;
            }else {
                start = mid;
            }
        }
        
        if(matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }
        
        
        return false;
    }
}</code></pre>
</div>
</div>
