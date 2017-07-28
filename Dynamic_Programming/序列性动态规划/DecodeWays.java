/* Decode Ways
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

Example
Given encoded message 12, it could be decoded as AB (1 2) or L (12).
The number of ways decoding 12 is 2.
*/

public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        int len = s.length();
        
        if(len == 0) {
            return 0;
        }
        
        int[] f = new int[len + 1];
        f[0] = 1;
        char[] word = s.toCharArray();
        
        for(int i = 1; i < f.length; i++) {
        	//妙！
            if(word[i - 1] != '0') {
                f[i] += f[i - 1];
            }
            
            //妙！
            if(i >= 2) {
                int val = 10 * (word[i - 2] - '0') + (word[i - 1] - '0');
                if(val >= 10 && val <= 26) {
                    f[i] += f[i - 2];
                }
            }
            
        }
        
        return f[len];
        
    }
}