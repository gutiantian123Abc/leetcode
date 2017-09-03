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




/* Maze I BFS*/
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















