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
/* One Edit Distance
Given two strings s and t, determine if they are both one
edit distance apart.
Note:
There are 3 possiblities to satisify one edit distance
apart:
Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:
Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:
Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:
Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) {
            return s == t;
        }
        
        if(s.equals(t)) {
            return false;
        }
        
        int m = s.length(), n = t.length();
        if(Math.abs(m - n) > 1) {
            return false;
        }
        
        int len = Math.min(m, n);
        int index = 0;
        for(int i = 0; i < len; i++) {
            index = i + 1;
            if(s.charAt(i) != t.charAt(i)) {
                boolean change = s.substring(index).equals(t.substring(index));
                boolean addFromS = s.substring(index - 1).equals(t.substring(index));
                boolean removeFromS = s.substring(index).equals(t.substring(index - 1));
                return change || addFromS || removeFromS;
            }
            
        }
        
        return true;
    }
}</code></pre>
</div>
</div>
