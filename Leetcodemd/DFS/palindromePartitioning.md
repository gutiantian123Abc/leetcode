<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 700px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Palindrome Partitioning
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

Example
Given s = "aab", return:

[
  ["aa","b"],
  ["a","a","b"]
]

*/
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null) {
            return result;
        }
        List<String> list = new ArrayList<String>();
        dfs(result, list, s, 0);
        return result;
    }
    
    private void dfs(List<List<String>> result, List<String> list, String s, int startIndex) {
        if(startIndex == s.length()) {
            result.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i = startIndex; i < s.length(); i++) {
            String prefix = s.substring(startIndex, i + 1);
            if(!isPalindrome(prefix)) {
                continue;
            }else {
                list.add(prefix);
                dfs(result, list, s, i + 1);
                list.remove(list.size() - 1);
            }
            
        }
    }
    
    private boolean isPalindrome(String s) {
        if(s.length() == 1) {
            return true;
        }
        
        int start = 0, end = s.length() - 1;
        
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}</code></pre>
</div>
</div>
