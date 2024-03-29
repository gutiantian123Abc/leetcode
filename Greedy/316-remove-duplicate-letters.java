/* 316. Remove Duplicate Letters
https://leetcode.com/problems/remove-duplicate-letters/description/

Given a string s, remove duplicate letters so that every 
letter appears once and only once. You must make sure your result is 
the smallest in lexicographical order
 among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.

*/

class Solution {
    public String removeDuplicateLetters(String s) {
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