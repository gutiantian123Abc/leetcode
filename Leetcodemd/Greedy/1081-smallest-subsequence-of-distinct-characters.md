<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
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
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
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
}</code></pre>
</div>
</div>
