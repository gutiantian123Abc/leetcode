<style>
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from 
the root node down to the farthest leaf node.
*/
/**
 * Definition for a binary tree node.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
 
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root .left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}</code></pre>
</div>