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
/* Binary Tree Level Order Traversal // 典型的BFS题目， 铭记！！！Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right,level by level).ExampleGiven binary tree {3,9,20,#,#,15,7},    3   / \  9  20    /  \   15   7return its level order traversal as:[  [3],  [9,20],  [15,7]]*//** * Definition of TreeNode: * public class TreeNode { *     public int val; *     public TreeNode left, right; *     public TreeNode(int val) { *         this.val = val; *         this.left = this.right = null; *     } * } */    /**     * @param root: The root of binary tree.     * @return: Level order a list of lists of integer     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

 
 
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }                
            }
            
            result.add(new ArrayList<Integer>(list));
        }
        
        return result;
    }
}</code></pre>
</div>
</div>
