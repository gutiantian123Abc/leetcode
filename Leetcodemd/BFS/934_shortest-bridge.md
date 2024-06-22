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
/* 934 shortest-bridge
https://leetcode.com/problems/shortest-bridge
You are given an n x n binary matrix grid where 1
represents land and 0 represents water.
An island is a 4-directionally connected group of
1's not connected to any other 1's.
There are exactly two islands in grid.
You may change 0's to 1's to connect the two
islands to form one island.
Return the smallest number of 0's you must flip to
connect the two islands.
Example 1:
Input: grid = [[0,1],[1,0]]
Output: 1
Example 2:
Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:
Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1]
,[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
Constraints:
n == grid.length == grid[i].length
2 <= n <= 100
grid[i][j] is either 0 or 1.
There are exactly two islands in grid.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {1, 0, -1, 0};

    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean islandOneMarkedToTwo = false;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] v = new boolean[m][n];
        int step = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    if(islandOneMarkedToTwo) { // marked
                        int[] index = {i, j};
                        queue.add(index);
                        v[i][j] = true;
                    }else { // not marked yet
                        changeColor(i, j, grid, 1, 2);
                        islandOneMarkedToTwo = true;
                    }
                }
            }
        }


        while(queue.size() != 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] curIndex = queue.poll();
                int x = curIndex[0];
                int y = curIndex[1];

                if(grid[x][y] == 2) {
                    return step - 1;
                }

                for(int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if(inRange(nx, ny, m, n) && grid[nx][ny] != 1 && !v[nx][ny]) {
                        int[] nextIndex = {nx, ny};
                        queue.add(nextIndex);
                        v[nx][ny] = true;
                    }
                }
            }
            step++;
        }

        return step - 1;
 
    }

    private void changeColor(int i, int j, int[][] grid, int sourceNum, int targetNum) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[i][j] == sourceNum) {
            grid[i][j] = targetNum;
            for(int dir = 0; dir < 4; dir++) {
                int nx = i + dx[dir];
                int ny = j + dy[dir];
                if(inRange(nx, ny, m, n)) {
                    changeColor(nx, ny, grid, sourceNum, targetNum);
                }  
            }
        }
    }

    private boolean inRange(int i , int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}






</code></pre>
</div>
</div>
