<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 500px; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 1302 deepest-leaves-sum

https://leetcode.com/problems/deepest-leaves-sum/description/

Given the root of a binary tree, return the sum of values of its deepest leaves.
 

Example 1:


Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        MetaData metaData = dfs(root);
        if (metaData == null) {
            return 0;
        } else {
            return metaData.maxSum;
        }
    }

    public MetaData dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        MetaData left = dfs(node.left);
        MetaData right = dfs(node.right);
        MetaData metaData = new MetaData();

        if (left == null && right == null) {
            metaData.maxDepth = 1;
            metaData.maxSum = node.val;
        } else if (left != null && right == null) {
            metaData.maxDepth = left.maxDepth + 1;
            metaData.maxSum = left.maxSum;
        } else if (left == null && right != null) {
            metaData.maxDepth = right.maxDepth + 1;
            metaData.maxSum = right.maxSum;
        } else {
            if (left.maxDepth == right.maxDepth) {
                metaData.maxDepth = left.maxDepth + 1;
                metaData.maxSum = left.maxSum + right.maxSum;
            } else if (left.maxDepth > right.maxDepth) {
                metaData.maxDepth = left.maxDepth + 1;
                metaData.maxSum = left.maxSum;
            } else {
                metaData.maxDepth = right.maxDepth + 1;
                metaData.maxSum = right.maxSum;
            }
        }
        return metaData;
    }

    public class MetaData {
        int maxDepth;
        int maxSum;
    }
}</code></pre>
</div>
</div>
