<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 36. Valid Sudoku
Determine if a 9x9 Sudoku board is valid. Only the
filled cells need to be validated according to the
following rules:
Each row must contain the digits 1-9 without
repetition.
Each column must contain the digits 1-9 without
repetition.
Each of the 9 3x3 sub-boxes of the grid must
contain the digits 1-9 without repetition.
A partially filled sudoku which is valid.
The Sudoku board could be partially filled, where
empty cells are filled with the character '.'.
Example 1:
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:
Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5
in the top left corner being
    modified to 8. Since there are two 8's in the
top left 3x3 sub-box, it is invalid.
Note:
A Sudoku board (partially filled) could be valid
but is not necessarily solvable.
Only the filled cells need to be validated
according to the mentioned rules.
The given board contain only digits 1-9 and the
character '.'.
The given board size is always 9x9.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //All rows
        for(int i = 0; i < 9; i++) {
            int[] count = new int[10];
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    count[board[i][j] - '0']++;
                    if(count[board[i][j] - '0'] > 1) {
                        return false;
                    }
                }
            } 
        }
        
        //All cols
        for(int j = 0; j < 9; j++) {
            int[] count = new int[10];
            for(int i = 0; i < 9; i++) {
                if(board[i][j] != '.') {
                    count[board[i][j] - '0']++;
                    if(count[board[i][j] - '0'] > 1) {
                        return false;
                    }
                }
            } 
        }

        //All squares
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                int[] count = new int[10];
                for(int k = 0; k < 9; k++) { //八方问路很好的招式
                    if(board[i + k / 3][j + k % 3] != '.') {
                        count[board[i + k / 3][j + k % 3] - '0']++;
                        if(count[board[i + k / 3][j + k % 3] - '0'] > 1) {
                            return false;
                        }             
                    }
                }
            }
        }
        
        return true;
  
    }
}</code></pre>
</div>
</div>
