<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
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

//基础解法
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        int i = 0, j = 0;
        
        int[] hash = new int[256];
        int maxLen = 0;
        for(i = 0; i < s.length(); i++) {
            //只有长度为256时才可以这样: hash[s.charAt(j)]， 要不然都会有offset: hash[s.charAt(j) - 'a']
            while(j < s.length() && hash[s.charAt(j)] == 0) {
                hash[s.charAt(j)] = 1;
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }
            hash[s.charAt(i)] = 0;
        }
        
        return maxLen;
    }
}


//进阶解法
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
