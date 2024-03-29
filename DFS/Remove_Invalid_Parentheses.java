/* 301. Remove Invalid Parentheses
https://leetcode.com/problems/remove-invalid-parentheses/

Given a string s that contains parentheses and letters, 
remove the minimum number of invalid parentheses to make the input string valid.

Return all the possible results. You may return the answer in any order.

 

Example 1:

Input: s = "()())()"
Output: ["(())()","()()()"]
Example 2:

Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]
Example 3:

Input: s = ")("
Output: [""]

*/

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
}