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
/*  Binary Tree Paths // DFS Traversal Mode, see Divide&Qonquer mode in divede
and qonquer
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
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//VI: Traditional Version 重复利用ArrayList, 不断加，减， 返回， Backtracking
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        if(root == null) {
            return result;
        }
        
        ArrayList<String> path = new ArrayList<String>();
        path.add(String.valueOf(root.val)); //注意这种边缘化处理
        
        dfsTraverse(result, path, root);
        return result;
        
    }
    
    private void dfsTraverse(List<String> result, ArrayList<String> path, TreeNode root) {
        if(root == null) {
            return;
        }
        
        if(root.left == null && root.right == null) {
            String answer = "";
            for(String str : path) {
                answer += str + "->";
            }
            answer = answer.substring(0, answer.length() - 2);
            result.add(answer);
            return;
        }
        
        if(root.left != null) {
            path.add(String.valueOf(root.left.val)); //注意这种边缘化处理
            dfsTraverse(result, path, root.left);
            path.remove(path.size() - 1);
        }
        
        if(root.right != null) {
            path.add(String.valueOf(root.right.val)); //注意这种边缘化处理
            dfsTraverse(result, path, root.right);
            path.remove(path.size() - 1);
        }        
    }
}



//Non-Backtracking DFS version:

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        if(root == null) {
            return result;
        }
        
        String path = String.valueOf(root.val);Binary Tree Paths
        dfsNonBacktrackingTraverse(result, path, root);
        return result;
    }
    
    private void dfsNonBacktrackingTraverse(List<String> result, String path, TreeNode root) {
        if(root == null) {
            return;
        }
        
        if(root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        
        if(root.left != null) {
            //path = path + "->" + String.valueOf(root.left.val); No!!!!!! Or it is gonna be backtracking
            String newPath = path + "->" + String.valueOf(root.left.val); // Right way
            dfsNonBacktrackingTraverse(result, newPath, root.left);
        }
        
        if(root.right != null) {
            //path = path + "->" + String.valueOf(root.right.val); No!!!!!! Or it is gonna be backtracking
            String newPath = path + "->" + String.valueOf(root.right.val); // Right way
            dfsNonBacktrackingTraverse(result, newPath, root.right);
        }        
    }
}


</code></pre>
</div>
</div>
