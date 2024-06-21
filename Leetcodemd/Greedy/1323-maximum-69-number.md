<style>
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 1323. Maximum 69 Number
https://leetcode.com/problems/maximum-69-number/description/

You are given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit 
(6 becomes 9, and 9 becomes 6).

 

Example 1:

Input: num = 9669
Output: 9969
Explanation: 
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.
Example 2:

Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.
Example 3:

Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.
 

Constraints:

1 <= num <= 104
num consists of only 6 and 9 digits.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int maximum69Number (int num) {
        int num2 = num;
        int n = 0;
        while(num2 > 0) {
            num2 = num2/10;
            n++;
        }

        int[] A = new int[n];
        int i = 0;
        while(num > 0) {
            A[i] = num % 10;
            num = num/10;
            i++;
        }

        int res = 0;
        boolean changed = false;

        for(int j = i - 1; j >= 0; j--) {
            if(!changed && A[j] == 6) {
                A[j] = 9;
                changed = true;
            }
            res += A[j] * Math.pow(10, j);
            i--;
        }

        return res;
        
    }
}</code></pre>
</div>
