<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Unique Paths
A robot is located at the top-left corner of a m x n grid.
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
How many possible unique paths are there?
Notice
m and n will be at most 100.
Example
Given m = 3 and n = 3, return 6.
Given m = 4 and n = 5, return 35.
*/
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
/* Unique Paths II
Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

m and n will be at most 100.

Example

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
*/
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//Normal method: Time: O(mn), Space: O(mn)
public class Solution {
    public int uniquePaths(int m, int n) {
        // write your code here 
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        
        for(int i = 1; i < m; i++) {
            grid[i][0] = 1;
        }
        
        for(int j = 1; j < n; j++) {
            grid[0][j] = 1;
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        
        return grid[m-1][n-1];
        
    }
}

//Space saving method: Space: O(n)Time: O(mn)
public class Solution {
    public int uniquePaths(int m, int n) {
        // write your code he
        int[][] f = new int[2][n];
        int oldLine = 0, newLine = 0;
        
        for(int i = 0; i < m; i++) {
            oldLine = newLine;//两行交替法
            newLine = 1 - newLine;
            
            for(int j = 0; j < n; j++) {

                f[newLine][j] = 0;//这一步是必须的， 因为后面有 +=

                if(i == 0 && j == 0) {
                    f[newLine][j] = 1;
                }
                
                if(i > 0) {
                    f[newLine][j] += f[oldLine][j];
                }
                
                if(j > 0) {
                    f[newLine][j] += f[newLine][j - 1];
                }
             
            }
        }
        
        return f[newLine][n - 1];
    }
}













public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] arr = new int[m][n];
  
        
        for(int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1) {
                break;
            }else {
                arr[i][0] = 1;
            }
        }
        
        for(int j = 0; j < n; j++) {
            if(obstacleGrid[0][j] == 1) {
                break;
            }else {
                arr[0][j] = 1;
            }
        }
        
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    continue;
                }else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        
        return arr[m - 1][n - 1];
    }
}

//Space saving version: Space: O(n)
public class Solution {
    public int uniquePathsWithObstacles(int[][] c) {
        // write your code here
        if(c == null || c.length == 0 || c[0].length == 0) {
            return 0;
        }
        
        int m = c.length;
        int n = c[0].length;
        
        
        if (c[0][0] == 1 || c[m-1][n-1] == 1) {
            return 0;
        }

        int[][] f = new int [2][n];
        int oldLine = 0, newLine = 0;
        
        
        for(int i = 0; i < m; i++) {
            oldLine = newLine;//两行交替法
            newLine = 1 - newLine;
            
            for(int j = 0; j < n; j++) {
                
                if(c[i][j] == 1) {
                    f[newLine][j] = 0;
                }else {
                    
                    f[newLine][j] = 0;//这一步是必须的， 因为后面有 +=
                    
                    if(i == 0 && j == 0) {
                        f[newLine][j] = 1;
                    }
                    
                    if(i > 0) {
                        f[newLine][j] += f[oldLine][j];
                    }
                    
                    if(j > 0) {
                        f[newLine][j] += f[newLine][j - 1];
                    }
            
                }
            }
        }
        
        return f[newLine][n - 1];
    }
}


</code></pre>
</div>
</div>
