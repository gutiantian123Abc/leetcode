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
/* Longest Increasing Continuous subsequence II 
Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence in this matrix. 
(The definition of the longest increasing continuous subsequence here can start at any row or column and go up/down/right/left any direction).

Example
Given a matrix:

[
  [1 ,2 ,3 ,4 ,5],
  [16,17,24,23,6],
  [15,18,25,22,7],
  [14,19,20,21,8],
  [13,12,11,10,9]
]
return 25
O(nm) time and memory.
*/
/* 本题是一道DP 与 DFS 的绝妙搭配，
DFS 的本质是用recursion遍历每一种可能找到答案， 
而DP 在这里起到了避免recursion重复计算的妙处，
所以， 纯DFS的话， 本题的Time Complexity应为: O((mn)^2), 因为在遍历每个点的时候都可能触及到全图
但加上DP的话Time Complexity应为: O(mn)， 因为避免了重复计算， 只需遍历全图一遍即可
*/
    /*
     * @param : An integer matrix
     * @return: an integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>



public class Solution {
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // write your code here
        int m = A.length;
         if(m == 0) {
            return 0;
        }
        int n = A[0].length;
        int[][] f = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int res = 1;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, search(A, f, visited, i, j));
            }
        }
        
        return res;
    }
    
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    
    private boolean inBound(int nx, int ny, int m, int n) {
        if(nx < 0 || nx >= m || ny < 0 || ny >= n) {
            return false;
        }
        
        return true;
        
    }

    private int search(int[][] A, int[][] f, boolean[][] visited, int x, int y) {
        if(visited[x][y] == true) {//只是避免重复计算， 直接用就行
            return f[x][y];
        }
        
        int res = 1;
        int m = A.length;
        int n = A[0].length;
        visited[x][y] = true;
        f[x][y] = 1;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inBound(nx, ny, m, n) && A[nx][ny] > A[x][y]) {
                res = Math.max(res, 1 + search(A, f, visited, nx, ny));
            }
        }
        
        f[x][y] = res;
        
        return res;
    }
};</code></pre>
</div>
</div>
