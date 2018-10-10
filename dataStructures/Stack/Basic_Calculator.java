/* 224. Basic Calculator
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), 
the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
*/

class Solution {
    public int calculate(String s) {
        int res = 0, sign = 1, i = 0;
        Stack<Integer> stack = new Stack<>();
        while(i < s.length()) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int tmp = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    tmp = 10 * tmp + (s.charAt(i) - '0');
                    i++;
                }
                res = res + tmp * sign;
            }else if(c == '+') {
                sign = 1;
                i++;
            }else if(c == '-') {
                sign = -1;
                i++;
            }else if(c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
                i++;
            }else if(c == ')') {
                int prevSign = stack.pop();
                int prevRes = stack.pop();
                res = prevRes + res * prevSign;
                i++;
            }else {
                i++;
            }
        }
        
        return res;
        
    }
}