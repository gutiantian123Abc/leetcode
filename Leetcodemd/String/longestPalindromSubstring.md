## Problem Description
```
/* Longest Palindromic Substring
Given a string S, find the longest palindromic substring in S.
You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring.

Example
Given the string = "abcdzdcab", return "cdzdc".
*/
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
## Solution
```java

public class Solution {
     
    private int maxLen = 1;
    private int start = 0;
    public String longestPalindrome(String s) {
        // Write your code here
        
        if(s == null || s.length() < 2) {
            return s;
        }
        
        for(int i = 0; i < s.length() - 1; i++) { 
            extend(s, i, i); //Assume odd length
            extend(s, i, i + 1);//Assume even length
        }
        
        //java : substring(int beginIndex, int endIndex) 极端注意！！！！
        return s.substring(start, start + maxLen);
    }
    
    private void extend(String s, int j, int k) {
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) { //注意条件添加的先后顺序
            j--;
            k++;
        }

        if(maxLen < k - j - 1) {
            start = j + 1;
            maxLen = k - j - 1;
        }
    }
}
