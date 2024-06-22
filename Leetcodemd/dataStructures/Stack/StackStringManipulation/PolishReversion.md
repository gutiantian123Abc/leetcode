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
/* Evaluate Reverse Polish Notation
Evaluate the value of an arithmetic expression in
Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may
be an integer or another expression.
Have you met this question in a real interview?
Yes
Example
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
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
}</code></pre>
</div>
</div>
