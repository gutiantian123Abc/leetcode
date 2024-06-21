<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 80%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Longest Substring Without Repeating Characters 
Given a string, find the length of the longest substring without repeating characters.
Example
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
For "bbbbb" the longest substring is "b", with the length of 1.
Challenge 
O(n) time
*/
    /**
     * @param s: a string
     * @return: an integer 
     */
        /* 窗口类指针移动模板
        int j = 0;

        for(int i = 0; i < nums.length; i++) {

            while(j < nums.length) {
                if(满足条件) {
                    j++;
                    更行j状态
                }else{
                    break;
                }
            }

            更新i状态
        }
        */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        
        int j = 0, ans = 0;
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            while(j < s.length()) {
                if(!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    j++;
                }else {
                    break;
                }
            }
            
            ans = Math.max(ans, j - i);
            set.remove(s.charAt(i));
        }
        
        return ans;
    }
}</code></pre>
</div>
</div>
