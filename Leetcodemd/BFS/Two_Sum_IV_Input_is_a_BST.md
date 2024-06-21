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
/* Two Sum IV - Input is a BST
Given a Binary Search Tree and a target number, 
return true if there exist two elements in the BST such that their sum is 
equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
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

//本体只是一个不少的traverse 一遍 Tree, 然后用 TWO SUM 惯用的 HashMap 或 HashSet 记录就好
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(set.contains(k - cur.val)) {
                    return true;
                }
            
                set.add(cur.val);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        
        return false;
    }
}

</code></pre>
</div>
</div>
