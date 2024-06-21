## Problem Description
```
/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example
Given [1,2,3] which represents 123, return [1,2,4].
Given [9,9,9] which represents 999, return [1,0,0,0].
*/
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
## Solution
```java

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
}