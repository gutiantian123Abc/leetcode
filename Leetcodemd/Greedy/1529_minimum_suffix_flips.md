<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 600px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 1529. Minimum Suffix Flips
https://leetcode.com/problems/minimum-suffix-flips/description/

You are given a 0-indexed binary string target of length n. 
You have another binary string s of length n that is initially 
set to all zeros. You want to make s equal to target.

In one operation, you can pick an index i where 0 <= i < n and 
flip all bits in the inclusive range [i, n - 1]. Flip means changing 
'0' to '1' and '1' to '0'.

Return the minimum number of operations needed to make s equal to target.

 

Example 1:

Input: target = "10111"
Output: 3
Explanation: Initially, s = "00000".
Choose index i = 2: "00000" -> "00111"
Choose index i = 0: "00111" -> "11000"
Choose index i = 1: "11000" -> "10111"
We need at least 3 flip operations to form target.
Example 2:

Input: target = "101"
Output: 3
Explanation: Initially, s = "000".
Choose index i = 0: "000" -> "111"
Choose index i = 1: "111" -> "100"
Choose index i = 2: "100" -> "101"
We need at least 3 flip operations to form target.
Example 3:

Input: target = "00000"
Output: 0
Explanation: We do not need any operations since the initial s already equals target.
 

Constraints:

n == target.length
1 <= n <= 105
target[i] is either '0' or '1'.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int minFlips(String target) {
        boolean flipped = false;
        int n = target.length();
        int steps = 0;

        for(int i = 0; i < n; i++) {
            char cur = '0';
            if(flipped) {
                cur = '1';
            } else {
                cur = '0';
            }

            if(cur == target.charAt(i)) {
                continue;
            }else {
                flipped = !flipped;
                steps++;
            }
        }

        return steps;
    }
}</code></pre>
</div>
</div>
