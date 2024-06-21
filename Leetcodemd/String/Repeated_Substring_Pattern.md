<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 400px; margin: 50px; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 50px; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 459. Repeated Substring Pattern
Given a non-empty string check if it can be constructed by taking a substring of it and 
appending multiple copies of the substring together. You may assume the given string consists 
of lowercase English letters only and its length will not exceed 10000.

 

Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
//这道题的本质就是从0开始到Length/2试， 不要被substring迷惑
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        if(l < 1) {
            return true;
        }
        
        for(int i = l / 2; i >= 1; i--) {
            if(l % i == 0) {
                int repeatTime = l / i;
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < repeatTime; j++) {
                    sb.append(s.substring(0, i));
                }
            
                if(sb.toString().equals(s)) {
                    return true;
                } 
            }
        }
        
        return false;
        
    }
}</code></pre>
</div>
</div>
