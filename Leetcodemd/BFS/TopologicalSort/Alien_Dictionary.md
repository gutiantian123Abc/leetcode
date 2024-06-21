## Problem Description
```
/* Alien Dictionary

There is a new alien language which uses the latin alphabet.
\ However, the order among letters are unknown to you. 
You receive a list of non-empty words from the dictionary, 
where words are sorted lexicographically by the rules of this new language.
 Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
] 

Output: "" 

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
*/
## Solution
```java

class Solution {    
    public String alienOrder(String[] words) {
         String result = "";
        if(words.length <= 0) {
            return result;
        }
        if(words.length == 1) {
            return words[0];
        }
        HashMap<Character, HashSet<Character>> neighbors = new HashMap<>();//next neighbors
        HashMap<Character, Integer> degrees = new HashMap<>(); //Incoming degree
        
        for(String word : words) {
            for(char c : word.toCharArray()) {
                degrees.put(c, 0);
            }
        }
        //Create Graph
        for(int i = 1; i < words.length; i++) {
            String prevWord = words[i - 1];
            String nextWord = words[i];
            
            int len = Math.min(prevWord.length(), nextWord.length());
            
            for(int j = 0; j < len; j++) {
                char c1 = prevWord.charAt(j);
                char c2 = nextWord.charAt(j);
                if(c1 != c2) {
                    HashSet<Character> set = new HashSet<>();
                    if(!neighbors.containsKey(c1)) {
                        neighbors.put(c1, set);
                    }
                    
                    if(!neighbors.get(c1).contains(c2)) {
                        set = neighbors.get(c1);
                        set.add(c2);
                        neighbors.put(c1, set);
                        degrees.put(c2, degrees.get(c2) + 1);
                    }
                    
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList<Character>();
        
        for(char key : degrees.keySet()) {
            if(degrees.get(key) == 0) {
                q.offer(key);
            }
        }
        
        while(!q.isEmpty()) {
            char c = q.poll();
            result += c;
            if(neighbors.containsKey(c)) {  //防止invalid ordering
                for(char neighbor : neighbors.get(c)) {
                    degrees.put(neighbor, degrees.get(neighbor) - 1);
                    if(degrees.get(neighbor) == 0) {
                        q.offer(neighbor);
                    }
                }
            }
        }
        
        if(result.length() != degrees.size()) { //防止invalid ordering
            return "";
        }
        
        return result;

    }
}






