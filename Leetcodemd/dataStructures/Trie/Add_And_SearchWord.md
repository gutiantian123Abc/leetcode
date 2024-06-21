<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
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
/*BFS + Tire*/
/* DFS version
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
//知识要点： 这里因为是在遍历Trie找词， 所以BFS和在DFS都可以应用， 但WordSearch题目里则只能用DFS！！！
public class WordDictionary {
    
    public class TrieNode {
        public char c;
        public HashMap<Character, TrieNode> children;
        public boolean hasWord;
        public String word;
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
    
    public TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        Queue<TrieNode> queue = new LinkedList<TrieNode>();
        queue.add(root);
        
        
        char[] words = word.toCharArray();
        int index = 0;
        
        while(queue.size() != 0) {
            int size = queue.size();
            boolean flag = false;
            char letter = words[index];
            
            if(letter == '.') {
                for(int i = 0; i < size; i++) {
                    TrieNode cur = queue.poll();
                    for(TrieNode child : cur.children.values()) {//记住， 无论BFS或DFS都是word[index]与curNode.children 作比较， 因为index总是比root晚一步
                        queue.add(child);
                        flag |= child.hasWord;
                    }
                }
                
                if(index == words.length - 1) {
                    return flag;
                }
                
            }else {
                
                for(int i = 0; i < size; i++) {
                    TrieNode cur = queue.poll();
                    if(cur.children.containsKey(letter)) {
                        TrieNode child = cur.children.get(letter);
                        queue.add(child);
                        flag |= child.hasWord;
                    }
                }
                
                if(index == words.length - 1) {
                    return flag;
                }
            
            }
            
            index++;
        }
        
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");



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



    private boolean find(char[] wordArray, int index, TrieNode curNode) {
        
        char letter = wordArray[index];
        if(index == wordArray.length - 1) {
            if(letter == '.') {
                if(curNode.children.size() > 0) {
                    boolean flag = false;
                    for(TrieNode child : curNode.children.values()) {//记住， 无论BFS或DFS都是word[index]与curNode.children 作比较， 因为index总是比root晚一步
                        if(child.hasWord) {
                            flag = true;
                        }
                    }
                    return flag;
                }else {
                    return false;
                }
            }else {
                if(curNode.children.containsKey(letter)) {
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
                for(TrieNode child : curNode.children.values()) {
                    if(find(wordArray, index + 1, child)) {
                        flag = true;
                    }
                }
                return flag;
            }
        }else {
            if(curNode.children.containsKey(letter)) {
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
}

</code></pre>
</div>
</div>
