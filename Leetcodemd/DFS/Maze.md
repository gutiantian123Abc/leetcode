<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 744px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* The Maze I
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false
Explanation: There is no way for the ball to stop at the destination.

Note:
There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
*/
/* 解题思路：
这道题既可以用DFS， 也可以用BFS，但BFS最好， 参见BFS解法
注意， 这里是求能否在重点停下， 而且只有在停下时才能转方向
*/
/* Maze I BFS*/
/* Maze II
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: 12
Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
             The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

Example 2

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: -1
Explanation: There is no way for the ball to stop at the destination.

Note:
There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//DFS:
class Solution {
    //DFS
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] stopped = new boolean[m][n];
        
        return dfs(maze, start, destination, stopped);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] stopped) {
        int row = start[0], col = start[1], m = maze.length, n = maze[0].length;
        if(row == destination[0] && col == destination[1]) {
            return true;
        }
        
        stopped[row][col] = true;
        
        for(int dir = 0; dir < 4; dir++) {//注意用dx[dir]直通的做法
            int nrow = row + dx[dir];
            int ncol = col + dy[dir];
            
            while(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && maze[nrow][ncol] != 1) {
                nrow += dx[dir];
                ncol += dy[dir];
            }
            
            nrow = nrow - dx[dir];
            ncol = ncol - dy[dir];
            
            if(stopped[nrow][ncol] == false) {
                start[0] = nrow;
                start[1] = ncol;
                if(dfs(maze, start, destination, stopped) == true) {
                    return true;
                }            
            }  
        }   
        
        return false;
    }
}




class Solution {
    private class Pair {
        public int row;
        public int col;
        
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    //BFS
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(start[0], start[1]));
        visited[start[0]][start[1]] = true;
        while(queue.size() != 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                for(int dir = 0; dir < 4; dir++) { //注意用dx[dir]直通的做法
                    int nrow = cur.row + dx[dir];
                    int ncol = cur.col + dy[dir];
                    
                    while(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && maze[nrow][ncol] != 1) {
                        nrow += dx[dir];
                        ncol += dy[dir];
                    }
                    
                    nrow = nrow - dx[dir];
                    ncol = ncol - dy[dir];
                    if(visited[nrow][ncol] == false) {
                        if(nrow == destination[0] && ncol == destination[1]) {
                            return true;
                        }else {
                            visited[nrow][ncol] = true;
                            queue.offer(new Pair(nrow, ncol));
                        }
                    }
                }  
            }       
        }
        return false;
    }
}















//DP 与 DFS, BFS 的结合， 好好看！！！



//DFS + DP
class Solution {
    //DFS
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        if(destination[0] >= m && destination[1] >= n) {
            return -1;
        }
        
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        
        dp[start[0]][start[1]] = 0;
        dfs(maze, start, destination, dp);
        
        if(dp[destination[0]][destination[1]] < 0) {
            return -1;
        }else {
            return dp[destination[0]][destination[1]];
        }
        
    }
    
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    
    private void dfs(int[][] maze, int[] start, int[] destination, int[][] dp) {
        int row = start[0], col = start[1], m = maze.length, n = maze[0].length;
        if(row == destination[0] && col == destination[1]) {
            return;
        }
      
       
        for(int dir = 0; dir < 4; dir++) {
            int nrow = row + dx[dir];
            int ncol = col + dy[dir];
            int step = 0;
            
            while(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && maze[nrow][ncol] != 1) {
                nrow += dx[dir];
                ncol += dy[dir];
                step++;
            }
            
            nrow = nrow - dx[dir];
            ncol = ncol - dy[dir];
            
      
            int[] newStart = new int[2];
            newStart[0] = nrow;
            newStart[1] = ncol;          
           
            if(dp[nrow][ncol] == -1) {
                dp[nrow][ncol] = dp[row][col] + step;
                dfs(maze, newStart, destination, dp);
            }else {
                if(dp[nrow][ncol] <= dp[row][col] + step) {
                    continue;
                }else {
                    dp[nrow][ncol] = dp[row][col] + step;
                    dfs(maze, newStart, destination, dp);
                }   
            }
        }  
    }  
}

//BFS + DP
class Solution {
    private class Pair {
        public int row;
        public int col;
        
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        
        
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(start[0], start[1]));
        dp[start[0]][start[1]] = 0;
        
        while(queue.size() != 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                int row = cur.row;
                int col = cur.col;
                
                for(int dir = 0; dir < 4; dir++) {
                    int n_row = row + dx[dir];
                    int n_col = col + dy[dir];
                    int step = 0;
                    
                    while(n_row >= 0 && n_row < m && n_col >= 0 && n_col < n && maze[n_row][n_col] != 1) {
                        n_row += dx[dir];
                        n_col += dy[dir];
                        step++;
                    }
                    
                    n_row = n_row - dx[dir];
                    n_col = n_col - dy[dir];
                    
                    if(dp[n_row][n_col] == -1) {
                        dp[n_row][n_col] = dp[row][col] + step;
                        queue.offer(new Pair(n_row, n_col));
                    }else {
                        if(dp[n_row][n_col] > dp[row][col] + step) {
                            dp[n_row][n_col] = dp[row][col] + step;
                            queue.offer(new Pair(n_row, n_col));                           
                        }   
                    }                             
                }
            } 
        }
            
        return dp[destination[0]][destination[1]];
    }
}












</code></pre>
</div>
</div>
