<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 50px auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Serialize and Deserialize Binary Tree
Design an algorithm and write code to serialize and deserialize a binary tree.
 Writing the tree to a file is called 'serialization' and reading back from 
 the file to reconstruct the exact same binary tree is 'deserialization'.

Example
An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following 
structure:

  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong 
answer and want to debug the input.

You can use other method to do serializaiton and deserialization.

Notice
There is no limit of how you deserialize or serialize a binary tree, 
LintCode will take your output of serialize as the input of deserialize, 
it won't check the result of serialize.
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
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>



public class Solution {
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null) {
            return "{}";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();
            
                if(curNode == null) {
                    sb.append("#");
                }else {
                    sb.append(curNode.val);
                    q.offer(curNode.left);
                    q.offer(curNode.right);
                }
                if(!q.isEmpty()) {
                    sb.append(",");
                }
            }

        }
        
        int i = sb.length() - 1;
        while (sb.charAt(i) == '#') {
            sb.deleteCharAt(i);
            i--;
        }
        sb.append("}");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        // write your code here
        if (data.length() == 0 || data.equals("{}")) {
            return null;
        }
        
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.valueOf(vals[0])), node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (i < vals.length && !queue.isEmpty()) {
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                node = queue.poll();
            
                node.left = i < vals.length && !vals[i].equals("#") ? new TreeNode(Integer.valueOf(vals[i])) : null;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                i++;
                node.right = i < vals.length && !vals[i].equals("#") ? new TreeNode(Integer.valueOf(vals[i])) : null;
                if (node.right != null) {
                    queue.offer(node.right);
                }
                i++;
            }
        }
        
        return root;
    }
}</code></pre>
</div>
</div>
