<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 744px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*2160. Minimum Sum of Four Digit Number After Splitting Digits
https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/description/

You are given a positive integer num consisting of exactly 
four digits. Split num into two new integers new1 and new2 
by using the digits found in num. Leading zeros are allowed in new1 and new2, 
and all the digits found in num must be used.

For example, given num = 2932, you have the following digits: 
two 2's, one 9 and one 3. Some of the possible pairs [new1, new2]
are [22, 93], [23, 92], [223, 9] and [2, 329].
Return the minimum possible sum of new1 and new2.
 

Example 1:

Input: num = 2932
Output: 52
Explanation: Some possible pairs [new1, new2] are [29, 23], [223, 9], etc.
The minimum sum can be obtained by the pair [29, 23]: 29 + 23 = 52.
Example 2:

Input: num = 4009
Output: 13
Explanation: Some possible pairs [new1, new2] are [0, 49], [490, 0], etc. 
The minimum sum can be obtained by the pair [4, 9]: 4 + 9 = 13.
 
Constraints:

1000 <= num <= 9999
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int minimumSum(int num) {
        int[] A = new int[4];

        for(int i = 0; i < 4; i++) {
            int digit = num % 10;
            num = num / 10;
            A[i] = digit;
        }

        Arrays.sort(A);
        int first = A[0], second = A[1], third = A[2], fourth = A[3];
        return first * 10 + third + second * 10 + fourth;
    }
}</code></pre>
</div>
</div>
