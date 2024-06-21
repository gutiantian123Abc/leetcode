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
/* Binary Tree Paths DQ mode (注意看 traverse mode)
Given a binary tree, return all root-to-leaf paths.

Example
Given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

[
  "1->2->5",
  "1->3"
]
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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution { //记住， DQ 方法一定是返回 Result!!!!!!!!!!!!
     
    private class ResultType {
        public List<String> paths;
        public ResultType(List<String> paths) {
            this.paths = paths;//记住， DQ 方法一定是返回 Result!!!!!!!!!!!!
        }
    } 
    
    public List<String> binaryTreePaths(TreeNode root) {
        // Divide Qonquer
        
        List<String> result = new ArrayList<String>();
        if(root == null) {
            return result;
        }
        
        ResultType answer = helper(root);
        return answer.paths;
    }
    
    private ResultType helper(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if(root.left == null && root.right == null) {
            paths.add(String.valueOf(root.val));
            return new ResultType(paths);
        }
        
        if(root.left != null) {
            ResultType left = helper(root.left);
            List<String> leftPaths = left.paths;
            for(String leftPath : leftPaths) {
                paths.add(String.valueOf(root.val) + "->" + leftPath);
            }
        }
        
        if(root.right != null) {
            ResultType right = helper(root.right);
            List<String> rightPaths = right.paths;
            for(String rightPath : rightPaths) {
                paths.add(String.valueOf(root.val) + "->" + rightPath);
            }
        }
        return new ResultType(paths);
    }
}</code></pre>
</div>
</div>
