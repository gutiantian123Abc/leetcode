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
/* 687. Longest Univalue Path
Given a binary tree, find the length of the longest path where each node in the path has the same value. 
This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2
Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.

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

    class ResultType {
        int continuoisLongestUnivalue = 0;
        int globalLongestUnivalue = 0;
        
        public ResultType(int continuoisLongestUnivalue, int globalLongestUnivalue) {
            this.continuoisLongestUnivalue = continuoisLongestUnivalue;
            this.globalLongestUnivalue = globalLongestUnivalue;
        }
    }
    
    public int longestUnivaluePath(TreeNode root) {
        ResultType res = dfs(root);
        return res.globalLongestUnivalue;   
    }
    
    private ResultType dfs(TreeNode root) {
        if(root == null) {
            return new ResultType(0, 0);
        }
        
        int continuoisLongestUnivalue = 0;
        int globalLongestUnivalue = 0;

        ResultType left = dfs(root.left);
        ResultType right = dfs(root.right);
        int subGlobalMax = Math.max(left.globalLongestUnivalue, right.globalLongestUnivalue);
        
        if(root.left != null && root.right != null) {
            
            if(root.val == root.left.val && root.val == root.right.val) {
                continuoisLongestUnivalue = Math.max(left.continuoisLongestUnivalue, right.continuoisLongestUnivalue) + 1;
                globalLongestUnivalue = Math.max(2 + left.continuoisLongestUnivalue + right.continuoisLongestUnivalue, subGlobalMax);
                
            }else if(root.val == root.left.val) {
                continuoisLongestUnivalue = left.continuoisLongestUnivalue + 1;
                globalLongestUnivalue = Math.max(continuoisLongestUnivalue, subGlobalMax);
            }else if(root.val == root.right.val) {
                continuoisLongestUnivalue = right.continuoisLongestUnivalue + 1;
                globalLongestUnivalue = Math.max(continuoisLongestUnivalue, subGlobalMax);                
            }else {
                continuoisLongestUnivalue = 0;
                globalLongestUnivalue = subGlobalMax;
            }

        }else if(root.left != null) {
            
            if(root.val == root.left.val) {
                continuoisLongestUnivalue = left.continuoisLongestUnivalue + 1;
                globalLongestUnivalue = Math.max(continuoisLongestUnivalue, subGlobalMax);
            }else {
                continuoisLongestUnivalue = 0;
                globalLongestUnivalue = subGlobalMax;
            }
            
        }else if(root.right != null) {
            
            if(root.val == root.right.val) {
                continuoisLongestUnivalue = right.continuoisLongestUnivalue + 1;
                globalLongestUnivalue = Math.max(continuoisLongestUnivalue, subGlobalMax);
            }else {
                continuoisLongestUnivalue = 0;
                globalLongestUnivalue = subGlobalMax;
            }
            
        }else {
            
            continuoisLongestUnivalue = 0;
            globalLongestUnivalue = 0;
            
        }
        
        return new ResultType(continuoisLongestUnivalue,globalLongestUnivalue);
    }
}</code></pre>
</div>
</div>
