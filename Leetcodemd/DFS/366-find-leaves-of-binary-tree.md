<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 366. Find Leaves of Binary Tree

https://leetcode.com/problems/find-leaves-of-binary-tree/

Given the root of a binary tree, collect a tree's nodes as if you were doing this:

Collect all the leaf nodes.
Remove all the leaf nodes.
Repeat until the tree is empty.
 

Example 1:
Input: root = [1,2,3,4,5]
Output: [[4,5,3],[2],[1]]
Explanation:
[[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per 
each level it does not matter the order on which elements are returned.


Example 2:
Input: root = [1]
Output: [[1]]
 

Constraints:
The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }

        while(root.left != null || root.right != null) {
            List<Integer> list = new ArrayList<>();
            dfs(root, list);
            ans.add(list);
        }

        List<Integer> rootVal = new ArrayList<>();
        rootVal.add(root.val);
        ans.add(rootVal);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        TreeNode left = root.left; TreeNode right = root.right;

        if(left != null) {
            if(left.left == null && left.right == null) {
                list.add(left.val);
                root.left = null;
            } else { 
                dfs(root.left, list);
            }
        }

        if(right != null) {
            if(right.left == null && right.right == null) {
                list.add(right.val);
                root.right = null;
            } else {
                dfs(root.right, list);
            }
        }
    }
}
</code></pre>
</div>
</div>
