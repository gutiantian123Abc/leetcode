/* Surrounded Regions
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
A region is captured by flipping all 'O''s into 'X''s in that surrounded region.

Example
X X X X
X O O X
X X O X
X O X X
After capture all regions surrounded by 'X', the board should be:

X X X X
X X X X
X X X X
X O X X
*/

public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if( (i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O' ) {
                    dfsHighlight(board, i, j);
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }        
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'H') {
                    board[i][j] = 'O';
                }
            }
        }        
    }
    
    
    private void dfsHighlight(char[][] board, int i , int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        
        if(board[i][j] == 'O') {
            board[i][j] = 'H';
            dfsHighlight(board, i + 1, j);
            dfsHighlight(board, i - 1, j);
            dfsHighlight(board, i, j + 1);
            dfsHighlight(board, i, j - 1);
        }
    }    
}