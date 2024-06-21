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
/* 1351. Count Negative Numbers in a Sorted Matrix
https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
Example 3:

Input: grid = [[1,-1],[-1,-1]]
Output: 3
Example 4:

Input: grid = [[-1]]
Output: 1
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
 

Follow up: Could you find an O(n + m) solution?
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            count += countNeg(grid[i]);
        }
        
        return count;
    }
    
    private int countNeg(int[] grid) {
        int start = 0, end = grid.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(grid[mid] >= 0) {
                start = mid;
            }else  {
                end = mid;
            }
        }
        
        if(grid[start] < 0) {
            return grid.length - start;
        }else if(grid[end] < 0) {
            return grid.length - end;
        }
        
        return 0;
    }
}</code></pre>
</div>
</div>
