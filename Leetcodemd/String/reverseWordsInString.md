<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 50px auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Reverse Words in a String
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Clarification ：
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/
    /**
     * @param s : A string
     * @return : A string
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        
        String[] arr = s.split(" "); // Split to String Array
        
        StringBuilder sb = new StringBuilder();

        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] != " ") {
                sb.append(arr[i]).append(" "); // 倒着加到SB
            }
        } 
        
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1); //sb substring 用法
    }
}
</code></pre>
</div>
</div>
