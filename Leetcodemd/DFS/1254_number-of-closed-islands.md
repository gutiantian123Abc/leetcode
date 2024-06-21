<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 400px; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* https://leetcode.com/problems/number-of-closed-islands/description/

Given a 2D grid consists of 0s (land) and 1s (water).  
An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) 
surrounded by 1s.

Return the number of closed islands.

 

Example 1:



Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:



Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
 

Constraints:

1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int[] dx = {0, 1, -1, 0};
    public int[] dy = {1, 0, 0, -1};

    public int closedIsland(int[][] grid) {
        int num = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] v = new boolean[m][n];
        boolean[][] c = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && !v[i][j]) {
                    boolean isCloseToEdge = isCloseToEdge(i, j, grid, v, c);
                    if(!isCloseToEdge) {
                        num++;
                    }
                }
            }
        }

        return num;
    }

    private boolean isCloseToEdge(int i, int j, int[][] grid, boolean[][] v, boolean[][] c) {
        int m = grid.length;
        int n = grid[0].length;

        if(!isInRange(i, j, m, n)) {
            return true;
        }

        if(grid[i][j] == 1) {
            return false;
        }

        if (v[i][j]) {
            return c[i][j];
        }

        boolean isCloseToEdge = false;
        v[i][j] = true;

        for(int dir = 0; dir < 4; dir++) {
            int nx = i + dx[dir];
            int ny = j + dy[dir];
            isCloseToEdge |= isCloseToEdge(nx, ny, grid, v, c);
        }

        c[i][j] = isCloseToEdge;
        return isCloseToEdge;
    }


    private boolean isInRange(int i, int j , int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

}

</code></pre>
</div>
</div>
