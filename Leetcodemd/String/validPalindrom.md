<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Valid Palindrome
Given a string, determine if it is a palindrome, 
considering only alphanumeric characters and ignoring cases.
Example
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

O(n) time without extra memory.
*/
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public boolean isPalindrome(String s) {
        // Write your code here
        if(s == null || s.length() < 2) {
            return true;
        }
        int start = 0, end = s.length() - 1;
        
        while(start <= end) {
            if(!isAlphanumeric(s.charAt(start))) {
                start++;
            }else if(!isAlphanumeric(s.charAt(end))) {
                end--;
            }else if(format(s.charAt(start)) != format(s.charAt(end))) {
                return false;
            }else {
                start++;
                end--;
            }
        }
        
        return true;
    }
    
    private boolean isAlphanumeric(char c) {
        if(c >= '0' && c <= '9') {
            return true;
        }else if(c >= 'a' && c <= 'z') {
            return true;
        }else if(c >= 'A' && c <= 'Z') {
            return true;
        }else {
            return false;
        }
    }
    
    private char format(char c) {
        if(c >= 'A' && c <= 'Z') {
            c = Character.toLowerCase(c);
        }
        return c;
    }
}</code></pre>
</div>
</div>
