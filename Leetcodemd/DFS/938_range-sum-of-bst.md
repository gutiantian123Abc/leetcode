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
/*938. range-sum-of-bsthttps://leetcode.com/problems/range-sum-of-bstGiven the root node of a binary search tree and two integers low and high,return the sum of values of all nodes with a value in the inclusive range [low, high].Example 1:Input: root = [10,5,15,3,7,null,18], low = 7, high = 15Output: 32Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.Example 2:Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10Output: 23Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.Constraints:The number of nodes in the tree is in the range [1, 2 * 104].1 <= Node.val <= 1051 <= low <= high <= 105All Node.val are unique.*//** * Definition for a binary tree node. * public class TreeNode { *     int val; *     TreeNode left; *     TreeNode right; *     TreeNode() {} *     TreeNode(int val) { this.val = val; } *     TreeNode(int val, TreeNode left, TreeNode right) { *         this.val = val; *         this.left = left; *         this.right = right; *     } * } */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high, 0);
    }

    public int dfs(TreeNode node, int low, int high, int sum) {
        if (node == null) {
            return 0;
        }

        if (high < node.val) {
            return dfs(node.left, low, high, sum);
        } else if (node.val < low) {
            return dfs(node.right, low, high, sum);
        } else {
            return node.val + dfs(node.left, low, high, sum) + dfs(node.right, low, high, sum);
        }
    }
}</code></pre>
</div>
</div>
