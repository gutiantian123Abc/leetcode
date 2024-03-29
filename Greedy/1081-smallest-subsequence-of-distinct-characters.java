/* 1081. Smallest Subsequence of Distinct Characters
https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/

Given a string s, return the lexicographically smallest
 
subsequence of s that contains all the distinct characters of s exactly once.
(Keep original order)

 
Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
 

Note: This question is the same as 316: https://leetcode.com/problems/remove-duplicate-letters/
*/
class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        boolean[] selected = new boolean[26];
        int[] freq = new int[26];

        for(int i = 0; i < n; i++) {
            char curChar = s.charAt(i);
            freq[curChar - 'a']++;
        }

        for(int i = 0; i < n; i++) {
            char curChar = s.charAt(i);

            if(!selected[curChar - 'a']) {

                while(!stack.isEmpty() && stack.peek() > curChar && freq[stack.peek() - 'a'] > 0) {
                    char peekChar = stack.pop();
                    selected[peekChar - 'a'] = false;
                }

                stack.push(curChar);
                selected[curChar - 'a'] = true;
            }
            freq[curChar - 'a']--;
        }

        String res = "";
        while(!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
        
    }
}