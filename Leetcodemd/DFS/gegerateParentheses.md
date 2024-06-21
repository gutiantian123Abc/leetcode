<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 500px; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Example
Given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
*/
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        helper(res, sb, n, n);
        return res;
    }
    
    private void helper(ArrayList<String> res, StringBuilder sb, int left, int right) {
        if(left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        //注意这里left 和 right 是如何处理的
        if(left > 0) {
            sb.append('(');
            helper(res, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(right > 0 && right > left) {
            sb.append(')');
            helper(res, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);            
        }
    }
}
</code></pre>
</div>
</div>
