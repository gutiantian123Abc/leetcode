<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 500px; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Pacific Atlantic Water Flow
Given an m x n matrix of non-negative integers representing the height of 
each unit cell in a continent, the "Pacific ocean" touches the left and top edges 
of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) 
from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:
[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] 
(positions with parentheses in above matrix).
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


//DFS
class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix == null) {
            return null;
        }     
        
        List<int[]> ans = new ArrayList<int[]>();
        if(matrix.length < 1 || matrix[0].length < 1) {
            return ans;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] is_P = new boolean[m][n];
        boolean[][] is_A = new boolean[m][n];
        
        boolean[][] visited_P = new boolean[m][n];
        boolean[][] visited_A = new boolean[m][n];
        
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(row == 0 || col == 0) {
                    is_P[row][col] = true;
                }
                
                if(row == m - 1 || col == n - 1) {
                    is_A[row][col] = true;
                }
            }
        }
               
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(is_P[row][col]) {
                    dfs_P(row, col, matrix, is_P, visited_P);
                }
                
                if(is_A[row][col]) {
                    dfs_A(row, col, matrix, is_A, visited_A);
                }
            }
        }
        
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(is_P[row][col] && is_A[row][col]) {
                    int[] entry = new int[2];
                    entry[0] = row;
                    entry[1] = col;
                    ans.add(entry);
                }
            }
        }
        
        return ans;        
    }
    
    private void dfs_P(int row, int col, int[][] matrix, boolean[][] is_P, boolean[][] visited_P) {
        if(visited_P[row][col]) {
            return;
        }
        is_P[row][col] = true;
        visited_P[row][col] = true;
        int m = matrix.length, n = matrix[0].length;
        for(int dir = 0; dir < 4; dir++) {
            int n_row = row + dx[dir];
            int n_col = col + dy[dir];
            if(inRange(n_row, n_col, m, n)) {
                if(matrix[n_row][n_col] >= matrix[row][col]) {
                    dfs_P(n_row, n_col, matrix, is_P, visited_P);
                }
            }
        }
    }
    
    private void dfs_A(int row, int col, int[][] matrix, boolean[][] is_A, boolean[][] visited_A) {
        if(visited_A[row][col]) {
            return;
        }
        is_A[row][col] = true;
        visited_A[row][col] = true;
        int m = matrix.length, n = matrix[0].length;
        for(int dir = 0; dir < 4; dir++) {
            int n_row = row + dx[dir];
            int n_col = col + dy[dir];
            if(inRange(n_row, n_col, m, n)) {
                if(matrix[n_row][n_col] >= matrix[row][col]) {
                    dfs_P(n_row, n_col, matrix, is_A, visited_A);
                }
            }
        }
    }
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    private boolean inRange(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
 }







 //BFS
 class Solution {
    private class Pair {
        int row = 0;
        int col = 0;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix == null) {
            return null;
        }     
        
        List<int[]> ans = new ArrayList<int[]>();
        if(matrix.length < 1 || matrix[0].length < 1) {
            return ans;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] is_P = new boolean[m][n];
        boolean[][] is_A = new boolean[m][n];
        
        boolean[][] visited_P = new boolean[m][n];
        boolean[][] visited_A = new boolean[m][n];
        
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(row == 0 || col == 0) {
                    is_P[row][col] = true;
                }
                
                if(row == m - 1 || col == n - 1) {
                    is_A[row][col] = true;
                }
            }
        }
               
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(is_P[row][col]) {
                    bfs_P(row, col, matrix, is_P, visited_P);
                }
                
                if(is_A[row][col]) {
                    bfs_A(row, col, matrix, is_A, visited_A);
                }
            }
        }
        
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(is_P[row][col] && is_A[row][col]) {
                    int[] entry = new int[2];
                    entry[0] = row;
                    entry[1] = col;
                    ans.add(entry);
                }
            }
        }
        
        return ans;        
    }
    
    private void bfs_P(int row, int col, int[][] matrix, boolean[][] is_P, boolean[][] visited_P) {
        if(visited_P[row][col]) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        
        visited_P[row][col] = true;
      
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(row, col));
        
        while(queue.size() != 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                int cur_row = cur.row;
                int cur_col = cur.col;
                for(int dir = 0; dir < 4; dir++) {
                    int n_row = cur_row + dx[dir];
                    int n_col = cur_col + dy[dir];
                    if(inRange(n_row, n_col, m, n)) {
                        if(!visited_P[n_row][n_col] && matrix[n_row][n_col] >= matrix[cur_row][cur_col]) {
                            visited_P[n_row][n_col] = true;
                            is_P[n_row][n_col] = true;
                            queue.offer(new Pair(n_row, n_col)); 
                        }
                    }
                }
            }
        }
    }
    
    private void bfs_A(int row, int col, int[][] matrix, boolean[][] is_A, boolean[][] visited_A) {
        if(visited_A[row][col]) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        
        visited_A[row][col] = true;
        
        
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(row, col));
        
        while(queue.size() != 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                int cur_row = cur.row;
                int cur_col = cur.col;
                for(int dir = 0; dir < 4; dir++) {
                    int n_row = cur_row + dx[dir];
                    int n_col = cur_col + dy[dir];
                    if(inRange(n_row, n_col, m, n)) {
                        if(!visited_A[n_row][n_col] && matrix[n_row][n_col] >= matrix[cur_row][cur_col]) {
                            visited_A[n_row][n_col] = true;
                            is_A[n_row][n_col] = true;
                            queue.offer(new Pair(n_row, n_col)); 
                        }
                    }
                }
            }
        }
    }
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    private boolean inRange(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
 }</code></pre>
</div>
</div>
