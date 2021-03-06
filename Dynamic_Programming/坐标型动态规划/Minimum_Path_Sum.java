/* Minimum Path Sum
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Notice
You can only move either down or right at any point in time.
*/

/* Time: O(mn)
   Space: O(n)
*/
public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
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
}