<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 500px; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Longest Common Subsequence
Given two strings, find the longest common subsequence (LCS).
Your code should return the length of LCS.
Example
For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
For "ABCD" and "EACB", the LCS is "AC", return 2.
*/
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int a = A.length(), b = B.length();
        int[][] nums = new int[a + 1][b + 1];
        
        for(int i = 1; i < a + 1; i++) {
            for(int j = 1; j < b + 1; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    nums[i][j] = nums[i - 1][j - 1] + 1;
                }else {
                    nums[i][j] = Math.max(nums[i - 1][j], nums[i][j - 1]);
                }
            }
        }
        
        return nums[a][b];
    }
}


//See longestCommonSubString.java Related</code></pre>
</div>
</div>
