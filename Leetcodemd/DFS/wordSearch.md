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
/*WordSearch II
Given a matrix of lower alphabets and a
dictionary.
Find all words in the dictionary that can be found
in the matrix.
A word can start from any position in the matrix
and go left/right/up/down to the adjacent
position.
*/
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
//http://www.lintcode.com/en/problem/word-search-ii/

//ONly solution！！！！！！:  Tire + DFS 搜索矩阵类字符串
//知识点： 此种在char matrix 里面用Trie搜索字符串的问题不能用BFS(区别于在Trie里用BFS找word)， 在这里我们是用DFS或BFS配合Trie在matrix里面
//遍历， 而不是用BFS或DFS遍历Trie, 所以只能用DFS+Trie

public class Solution {
    public class TrieNode { //Tire 标配
        boolean hasWord;
        String word;
        char letter;
        HashMap<Character, TrieNode> children;
        public TrieNode() {
            hasWord = false;
            children = new HashMap<Character, TrieNode>();
        }
        
        public TrieNode(char c) {
            hasWord = false;
            letter = c;
            children = new HashMap<Character, TrieNode>();
        }        
        
    }
    
    public class Trie { //Tire 标配
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void addWord(String word) {
            TrieNode curNode = root;
            char[] wordArray = word.toCharArray();
            for(int i = 0; i < wordArray.length; i++) {
                char c = wordArray[i];
                if(!curNode.children.containsKey(c)) {
                    curNode.children.put(c, new TrieNode(c));
                }
                
                curNode = curNode.children.get(c);
            }
            
            curNode.word = word;
            curNode.hasWord = true;
        }
        
        public boolean find(String word) {
            TrieNode curNode = root;
            char[] wordArray = word.toCharArray();
            for(int i = 0; i < wordArray.length; i++) {
                char c = wordArray[i];
                if(!curNode.children.containsKey(c)) {
                    return false;
                }
                curNode = curNode.children.get(c);
            }
            
            return curNode.hasWord;
        }
    }
    
    private int[]dx = {0, 1, -1, 0};
    private int[]dy = {1, 0, 0, -1};
    
    private void search(char[][] board, int x, int y, TrieNode node, ArrayList<String> ans) {
        if(node == null || !inbound(x, y, board)) {
            return;
        }
        if(node.hasWord) {
            if(!ans.contains(node.word)) {
                ans.add(node.word);
            }
        }
        
        if(node.children.containsKey(board[x][y])){
            for(int i = 0; i < 4; i++) {
                char temp = board[x][y];
                board[x][y] = 0;
                search(board, x + dx[i], y + dy[i], node.children.get(temp), ans);
                board[x][y] = temp;
            }
        }
    }
    
    private boolean inbound(int i , int j, char[][] board ) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        
        return true;
    }
    
    
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> ans = new ArrayList<String>();
        Trie trie = new Trie();
        for(String word : words) {
            trie.addWord(word);
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                search(board, i, j, trie.root, ans);
            }
        }
    
        return ans;
    }
}</code></pre>
</div>
</div>
