/* Evaluate Reverse Polish Notation
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Have you met this question in a real interview? Yes
Example
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        // Write your code here
        Stack<Integer> stack = new Stack<Integer>();
        Set<String> signs = new HashSet<String>();
        signs.add("+");
        signs.add("-");
        signs.add("*");
        signs.add("/");
        
        for(int i = 0; i < tokens.length; i++) {
            
            String word = tokens[i];
            if(!signs.contains(word)) {
                
                stack.push(Integer.valueOf(word)); //Integer.valueOf(word)   String.valueOf(word) 注意用法
                
            }else {
                
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                
                if(word.equals("+")) {
                    stack.push(num1 + num2);//栈反哺
                }else if(word.equals("-")) {
                    stack.push(num1 - num2);//栈反哺
                }else if(word.equals("*")) {
                    stack.push(num1 * num2);//栈反哺
                }else {//   /
                    stack.push(num1 / num2);//栈反哺
                }
                
            }
            
        }
        
        return stack.pop();
    }
}