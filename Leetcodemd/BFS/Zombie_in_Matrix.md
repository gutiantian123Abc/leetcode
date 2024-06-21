<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Zombie in Matrix
Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).
Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall. 
How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.

Example
Given a matrix:

0 1 2 0 0
1 0 0 2 1
0 1 0 0 0
return 2
*/
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    private class Point { //巧用 Point Class
        int x;
        int y;
        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }
    
    private boolean qualified(int[][] grid, int x , int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 2 || grid[x][y] == 1) {
            return false;
        }
        
        return true;
    }
    public int zombie(int[][] grid) {
        // Write your code here
        int[] deltaX = {0, 0, 1, -1}; //巧用direction
        int[] deltaY = {1, -1, 0, 0};
        int m = grid.length;
        int n = grid[0].length;
        Queue<Point> queue = new LinkedList<Point>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }
        int days = 0;
        while(queue.size() != 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Point point = queue.poll();
                for(int direction = 0; direction < 4; direction++) {
                    if(qualified(grid, point.x + deltaX[direction], point.y + deltaY[direction])) {
                        queue.offer(new Point(point.x + deltaX[direction], point.y + deltaY[direction]));
                        grid[point.x + deltaX[direction]][point.y + deltaY[direction]] = 1;
                    }
                }
            }
            days++;
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    return -1;
                }
            }
        }        
        
        return days - 1; //早晚有一天， zanmbie 传染不动了， 最后一天 Queue 要把最后一层zonmbie 吐出来, days 不能增加的
   }
}</code></pre>
</div>
</div>
