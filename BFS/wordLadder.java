/* Word Ladder
Given two words (start and end), and a dictionary, 
find the length of shortest transformation sequence from start to end, such that:
Only one letter can be changed at a time
Each intermediate word must exist in the dictionary

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if(start == null || end == null || dict == null) {
            return 0;
        }
        
        if(start.equals(end)) {
            return 1;
        }
        
        dict.add(start);
        dict.add(end);
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        queue.offer(start); //触摸到， length 就是 1
        visited.add(start);
        int length = 1;
        while(queue.size() != 0) {
            int size = queue.size();
            length++;
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                for(String nextWord : getNextWords(word, dict, visited)) {
               
                    if(nextWord.equals(end)) {
                        return length;
                    }else {
                        visited.add(nextWord);
                        queue.offer(nextWord);                            
                    }
                  
                }
            }
        }
        
        return 0;
    }
    
    
    private ArrayList<String> getNextWords(String word, Set<String> dic, HashSet<String> visited) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for(char c = 'a'; c <= 'z'; c++) {
            for(int i = 0; i < word.length(); i++) {
                if(c == word.charAt(i)) {
                    continue;
                }else {
                    String nextWord = replace(word, i, c);
                    if(!visited.contains(nextWord) && dic.contains(nextWord)) {
                        nextWords.add(nextWord);
                    }
                }
            }
        }
        
        return nextWords;
    } 
    
    private String replace(String word, int index, char c) {
        char[] wordArray = word.toCharArray();
        wordArray[index] = c;
        return new String(wordArray); //注意char 转 String
    }
}