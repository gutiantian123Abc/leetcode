<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Longest Common Substring
Given two strings, find the longest common substring.
Return the length of it.
Notice
The characters in substring should occur continuously in original string. 
This is different with subsequence.

Example
Given A = "ABCD", B = "CBCE", return 2.
Challenge 
O(n x m) time and memory.
*/
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A == null || B == null) {
            return 0;
        }

//State: f[i][j] is the length of the longest lcs ended with A[i - 1] & B[j - 1] in A[0..i-1] & B[0..j-1]
        
        int a = A.length(), b = B.length();
        
        int[][] nums = new int[a + 1][b + 1];
        
        for(int i = 1; i < a + 1; i++) {
            for(int j = 1; j < b + 1; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    nums[i][j] = nums[i - 1][j - 1] + 1;
                }else {
                    nums[i][j] = 0;
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < a + 1; i++) {
            for(int j = 0; j < b + 1; j++) {
                max = Math.max(max, nums[i][j]);
            }
        }
        
        return max;
    }
}


</code></pre>
</div>
</div>
