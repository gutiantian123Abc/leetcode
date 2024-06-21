<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Equal Tree Partition
Given a binary tree with n nodes, your task is to check if it's 
possible to partition the tree to two trees which have the equal 
sum of values after removing exactly one edge on the original tree.

Example 1:
Input:     
    5
   / \
  10 10
    /  \
   2   3

Output: True
Explanation: 
    5
   / 
  10
      
Sum: 15

   10
  /  \
 2    3

Sum: 15
Example 2:
Input:     
    1
   / \
  2  10
    /  \
   2   20

Output: False
Explanation: You can't split the tree into two trees with equal sum 
after removing exactly one edge on the tree.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    private TreeNode realroot;
    private class ResultType1 {
        int sum = 0;
        public ResultType(int sum) {
            this.sum = sum;
        }
    }
    
    private class ResulType2 {
        int sum = 0;
        boolean match = false;
        public ResulType2(int sum, boolean match) {
            this.sum = sum;
            this.match = match;
        }
    }
    
    public boolean checkEqualTree(TreeNode root) {
        realroot = root;
        int total = getTotalSum(root).sum;
        if(total % 2 != 0) {
            return false;
        }
        return check(total / 2, root).match;
    }
    
    private ResulType2 check(int half, TreeNode root) {
        if(root == null) {
            return new ResulType2(0, false);
        }
        
        ResulType2 left = check(half, root.left);
        ResulType2 right = check(half, root.right);
        
        if(left.match || right.match) {
            return new ResulType2(0, true);
        }else {
            if(root.val + left.sum + right.sum == half && root != realroot) {
                return new ResulType2(0, true);
            }else {
                 return new ResulType2(root.val + left.sum + right.sum, false);
            }
        }
    }
    
    private ResultType1 getTotalSum(TreeNode root) {
        if(root == null) {
            return new ResultType1(0);
        }
            
        ResultType1 left = getTotalSum(root.left);
        ResultType1 right = getTotalSum(root.right);
        return new ResultType1(left.sum + right.sum + root.val);
    }
}</code></pre>
</div>
</div>
