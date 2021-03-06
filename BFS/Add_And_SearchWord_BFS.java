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
    
    public TrieNode root;
    
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
                    for(TrieNode child : cur.children.values()) { //记住， 无论BFS或DFS都是word[index]与curNode.children 作比较， 因为index总是比root晚一步
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
                        TrieNode child = cur.children.get(letter);//记住， 无论BFS或DFS都是word[index]与curNode.children 作比较， 因为index总是比root晚一步
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

