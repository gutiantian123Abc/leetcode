<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container {{ max-width: 100%; margin: 0 auto; padding: 10px; }}
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Battleships in a Board
Given an 2D board, count how many battleships are in it. 
The battleships are represented with 'X's, empty slots are represented with '.'s. 
You may assume the following rules:
You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, 
they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), 
where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - 
there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - 
as battleships will always have a cell separating between them.

Follow up:
Could you do it in one-pass, using only O(1) extra memory and without modifying the 
value of the board?
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'X') {
                    if(i == 0 && j == 0) {
                        count++;
                    }else if(i == 0 && j > 0) {
                        if(board[i][j - 1] == '.') {
                            count++;
                        }
                    }else if(i > 0 && j == 0) {
                        if(board[i - 1][j] == '.') {
                            count++;
                        }
                    }else {// i > 0 && j > 0
                        if(board[i - 1][j] == '.' && board[i][j - 1] == '.') {
                            count++;
                        }
                    }
                }
            }
        }
        
        return count;
    }
}</code></pre>
</div>
</div>
