/* Generate Parentheses
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Example
Given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
*/
public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
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
