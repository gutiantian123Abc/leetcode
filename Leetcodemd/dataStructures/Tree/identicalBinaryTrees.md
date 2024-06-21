<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 50px auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Identical Binary Tree
Check if two binary trees are identical. 
Identical means the two binary trees have the same structure and every identical 
position has the same value.
Example
    1             1
   / \           / \
  2   2   and   2   2
 /             /
4             4
are identical.

    1             1
   / \           / \
  2   3   and   2   3
 /               \
4                 4
are not identical.
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
     * @param a, b, the root of binary trees.
     * @return true if they are identical, or false.
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if(a == null && b == null) {
            return true;
        }else if (a == null) {
            return false;
        }else if (b == null) {
            return false;
        }else {
            return a.val == b.val && isIdentical(a.left , b.left) && isIdentical(a.right , b.right);
        }
    }
}</code></pre>
</div>
</div>
