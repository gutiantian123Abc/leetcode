<style>
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 1249. Minimum Remove to Make Valid Parentheses

https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/


Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) 
so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 

Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public String minRemoveToMakeValid(String s) {
        List<Integer> removedIndexes = new ArrayList<>();
        Stack<Integer> leftPIndexes = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(leftPIndexes.isEmpty()) {
                    removedIndexes.add(i);
                } else {
                    leftPIndexes.pop();
                }
            } else if(c == '(') {
                leftPIndexes.push(i);
            }
        }

        while(!leftPIndexes.isEmpty()) {
            removedIndexes.add(leftPIndexes.pop());
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(!removedIndexes.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}</code></pre>
</div>
