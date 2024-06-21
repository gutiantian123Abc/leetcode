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
/* Convert Sorted Array to Binary Search TreeGiven a sorted (increasing order) array,Convert it to create a binary tree with minimal height(Balanced HeightBST).NoticeThere may exist multiple valid solutions, return any of them.ExampleGiven [1,2,3,4,5,6,7], return     4   /   \  2     6 / \    / \1   3  5   7*//** * Definition of TreeNode: * public class TreeNode { *     public int val; *     public TreeNode left, right; *     public TreeNode(int val) { *         this.val = val; *         this.left = this.right = null; *     } * } */    /**     * @param A: an integer array     * @return: a tree node     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        if(A == null || A.length == 0) {
            return null;
        }
        return buildTree(A, 0, A.length - 1);        
    }  
    private TreeNode buildTree(int[] A, int start, int end) {
        if(start > end) {
            return null;
        }
        TreeNode root = new TreeNode(A[(start + end) / 2]);
        root.left = buildTree(A, start, (start + end) / 2 - 1);
        root.right = buildTree(A, (start + end) / 2 + 1, end);
        return root;
    }
}
</code></pre>
</div>
</div>
