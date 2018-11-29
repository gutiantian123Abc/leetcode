/* First Unique Character in a String
Find the first unique character in a given string. 
You can assume that there is at least one unique character in the string.

Example
For "abaccdeff", return 'b'.
*/

//这道题更好的方法是 First_Unique_Number_In_Stream， HashMap + LinkedList 

public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // Write your code here
        HashSet<Character> dups = new HashSet<>();
        HashMap<Character, Integer> singles = new HashMap<>();
        
        char[] words = str.toCharArray();
        
        for(int i = 0; i < words.length; i++) {
            char c = words[i];
            
            if(dups.contains(c)) {
                continue;
            }else {
                if(singles.containsKey(c)) {
                    singles.remove(c);
                    dups.add(c);
                }else {
                    singles.put(c, i);
                }
            }
        }
        
        int minIndex = words.length - 1;
        char ans = words[minIndex];
        
        for(char key : singles.keySet()) {
            if(singles.get(key) < minIndex) {
                minIndex = singles.get(key);
                ans = key;
            }
        }
        
        return ans;
        
    }
}