<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 600px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 655. Add Strings
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Example
Given num1 = "123", num2 = "45"
return "168"

Notice
The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int carry = 0;
        int i = m - 1, j = n - 1;
        String res = "";
        
        while(i >= 0 || j >= 0) {
            int a = 0, b = 0;
            
            if(i >= 0) {
                a = num1.charAt(i) - '0';
                i--;
            }
            
            if(j >= 0) {
                b = num2.charAt(j) - '0';
                j--;
            }
            
            int sum = a + b + carry;
            res = (char)('0' + sum % 10) + res;
            carry = sum / 10;
        }
        
        return carry == 0 ? res : "1" + res;
        
    }
}
</code></pre>
</div>
</div>
