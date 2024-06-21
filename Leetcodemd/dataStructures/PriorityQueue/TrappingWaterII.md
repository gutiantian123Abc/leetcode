<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 500px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Trapping Rain Water II
Given n x m non-negative integers representing an elevation map 2d where the area of each cell is 1 x 1, 
compute how much water it is able to trap after raining.

Example
Given 5*4 matrix

[12,13,0,12]
[13,4,13,12]
[13,8,10,12]
[12,13,12,12]
[13,13,13,13]
return 14.
*/
/* 注水问题， 从外向内， 从最短板往里灌水， BFS, 具体解释: http://www.cnblogs.com/grandyang/p/5928987.html
题目比较困难， 理解即可
*/
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


public class Solution {
     //http://www.cnblogs.com/grandyang/p/5928987.html
    public class Cell {
        public int r, c, h;
        public Cell(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }
    
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    
    private Comparator<Cell> min_heap_compartor = new Comparator<Cell>() { //minHeap
        public int compare(Cell a, Cell b ) {
            if(a.h > b.h) {
                return 1;
            }else if(a.h < b.h) {
                return -1;
            }else {
                return 0;
            }
        }
    };
    
    private boolean qualified(int r, int c, int m, int n, boolean[][] visited) {
        if(r < 0 || r >= m || c < 0 || c >= n || visited[r][c] == true) {
            return false;
        }
        
        return true;
    }
    
    public int trapRainWater(int[][] heights) {
        // write your code here
        if(heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }
        
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(m * n, min_heap_compartor);
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heights[i][0]));
            visited[i][0] = true;
            
            pq.offer(new Cell(i, n - 1, heights[i][n - 1]));
            visited[i][n - 1] = true;
        }
        
        for(int j = 0; j < n; j++) {
            pq.offer(new Cell(0, j, heights[0][j]));
            visited[0][j] = true;
            
            pq.offer(new Cell(m - 1, j, heights[m - 1][j]));
            visited[m - 1][j] = true;
        }
        
        int ans = 0;
        
        while(pq.size() != 0) {
            Cell cur = pq.poll();
            int r = cur.r;
            int c = cur.c;
            int h = cur.h;
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                
                if(qualified(nr, nc, m, n, visited)) {
                    visited[nr][nc] = true;
                    if(h < heights[nr][nc]) {
                        pq.offer(new Cell(nr, nc, heights[nr][nc]));
                    }else {
                        ans += h - heights[nr][nc];
                        pq.offer(new Cell(nr, nc, h));
                    }
                }
            }
        }
        
        return ans;
    }
};</code></pre>
</div>
</div>
