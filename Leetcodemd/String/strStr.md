<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 50%; margin: auto; padding: 20px; }
  .comment-block { max-width: 50%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* strStr
For a given source string and a target string, 
you should output the first index(from 0) of target string in source string.
If target does not exist in source, just return -1.

Example
If source = "source" and target = "target", return -1.
If source = "abcdabcdefg" and target = "bcd", return 1.
*/
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int strStr(String source, String target) {
        //write your code here
        if(target == null || source == null || source.length() < target.length()) {
            return -1;
        }
        
        for(int i = 0; i < source.length() - target.length() + 1; i++) {//注意这里, i < source.length() - target.length() + 1
            int j = 0;
            for(j = 0; j < target.length(); j++) {
                if(target.charAt(j) != source.charAt(i + j)) {
                    break;
                }
            }
            if(j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}</code></pre>
</div>
</div>
