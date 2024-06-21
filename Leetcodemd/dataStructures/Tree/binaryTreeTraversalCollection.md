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
/* Binary Tree Preorder TraversalGiven a binary tree, return the preorder traversal of its nodes' values.ExampleGiven:    1   / \  2   3 / \4   5return [1,2,4,5,3].*//** * Definition of TreeNode: * public class TreeNode { *     public int val; *     public TreeNode left, right; *     public TreeNode(int val) { *         this.val = val; *         this.left = this.right = null; *     } * } */    /**     * @param root: The root of binary tree.     * @return: Preorder in ArrayList which contains node values.     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        
        helper(result, root);
        return result;
    }
    
    private void helper(ArrayList<Integer> result, TreeNode root) {
        if(root == null) {
            return;
        }
        
        result.add(root.val);
        helper(result, root.left);
        helper(result, root.right);
    }
}</code></pre>
</div>
</div>
