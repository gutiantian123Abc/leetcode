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
/* 696. Count Binary Substrings
https://leetcode.com/problems/count-binary-substrings/
Give a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, 
and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:

Input: s = "00110011"
Output: 6
Explanation: There are 6 substrings that have equal 
number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:

Input: s = "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.

See Solution!!!!!!!

Constraints:

1 <= s.length <= 105
s[i] is either '0' or '1'.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        
        int start = 0, end = 0;
        while(end < s.length()) {
            while(end < s.length() && s.charAt(end) == s.charAt(start)) {
                end++;
            }
            groups[t++] = end - start;
            start = end;
        }
        
        int ans = 0;
        for(int i = 1; i < t; i++) {
            ans += Math.min(groups[i-1], groups[i]);
        }
        
        return ans;
    }
}

</code></pre>
</div>
</div>
