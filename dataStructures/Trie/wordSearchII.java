/*WordSearch II
Given a matrix of lower alphabets and a dictionary.
Find all words in the dictionary that can be found in the matrix. 
A word can start from any position in the matrix and go left/right/up/down to the adjacent position. 
*/
//http://www.lintcode.com/en/problem/word-search-ii/

//DFS solution:  Tire + DFS 搜索矩阵类字符串
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
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
}