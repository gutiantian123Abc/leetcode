<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Perfect Number
We define the Perfect Number is a positive integer that is equal to the sum of all its positive
divisors except itself.
Now, given an integer n, write a function that returns true when it is a perfect number and false
when it is not.
Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
*/
/*
Complexity Analysis
Time complexity : O(sqrt(n))
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num <= 0) {
            return false;
        }
        
        int sum = 0;
        
        for(int i = 1; i * i <= num; i++) {
            if(num % i == 0) {
                sum += i;
                if(i * i != num) {
                    sum += num / i;
                }
            }
        }
        
        return sum - num == num;
    }
}

</code></pre>
</div>
</div>
