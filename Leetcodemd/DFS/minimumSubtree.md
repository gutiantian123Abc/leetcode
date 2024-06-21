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
/* Minimum Subtree (Related Problem: Subtree with Maximum Average)Given a binary tree, find the subtree with minimum sum. Return the root ofthe subtree.ExampleGiven a binary tree:     1   /   \ -5     2 / \   /  \0   2 -4  -5return the node 1.*//** * Definition of TreeNode: * public class TreeNode { *     public int val; *     public TreeNode left, right; *     public TreeNode(int val) { *         this.val = val; *         this.left = this.right = null; *     } * } */    /**     * @param root the root of binary tree     * @return the root of the minimum subtree     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
     
    private class ResultType { //注意巧用 ResultType
        public int sum;
        public int minSum;
        public TreeNode minNode;
        
        public ResultType(int sum, int minSum, TreeNode minNode) {
            this.sum = sum;
            this.minSum = minSum;
            this.minNode = minNode;
        }
    }
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        if(root == null || root.left == null && root.right == null) {
            return root;
        }
        
        ResultType answer = helper(root);
        return answer.minNode;
    }
    
    private ResultType helper(TreeNode root) {
        if(root == null) {
            return new ResultType(0, Integer.MAX_VALUE, null); //注意这里是min, 不是avg, 所以要用Integer.MAX_VALUE 而不是0!!!
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int currSum = root.val + left.sum + right.sum;
        
        if(currSum < left.minSum && currSum < right.minSum) {
            return new ResultType(currSum, currSum, root);
        }else {
            if(left.minSum < right.minSum) {
                return new ResultType(currSum, left.minSum, left.minNode);
            }else {
                return new ResultType(currSum, right.minSum, right.minNode);
            }
        }
    }
}</code></pre>
</div>
</div>
