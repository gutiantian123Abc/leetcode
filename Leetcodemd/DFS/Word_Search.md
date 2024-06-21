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
/*Word SearchGiven a 2D board and a word, find if the word exists in the grid.The word can be constructed from letters of sequentially adjacent cell,where "adjacent" cells arethose horizontally or vertically neighboring. The same letter cell may notbe used more than once.Example：Given board =[  "ABCE",  "SFCS",  "ADEE"]word = "ABCCED", -> returns true,word = "SEE", -> returns true,word = "ABCB", -> returns false.*/    /**     * @param board: A list of lists of character     * @param word: A string     * @return: A boolean     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//解法1：
public class Solution {
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
        
        char temp = board[x][y];//注意， 这里是backtracking， 注意区分DFS中的浸染法和尝试法
        board[x][y] = '#';
        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            found = found || searchDFS(board, wordArray, newX, newY, index + 1); //注意， 这里一定这么写， 不能用found |..啦！！！
        }
        board[x][y] = temp;//注意， 这里是backtracking， 注意区分DFS中的浸染法和尝试法
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

//解法2：
class Solution {
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    private boolean inRange(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                boolean result = dfs(board, i, j, 0, word, visited);
                if(result) {
                    return true;
                }
            }
        } 
        
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, int index, String word, boolean[][] visited) {
        
        if(index == word.length() - 1) {
           return word.charAt(index) == board[i][j];
        }
        
        visited[i][j] = true; //注意， 这里是backtracking
        int m = board.length, n = board[0].length;
        if(word.charAt(index) == board[i][j]) {
            for(int dir = 0; dir < 4; dir++) {
                int nx = i + dx[dir];
                int ny = j + dy[dir];
                
                if(inRange(nx, ny, m, n) && visited[nx][ny] == false) {
                    boolean result = dfs(board, nx, ny, index + 1, word, visited);
                    if(result) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;//注意， 这里是backtracking， 注意区分DFS中的浸染法和尝试法
            return false;
        }else {
            visited[i][j] = false;//注意， 这里是backtracking， 注意区分DFS中的浸染法和尝试法
            return false;
        }
    }
}</code></pre>
</div>
</div>
