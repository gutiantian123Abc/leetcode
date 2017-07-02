/*Word Search 
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are 
those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example：
Given board =
[
  "ABCE",
  "SFCS",
  "ADEE"
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

*/

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    
    private boolean inbound(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
	    }
        return true;
    }
    
    private boolean searchDFS(char[][] board, char[] wordArray, int x, int y, int index) {
        if(index == wordArray.length) {
            return true;
        }
        
        if(!inbound(board, x, y) || board[x][y] != wordArray[index]) {
            return false;
        }
        
        boolean found = false;
        
        char temp = board[x][y];
        board[x][y] = '#';
        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            found = found || searchDFS(board, wordArray, newX, newY, index + 1); //注意， 这里一定这么写， 不能用found |..啦！！！
        }
        board[x][y] = temp;
        return found;
    }
    
    public boolean exist(char[][] board, String word) {
        // write your code here
        if(board == null || board.length == 0)
            return false;
        if(word.length() == 0)
            return true;

        char[] wordArray = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(searchDFS(board, wordArray, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}