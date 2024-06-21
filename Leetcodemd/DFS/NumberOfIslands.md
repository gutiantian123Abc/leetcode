## Problem Description
```
/* Number of Islands I
Given a boolean 2D matrix, find the number of islands.

Notice
0 is represented as the sea, 1 is represented as the island. 
If two 1 is adjacent, we consider them in the same island. 
We only consider up/down/left/right adjacent.

Example
Given graph:
[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3

*/
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
## Solution
```java

public class Solution {
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length, ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == true) {
                    ans++;
                    DFS(grid, i, j);
                }else {
                    continue;
                }
            }
        }
        return  ans;
    }
    
    private void DFS(boolean[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        
        if(grid[i][j] == true) {
            grid[i][j] = false;
            DFS(grid, i - 1, j);
            DFS(grid, i + 1, j);
            DFS(grid, i, j - 1);
            DFS(grid, i, j + 1);
        }
    }
}