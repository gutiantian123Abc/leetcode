<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 1000px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
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
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
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
            if(word[i - 1] != '0') {
                f[i] += f[i - 1];
            }
            
            
            if(i >= 2) {
                int val = 10 * (word[i - 2] - '0') + (word[i - 1] - '0');
                if(val >= 10 && val <= 26) {
                    f[i] += f[i - 2];
                }
            }
        }
        
        return f[len];
        
    }
}</code></pre>
</div>
</div>
