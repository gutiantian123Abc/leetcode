<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container {{ max-width: 100%; margin: 0 auto; padding: 10px; }}
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Find Duplicate Subtrees 
Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, 
you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.
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

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return result;
    }
    
    private String dfs(TreeNode node) {
        if(node == null) {
            return "#";
        }
        
        String str = node.val + "," + dfs(node.left) + "," + dfs(node.right); //serilize tree 必须是这个order node.val + "," + node.left + "," + node.right
        int hashCode = str.hashCode();
        if(!map.containsKey(hashCode)) {
            map.put(hashCode, 0);
        }
        
        map.put(hashCode, map.get(hashCode) + 1);
        if(map.get(hashCode) == 2) {
            result.add(node);
        }
        return str;
    }
}</code></pre>
</div>
</div>
