<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Longest Repeating Subsequence
Given a string, find length of the longest repeating subsequence 
such that the two subsequence don’t have same string character at same position, 
i.e., any ith character in the two subsequences shouldn’t have the same index in the original string.

Example
str = abc, return 0, There is no repeating subsequence
str = aab, return 1, The two subsequence are a(first) and a(second). 
Note that b cannot be considered as part of subsequence as it would be at same index in both.
str = aabb, return 2


Key: This problem is just the modification of Longest Common Subsequence problem. 
The idea is to find the LCS(str, str) where str is the input string with the restriction 
that when both the characters are same, they shouldn’t be on the same index in the two strings.
*/
    /**
     * @param str a string
     * @return the length of the longest repeating subsequence
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int longestRepeatingSubsequence(String str) {
        // Write your code here
        int len = str.length();
        int[][] nums = new int[len + 1][len + 1];
        
        for(int i = 1; i < len + 1; i++) {
            for(int j = 1; j < len + 1; j++) {
                if(str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    nums[i][j] = nums[i - 1][j - 1] + 1;
                }else {
                    nums[i][j] = Math.max(nums[i - 1][j], nums[i][j - 1]);
                }
            }
        }
        
        return nums[len][len];
    }
}</code></pre>
</div>
</div>
