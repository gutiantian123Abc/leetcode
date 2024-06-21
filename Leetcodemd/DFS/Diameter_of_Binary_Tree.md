<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 1000px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Diameter of Binary Tree
Given a binary tree, you need to compute the length of the diameter of the tree. 
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges 
between them.
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
    private int maxLen = 0;
    private class resultType{
        int val = 0;
        public resultType(int val) {
            this.val = val;
        }
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        helper(root);
        return maxLen - 1;
    }
    
    private resultType helper(TreeNode root) {
        if(root.left == null && root.right == null) {
            maxLen = Math.max(1, maxLen);
            return new resultType(1);
        }else if(root.right == null) {
            int left = helper(root.left).val;
            maxLen = Math.max(left + 1, maxLen);
            return new resultType(left + 1);
        }else if(root.left == null) {
            int right = helper(root.right).val;
            maxLen = Math.max(right + 1, maxLen);      
            return new resultType(right + 1);
        }else {
            int right = helper(root.right).val;
            int left = helper(root.left).val;
            maxLen = Math.max(right + left + 1, maxLen);
            return new resultType(Math.max(left, right) + 1);
        }
    }
}</code></pre>
</div>
</div>
