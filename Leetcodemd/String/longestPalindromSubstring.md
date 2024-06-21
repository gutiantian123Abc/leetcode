<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 500px; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
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
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

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
</code></pre>
</div>
</div>
