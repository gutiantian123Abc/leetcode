<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*  Knight Shortest Path

Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, 
find the shortest path to a destination position, return the length of the route. 
Return -1 if knight can not reached.

Clarification
If the knight is at (x, y), he can get to the following positions in one step:

(x + 1, y + 2)
(x + 1, y - 2)
(x - 1, y + 2)
(x - 1, y - 2)
(x + 2, y + 1)
(x + 2, y - 1)
(x - 2, y + 1)
(x - 2, y - 1)
Example
[[0,0,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 2

[[0,1,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 6

[[0,1,0],
 [0,0,1],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return -1

*/
/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution { //经典的BFS
    int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2}; //注意deltaX, Y 的用法
    int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        grid[source.x][source.y] = true;
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(source);
        int steps = 0;
        while(queue.size() != 0) {
            int size = queue.size(); // 注意一定注意！！！！！！！
            for(int i = 0; i < size; i++) {
                Point point = queue.poll();
                if(equal(point, destination)) {
                    return steps;
                }
                
                for(int direction = 0; direction < 8; direction++) {
                    if(qualified(grid, point.x + deltaX[direction], point.y + deltaY[direction])) {
                        queue.offer(new Point(point.x + deltaX[direction], point.y + deltaY[direction]));
                        grid[point.x + deltaX[direction]][point.y + deltaY[direction]] = true;
                    }
                }
            }
            
        steps++;
        
        }
        return -1;
    }
    
    private boolean equal(Point A, Point B) {
        return A.x == B.x && A.y == B.y;
    }
    
    private boolean qualified(boolean[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == true) {
            return false;
        }
        return true;
    }
}</code></pre>
</div>
</div>
