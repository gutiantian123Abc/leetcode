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
/* Binary Tree Longest Consecutive SequenceGiven a binary tree, find the length of the longest consecutive sequence path.The path refers to any sequence of nodes from some starting node to any node in the tree along theparent-child connections.The longest consecutive path need to be from parent to child (cannot be the reverse).ExampleFor example,   1    \     3    / \   2   4        \         5Longest consecutive sequence path is 3-4-5, so return 3.   2    \     3    /   2  / 1Longest consecutive sequence path is 2-3,not3-2-1, so return 2.*//** * Definition for a binary tree node. * public class TreeNode { *     int val; *     TreeNode left; *     TreeNode right; *     TreeNode(int x) { val = x; } * } */    /**     * @param root the root of binary tree     * @return the length of the longest consecutive sequence path     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
     
    private class ResultType { // ResultType, Divede&Conquer to deal with Binary Tree Problem
        public int maxLength;
        public int maxLengthFromRoot;
        public ResultType(int maxLength, int maxLengthFromRoot) {
            this.maxLength = maxLength;
            this.maxLengthFromRoot = maxLengthFromRoot;
        }
    }
    
    public int longestConsecutive(TreeNode root) {
        // Write your code here
        ResultType answer = helper(root);
        return answer.maxLength;
    }
    
    private ResultType helper(TreeNode root) {
        if(root == null) {
            return new ResultType(0, 0);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        ResultType answer = new ResultType(1,1);
        
        if(root.left != null && root.val == root.left.val - 1) {
            answer.maxLengthFromRoot = 1 + left.maxLengthFromRoot;
        }

        if(root.right != null && root.val == root.right.val - 1) {
            answer.maxLengthFromRoot = Math.max(1 + right.maxLengthFromRoot, answer.maxLengthFromRoot);
        } 
    
        answer.maxLength = Math.max(answer.maxLength, answer.maxLengthFromRoot);
        
        answer.maxLength = Math.max(answer.maxLength, Math.max(left.maxLength, right.maxLength));
        
        return answer;
    }
}</code></pre>
</div>
</div>
