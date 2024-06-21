<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 700px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Bomb EnemyGiven a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0'(the number zero), return the maximum enemies you can kill using one bomb.The bomb kills all the enemies in the same row and column from the plantedpoint until it hits the wall since the wall is too strong to be destroyed.You can only put the bomb at an empty cell.ExampleGiven a grid:0 E 0 0E 0 W E0 E 0 0return 3. (Placing a bomb at (1,1) kills 3 enemies)*/    /**     * @param grid Given a 2D grid, each cell is either 'W', 'E' or '0'     * @return an integer, the maximum enemies you can kill using one bomb     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//Space: mn, Time: mn
public class Solution {
    
    private boolean inBound(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public int maxKilledEnemies(char[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        
        for(int i = 0; i < m; i++) { //up
            for(int j = 0; j < n; j++) {
                up[i][j] = 0;
                if(grid[i][j] != 'W') {
                    if(grid[i][j] == 'E') {
                        up[i][j] = 1;
                    }
                    
                    if(i - 1 >= 0) {
                        up[i][j] += up[i - 1][j];
                    }
                }
            }
        }
        
        for(int i = m - 1; i >= 0; i--) {//down
            for(int j = 0; j < n; j++) {
                down[i][j] = 0;
                if(grid[i][j] != 'W') {
                    if(grid[i][j] == 'E') {
                        down[i][j] = 1;
                    }
                    
                    if(i + 1 < m) {
                        down[i][j] += down[i + 1][j];
                    }
                }
            }
        }
        
        for(int i = 0; i < m; i++) {//left
            for(int j = 0; j < n; j++) {
                left[i][j] = 0;
                if(grid[i][j] != 'W') {
                    if(grid[i][j] == 'E') {
                        left[i][j] = 1;
                    }
                    
                    if(j - 1 >= 0) {
                        left[i][j] += left[i][j - 1];
                    }
                }
            }
        }
        
        for(int i = 0; i < m; i++) {//right
            for(int j = n - 1; j >= 0; j--) {
                right[i][j] = 0;
                if(grid[i][j] != 'W') {
                    if(grid[i][j] == 'E') {
                        right[i][j] = 1;
                    }
                    
                    if(j + 1 < n) {
                        right[i][j] += right[i][j + 1];
                    }
                }
            }
        }
        
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '0') {
                    int ans = 0;
                    
                    int upX = i - 1, upY = j;
                    int downX = i + 1, downY = j;
                    int leftX = i, leftY = j - 1;
                    int rightX = i, rightY = j + 1;
                
                    if(inBound(upX, upY, m, n)) {//up
                        ans += up[upX][upY];
                    }
                
                    if(inBound(downX, downY, m, n)) {//down
                        ans += down[downX][downY];
                    }
                
                    if(inBound(leftX, leftY, m, n)) {//left
                        ans += left[leftX][leftY];
                    }
                
                    if(inBound(rightX, rightY, m, n)) {//right
                        ans += right[rightX][rightY];
                    }
                    
                    res = Math.max(res, ans);
                }
            }
        }
        
        return res;
    }
}</code></pre>
</div>
</div>
