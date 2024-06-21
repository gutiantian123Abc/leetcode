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
/* Walls and Gates
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 
to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. 
If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    private class Pair { //记住， 这里必须是private class
        int i;
        int j;
        
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        
        
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }     
    }
    
    private void bfs(int[][] rooms, int i, int j) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(i, j));
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int s = 0; s < size; s++) {
                Pair pair = queue.poll();
                int x = pair.i;
                int y = pair.j;
                for(int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    
                    if(inBound(nx, ny, m, n) && rooms[x][y] + 1 < rooms[nx][ny]) {
                        rooms[nx][ny] = rooms[x][y] + 1;
                        queue.offer(new Pair(nx, ny));
                    }       
                }   
            } 
        }
    }
    
    private boolean inBound(int x, int y, int m , int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
}</code></pre>
</div>
</div>
