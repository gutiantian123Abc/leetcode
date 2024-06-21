<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
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
flip all bits in the inclusive range [i, n - 1]. Flip means changing '0' to '1' and '1' to '0'.

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
        int n = target.length(), sign = 0, ops = 0;

        for(int i = 0; i < n; i++) {
            int sDigit = sign;
            int tDigit = target.charAt(i) == '1' ? 1 : 0;

            if(sDigit != tDigit) {
                sign = tDigit;
                ops++;
            }
        }

        return ops;
        
    }
}
</code></pre>
</div>
</div>
