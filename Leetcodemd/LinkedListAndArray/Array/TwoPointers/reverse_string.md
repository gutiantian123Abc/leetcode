<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 344. Reverse String
https://leetcode.com/problems/reverse-string/
Write a function that reverses a string. The input string is given as an array of characters s.
Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
Constraints:
1 <= s.length <= 105
s[i] is a printable ascii character.
Follow up: Do not allocate extra space for another array.
You must do this by modifying the input array in-place with O(1) extra memory.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        
        while(l <= r) {
            char tmp = s[r];
            s[r] = s[l];
            s[l] = tmp;
            l++;
            r--;
        }
        
    }
}</code></pre>
</div>
</div>
