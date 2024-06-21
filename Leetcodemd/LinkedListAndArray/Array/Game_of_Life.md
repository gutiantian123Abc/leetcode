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
/* Game of LifeAccording to the Wikipedia's article: "The Game of Life, also known simplyas Life,is a cellular automaton devised by the British mathematician John HortonConway in 1970."Given a board with m by n cells, each cell has an initial state live (1) ordead (0).Each cell interacts with its eight neighbors (horizontal, vertical,diagonal) using thefollowing four rules (taken from the above Wikipedia article):Any live cell with fewer than two live neighbors dies, as if caused byunder-population.Any live cell with two or three live neighbors lives on to the nextgeneration.Any live cell with more than three live neighbors dies, as if by over-population..Any dead cell with exactly three live neighbors becomes a live cell, as ifby reproduction.Write a function to compute the next state (after one update) of the boardgiven its current state.*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    private class Pair {
        int prev = 0;
        int next = 0;
        public Pair(int prev, int next) {
            this.prev = prev;
            this.next = next;
        }
    }
    
    int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    int[] dy = {1, -1, 0, 0, 1,  -1, 1, -1};
    
    private boolean inBound(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    
    private int neighbor_num(int i, int j, Pair[][] A, int m, int n) {
        int count = 0;
        for(int dir = 0; dir < 8; dir++) {
            int nx = i + dx[dir];
            int ny = j + dy[dir];
            if(inBound(nx, ny, m, n)) {
                count += A[nx][ny].prev;
            }
        }
        return count;
    }
    
    public void gameOfLife(int[][] board) {
        if(board == null || board.length < 1 || board[0].length < 1) {
            return;
        }
        
        int m = board.length, n = board[0].length;
        
        Pair[][] A = new Pair[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                A[i][j] = new Pair(board[i][j], 0); //一定要注意initialize !!!
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int neighbor_count = neighbor_num(i, j, A, m, n);
                if(A[i][j].prev == 1) { //live 
                    if(neighbor_count < 2) {
                        A[i][j].next = 0;
                    }else if(neighbor_count == 2 || neighbor_count == 3) {
                        A[i][j].next = 1;
                    }else {
                        A[i][j].next = 0;
                    }  
                }else {
                    if(neighbor_count == 3) {
                        A[i][j].next = 1;
                    }else {
                        A[i][j].next = 0;
                    }
                }
            }
        }       
         
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = A[i][j].next;
            }
        }    
    }
}</code></pre>
</div>
</div>
