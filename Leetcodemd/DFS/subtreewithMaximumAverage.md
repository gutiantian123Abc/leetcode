<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Subtree with Maximum Average (Related Problem: Minimum Subtree)
Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
Example
Given a binary tree:

     1
   /   \
 -5     11
 / \   /  \
1   2 4    -2 
return the node 11.
*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    private class ResultType {  // 当要返回多个value的时候，巧用 ResultType!!!!
        public double avg;
        public int size;
        public double maxAvg;
        public TreeNode maxNode;
        public ResultType(int size, double avg, double maxAvg, TreeNode maxNode) {
            this.size = size;
            this.avg = avg;
            this.maxAvg = maxAvg;
            this.maxNode = maxNode;
        }
    }
    
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        if(root == null || root.left == null && root.right == null) {
            return root;
        }  
        ResultType result = helper(root);
        return result.maxNode;
    }
    
    private ResultType helper(TreeNode root) {
        if(root == null) {
            return new ResultType(0, 0, 0, null);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        double currAvg = ((double)root.val + left.avg * left.size + right.avg * right.size) / (1 + left.size + right.size);
        
        if(currAvg > left.maxAvg && currAvg > right.maxAvg) {
            return new ResultType(1 + left.size + right.size, currAvg, currAvg, root);
        }else {
            if(left.maxAvg > right.maxAvg) {
                return new ResultType(1 + left.size + right.size, currAvg, left.maxAvg, left.maxNode);
            }else {
                return new ResultType(1 + left.size + right.size, currAvg, right.maxAvg, right.maxNode);                
            }
        }
    }
}</code></pre>
</div>
</div>
