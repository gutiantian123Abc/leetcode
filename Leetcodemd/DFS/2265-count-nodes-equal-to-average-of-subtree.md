<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 500px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 2265. Count Nodes Equal to Average of Subtree

https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/

Given the root of a binary tree, return the number of nodes where the value of the 
node is equal to the average of the values in its subtree.

Note:

The average of n elements is the sum of the n elements divided by n and rounded 
down to the nearest integer.
A subtree of root is a tree consisting of root and all of its descendants.
 

Example 1:


Input: root = [4,8,5,0,1,null,6]
Output: 5
Explanation: 
For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
For the node with value 0: The average of its subtree is 0 / 1 = 0.
For the node with value 1: The average of its subtree is 1 / 1 = 1.
For the node with value 6: The average of its subtree is 6 / 1 = 6.
Example 2:


Input: root = [1]
Output: 1
Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000
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
    class Node {
        int sum;
        int num;
        int equalNum;
        public Node(int sum, int num, int equalNum) {
            this.sum = sum;
            this.num = num;
            this.equalNum = equalNum;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        Node node = dfs(root);
        return node.equalNum;
    }

    private Node dfs(TreeNode root) {
        if(root == null) {
            return null;
        }

        Node left = dfs(root.left);
        Node right = dfs(root.right);
        int totalSubSum = 0, totalSubNum = 0, totalSubEqual = 0;
        if(left != null) {
            totalSubSum += left.sum;
            totalSubNum += left.num;
            totalSubEqual += left.equalNum;
        }
        if(right != null) {
            totalSubSum += right.sum;
            totalSubNum += right.num;
            totalSubEqual += right.equalNum;
        }

        if(root.val == (root.val + totalSubSum) / (totalSubNum + 1)) {
            return new Node(root.val + totalSubSum, totalSubNum + 1, totalSubEqual + 1);
        }else {
            return new Node(root.val + totalSubSum, totalSubNum + 1, totalSubEqual);
        }
    }
}</code></pre>
</div>
</div>
