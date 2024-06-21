## Problem Description
```
/* Expression Expand
Given an expression s includes numbers, letters and brackets. 
Number represents the number of repetitions inside the brackets(can be a string or another expression)．
Please expand expression to be a string.
Example
s = abc3[a] return abcaaa
s = 3[abc] return abcabcabc
s = 4[ac]dy, return acacacacdy
s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz
*/
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
## Solution
```java

//这道题也可以用recursion的方法做， 详见recursion解法
public class Solution {
    public String expressionExpand(String s) {
        // Write your code here
        Stack<Object> stack = new Stack<Object>();
        
        char[] word = s.toCharArray();
        int number = 0;
        
        for(int index = 0; index < word.length; index++) {
            char c = word[index];
            
            if(Character.isDigit(c)) {
                number = c - '0';
                while(index + 1 < word.length && Character.isDigit(word[index + 1])) {
                    index++;
                    number = number * 10 + word[index] - '0';
                }
                
            }else if(c == '[') {
                
                stack.push(Integer.valueOf(number)); //Integer.valueOf(word)   String.valueOf(word) 注意用法
                number = 0;
                
            }else if(c == ']') {
                
                String subString = popStack(stack);
                Integer count = (Integer)stack.pop();
                
                for(int i = 0; i < count; i++) {
                    stack.push(subString);//反哺栈
                }
                
            }else {
                
                stack.push(String.valueOf(c));
                
            }
        }
        
        return popStack(stack);
    }
    
    
    private String popStack(Stack<Object> stack) {//吐出栈 + 翻转栈
        
        StringBuilder sb = new StringBuilder();
        Stack<String> subStack = new Stack<String>();
        
        while(stack.size() != 0 && stack.peek() instanceof String) {
            subStack.push((String)stack.pop());
        }
        
        while(subStack.size() != 0) {
            sb.append(subStack.pop());
        }
        
        return sb.toString();
    }
}