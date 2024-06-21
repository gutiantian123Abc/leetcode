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
/* 51. N-Queens Ihttps://leetcode.com/problems/n-queens/The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no twoqueens attack each other.Given an integer n, return all distinct solutions to the n-queens puzzle.You may return the answer in any order.Each solution contains a distinct board configuration of the n-queens' placement,where 'Q' and '.' both indicate a queen and an empty space, respectively.Example 1:Input: n = 4Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]Explanation: There exist two distinct solutions to the 4-queens puzzle as shown aboveExample 2:Input: n = 1Output: [["Q"]]Constraints:1 <= n <= 9*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public List<List<String>> solution = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        dfs(0, new boolean[n][n], n);
        return solution;
    }
    
    private void dfs(int row, boolean[][] v, int n) {
        if(row == n) {
            addSolution(v, n);
            return;
        }else {
            for(int j = 0; j < n; j++) {
                if(isValid(row, j, v, n)) {
                    v[row][j] = true;
                    dfs(row + 1, v, n);
                    v[row][j] = false;
                }
            }
        }
    }
    
    private boolean isValid(int i, int j, boolean[][] v, int n) {
        //v
        for(int I = 0; I < i; I++) {
            if(v[I][j]) {
                return false;
            }
        }
        
        
        //45
        for(int I = i - 1, J = j + 1; I >= 0 && J < n; I--, J++) {
            if(v[I][J]) {
                return false;
            }
        }
        
        //135
        
        for(int I = i - 1, J = j - 1; I >= 0 && J >= 0; I--, J--) {
            if(v[I][J]) {
                return false;
            }
        }
        
        return true;
    }
    
    
    
    private void addSolution(boolean[][] v, int n) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(v[i][j]) {
                    sb.append('Q');
                }else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        
        solution.add(new ArrayList(list));
    }
}</code></pre>
</div>
</div>
