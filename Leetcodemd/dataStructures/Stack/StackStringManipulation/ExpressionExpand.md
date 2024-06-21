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
/* Expression ExpandGiven an expression s includes numbers, letters and brackets.Number represents the number of repetitions inside the brackets(can be astring or another expression)．Please expand expression to be a string.Examples = abc3[a] return abcaaas = 3[abc] return abcabcabcs = 4[ac]dy, return acacacacdys = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz*/    /**     * @param s  an expression includes numbers, letters and brackets     * @return a string     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

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
}</code></pre>
</div>
</div>
