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
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        
        if(destination[0] >= m || destination[1] >= n) {
            return false;
        }
        
        boolean[][] visited = new boolean[m][n];//注意， 这里是停下过的点， 而非滚过的点， 因为只有在停下时才能变换方向(进行下一步dfs)
        return dfs(maze, visited, start, destination);
    }
    

    
    private boolean dfs(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
        int row = start[0], col = start[1], m = maze.length, n = maze[0].length;
        //本体注意， row, col 与 x, y 一定要分清楚
        if(row == destination[0] && col == destination[1]) {
            return true;
        }
        
        visited[row][col] = true;
        
        int left_col = col - 1, right_col = col + 1, up_row = row - 1, down_row = row + 1, new_row = 0, new_col = 0;
        int[] newStart = new int[2];
        
//Left *****************************************************   
        while(left_col >= 0 && maze[row][left_col] != 1) { //left
            left_col--; //注意， 这里是求能否在重点停下， 而且只有在停下时才能转方向
        }

        new_row = row;
        new_col = left_col + 1;

        newStart = new int[2];
        newStart[0] = new_row;
        newStart[1] = new_col;
        if(visited[new_row][new_col] == false && dfs(maze, visited, newStart, destination)) {
            return true;
        }               


//right *****************************************************
        while(right_col < maze[0].length && maze[row][right_col] != 1) {
            right_col++;//注意， 这里是求能否在重点停下， 而且只有在停下时才能转方向
        }

        new_row = row;
        new_col = right_col - 1;
        newStart[0] = new_row;
        newStart[1] = new_col;
        newStart[1] = new_col;
        if(visited[new_row][new_col] == false && dfs(maze, visited, newStart, destination)) {
            return true;
        }             


//Up *****************************************************

        while(up_row >= 0 && maze[up_row][col] != 1) { //up
            up_row--;//注意， 这里是求能否在重点停下， 而且只有在停下时才能转方向
        }

        new_row = up_row + 1;
        new_col = col;
        newStart[0] = new_row;
        newStart[1] = new_col;
        newStart[1] = new_col;
        if(visited[new_row][new_col] == false && dfs(maze, visited, newStart, destination)) {
            return true;
        }            


//Down *****************************************************     
        while(down_row < maze.length && maze[down_row][col] != 1) { //down
            down_row++;//注意， 这里是求能否在重点停下， 而且只有在停下时才能转方向
        }

        new_row = down_row - 1;
        new_col = col;
        newStart[0] = new_row;
        newStart[1] = new_col;
        newStart[1] = new_col;
        if(visited[new_row][new_col] == false && dfs(maze, visited, newStart, destination)) {
            return true;
        }               
        
        return false;
    }
}









