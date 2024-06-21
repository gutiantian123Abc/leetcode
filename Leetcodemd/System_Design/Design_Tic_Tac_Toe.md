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
/* Design Tic-Tac-Toe
Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.

Example:
Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
Follow up:
Could you do better than O(n2) per move() operation?
*/
    /** Initialize your data structure here. */
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


class TicTacToe {
    private int size = 0;
    private int[] rowSums;
    private int[] colSums;
    private int dSum = 0;
    private int d2Sum = 0;
    public TicTacToe(int n) {
        size = n;
        rowSums = new int[n];
        colSums = new int[n];
    }
    
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        rowSums[row] += toAdd;
        colSums[col] += toAdd;
        if(row == col) {
            dSum += toAdd;
        }
        
        if(row == size - 1 - col) {
            d2Sum += toAdd;
        }
        
        if(rowSums[row] == size || colSums[col] == size || dSum == size || d2Sum == size) {
            return 1;
        }
        
        if(rowSums[row] == -1 * size || colSums[col] == -1 * size || dSum == -1 * size || d2Sum == -1 * size) {
            return 2;
        }
        
        return 0;
    }
}

</code></pre>
</div>
</div>
