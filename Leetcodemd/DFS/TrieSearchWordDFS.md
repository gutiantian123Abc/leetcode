<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Add and Search Word
Design a data structure that supports the following two operations: addWord(word) and search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or ..

A . means it can represent any one letter.

Example
addWord("bad")
addWord("dad")
addWord("mad")
search("pad")  // return false
search("bad")  // return true
search(".ad")  // return true
search("b..")  // return true
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class WordDictionary {
    public class TrieNode {
        public char c;
        public HashMap<Character, TrieNode> children;
        public boolean hasWord;
        
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            hasWord = false;
        }
        
        public TrieNode(char c) {
            this.c = c;
            children = new HashMap<Character, TrieNode>();
            hasWord = false;
            
        }
    }
    
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    

    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode curNode = root;
        char[] wordArray = word.toCharArray();
        HashMap<Character, TrieNode> children = root.children;
        for(int i = 0; i < wordArray.length; i++) {
            char curWord = wordArray[i];
            if(!children.containsKey(curWord)) {
                TrieNode newNode = new TrieNode(curWord);
                children.put(curWord, newNode);
                curNode = newNode;
            }else {
                curNode = children.get(curWord);
            }
            
            children = curNode.children;
            
            if(i == wordArray.length - 1) {
                curNode.hasWord = true;
            }
        }
    }



    private boolean find(char[] wordArray, int index, TrieNode curNode) {
        
        char letter = wordArray[index]; //记住， 无论BFS或DFS都是word[index]与curNode.children 作比较， 因为index总是比root晚一步
        if(index == wordArray.length - 1) {
            if(letter == '.') {
                if(curNode.children.size() > 0) {
                    boolean flag = false;
                    for(TrieNode child : curNode.children.values()) {
                        if(child.hasWord) {
                            flag = true;
                        }
                    }
                    return flag;
                }else {
                    return false;
                }
            }else {
                if(curNode.children.containsKey(letter)) {//记住， 无论BFS或DFS都是word[index]与curNode.children 作比较， 因为index总是比root晚一步
                    return curNode.children.get(letter).hasWord;
                }else {
                    return false;
                }
            }
        }
        
        if(letter == '.') {
            if(curNode.children.size() == 0) {
                return false;
            }else {
                boolean flag = false;
                for(TrieNode child : curNode.children.values()) {//记住， 无论BFS或DFS都是word[index]与curNode.children 作比较， 因为index总是比root晚一步
                    if(find(wordArray, index + 1, child)) {
                        flag = true;
                    }
                }
                return flag;
            }
        }else {
            if(curNode.children.containsKey(letter)) {//记住， 无论BFS或DFS都是word[index]与curNode.children 作比较， 因为index总是比root晚一步
                return find(wordArray, index + 1, curNode.children.get(letter));
            }else {
                return false;
            }
        }
    }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return find(word.toCharArray(), 0, root);
    }
}</code></pre>
</div>
</div>
