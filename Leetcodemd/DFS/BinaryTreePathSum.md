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
/* Binary Tree Path SumGiven a binary tree, find all paths that sum of the nodes in the path equals to a given numbertarget.A valid path is from root node to any of the leaf nodes.Have you met this question in a real interview? YesExampleGiven a binary tree, and target = 5:     1    / \   2   4  / \ 2   3return[  [1, 2, 2],  [1, 4]]*//** * Definition of TreeNode: * public class TreeNode { *     public int val; *     public TreeNode left, right; *     public TreeNode(int val) { *         this.val = val; *         this.left = this.right = null; *     } * } */    /**     * @param root the root of binary tree     * @param target an integer     * @return all valid paths     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        
        List<Integer> path = new ArrayList<Integer>();
        path.add(root.val);//注意这里的先加， 因为不可能有空集的情况！！！！！
        DFS(result, path, root, root.val, target);
        return  result;
    }
    
    private void DFS(List<List<Integer>> result, List<Integer> path, TreeNode root, int sum, int target) {
        if(root.left == null && root.right == null) {
            if(sum == target) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
              
        if(root.left != null) {
            path.add(root.left.val);//注意这里的先加， 因为不可能有空集的情况！！！！！
            DFS(result, path, root.left, sum + root.left.val, target);
            path.remove(path.size() - 1);
        }
        
        if(root.right != null) {
            path.add(root.right.val);
            DFS(result, path, root.right, sum + root.right.val, target);
            path.remove(path.size() - 1);
        }
    }
}</code></pre>
</div>
</div>
