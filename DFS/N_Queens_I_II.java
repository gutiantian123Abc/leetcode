/* 51. N-Queens I
https://leetcode.com/problems/n-queens/

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. 
You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, 
where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9
*/

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
}