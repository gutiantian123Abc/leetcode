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
/* 301. Remove Invalid Parentheseshttps://leetcode.com/problems/remove-invalid-parentheses/Given a string s that contains parentheses and letters,remove the minimum number of invalid parentheses to make the input string valid.Return all the possible results. You may return the answer in any order.Example 1:Input: s = "()())()"Output: ["(())()","()()()"]Example 2:Input: s = "(a)())()"Output: ["(a())()","(a)()()"]Example 3:Input: s = ")("Output: [""]*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int maxLen = Integer.MIN_VALUE;
    public HashSet<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        bt(s, 0, 0, new StringBuilder(), 0);
        List<String> solution = new ArrayList<>();
        for(String str : set) {
            if(str.length() == maxLen) {
                solution.add(str);
            }
        }
        
        return solution;
    }
    
    private void bt(String s, int leftNum, int rightNum, StringBuilder sb, int index) {
        if(index == s.length()) {
            String str = sb.toString();
            if(isValid(str)) {
                maxLen = Math.max(maxLen, str.length());
                if(str.length() == maxLen) {
                    set.add(str);
                }
            }
            return;
        }

        char c = s.charAt(index);
        if(c != '(' && c != ')') {
            sb.append(c);
            bt(s, leftNum, rightNum, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }else{
            if(c == '(') {
                // add 
                sb.append(c);
                bt(s, leftNum + 1, rightNum, sb, index + 1);
                sb.deleteCharAt(sb.length() - 1);
                
                // or remove
                bt(s, leftNum, rightNum, sb, index + 1);
            }else if(c == ')') {
                if(rightNum >= leftNum) {
                    //remove
                    bt(s, leftNum, rightNum, sb, index + 1);
                }else if(rightNum < leftNum) {
                    //add 
                    sb.append(c);
                    bt(s, leftNum, rightNum + 1, sb, index + 1);
                    sb.deleteCharAt(sb.length() - 1);

                    //or remove
                    bt(s, leftNum, rightNum, sb, index + 1);
                }              
            }
        }
    }
    
    
    
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != '(' && c != ')') {
                continue;
            }
            if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}</code></pre>
</div>
</div>
