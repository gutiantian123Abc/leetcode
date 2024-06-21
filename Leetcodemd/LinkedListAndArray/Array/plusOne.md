<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 700px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*Given a non-negative number represented as an array of digits, plus one to the number.The digits are stored such that the most significant digit is at the head of the list.ExampleGiven [1,2,3] which represents 123, return [1,2,4].Given [9,9,9] which represents 999, return [1,0,0,0].*/    /**     * @param digits a number represented as an array of digits     * @return the result     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int[] plusOne(int[] digits) {
       int res = 0;
       int carry = 1;
       for(int i = digits.length - 1; i >= 0; i--) {
           
           int temp = (digits[i] + carry) % 10;
           carry = (digits[i] + carry) / 10;
           digits[i] = temp;
       }
       
       if(carry == 0) {
           return digits;
       }
       
       int[] answer = new int[digits.length + 1];
       answer[0] = carry;
       for(int i = 0; i < digits.length; i++) {
           answer[i+1] = digits[i];
       }
       return answer;    
    }
}</code></pre>
</div>
</div>
