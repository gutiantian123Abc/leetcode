<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Minimum Path Sum
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Notice
You can only move either down or right at any point in time.
*/
/* Time: O(mn)
   Space: O(n)
*/
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int minPathSum(int[][] grid) {
        // write your code here
        
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        
        
        int[][] f = new int[2][n];
        int now = 0, old = 0;
        
        for(int i = 0; i < m; i++) {
            old = now;
            now = 1 - now;
            for(int j = 0; j < n; j++) {
                int minPre = -1;
                if(i != 0) {
                    if(minPre == -1) {
                        minPre = f[old][j];
                    }
                }
                
                if(j != 0) {
                    if(minPre == -1) {
                        minPre = f[now][j - 1];
                    }else {
                        minPre = Math.min(minPre, f[now][j - 1]);
                    }
                }
                
                if(minPre == -1) {
                    minPre = 0;
                }
                
                f[now][j] = minPre + grid[i][j]; //记住， 永远是求f[newLine][j], f[oldLine][j]只是铺垫
            }
        }
        
        return f[now][n - 1];
    }
}</code></pre>
</div>
</div>
