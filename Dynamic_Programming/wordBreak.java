/* Word Break
Given a string s and a dictionary of words dict, 
determine if s can be break into a space-separated sequence of one or more dictionary words.
Example
Given s = "lintcode", dict = ["lint", "code"].
Return true because "lintcode" can be break as "lint code".
*/

//经典的DP， 好好读！！！
public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
        if(s == null || s.length() == 0) {
            return true;
        }
        
        int maxLen = maxLen(dict);
        
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        
        for(int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for(int lastWordLength = 1; 
            lastWordLength <= maxLen && lastWordLength <= i; lastWordLength++) {
                if(canSegment[i - lastWordLength] == false) {
                    continue;
                }else{
                    String lastWord = s.substring(i - lastWordLength, i);
                    if(dict.contains(lastWord)) {
                        canSegment[i] = true;
                        break;
                    }
                }
            }
        }
        
        return canSegment[s.length()];
    }
    
    private int maxLen(Set<String> dict) {
        int len = 0;
        for(String str : dict) {
            len = Math.max(len, str.length());
        }
        return len;
    }
}