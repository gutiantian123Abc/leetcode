<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 600px; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* House Robber III
The thief has found himself a new place for his thievery again. 
There is only one entrance to this area, called the "root." 
Besides the root, each house has one and only one parent house. 
After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.
Example
  3
 / \
2   3
 \   \ 
  3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

    3
   / \
  4   5
 / \   \ 
1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
/* 典型的DFS divide conquer + tree
*/
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


public class Solution {
    public class ResultType {
        public int rob;
        public int notRob;
        
        public ResultType() {
            rob = 0;
            notRob = 0;
        }
    }
    
    
    public int houseRobber3(TreeNode root) {
        // write your code here
        ResultType ans = traverse(root);
        return Math.max(ans.rob, ans.notRob);
    }
    
    private ResultType traverse(TreeNode root) {
        ResultType ans = new ResultType();
        if(root == null) {
            return ans;
        }
        
        ResultType leftAns;
        ResultType rightAns;
        
        if(root.right == null && root.left == null) {
            ans.rob = root.val;
        }else if(root.right == null) { //root.left != null
            leftAns = traverse(root.left);
            ans.rob = root.val + leftAns.notRob;
            ans.notRob = Math.max(leftAns.rob, leftAns.notRob);
        }else if(root.left == null) {//root.right != null
            rightAns = traverse(root.right);
            ans.rob = root.val + rightAns.notRob;
            ans.notRob = Math.max(rightAns.rob, rightAns.notRob);
        }else {
            leftAns = traverse(root.left);
            rightAns = traverse(root.right);
            ans.rob = root.val + leftAns.notRob + rightAns.notRob;
            ans.notRob = Math.max(leftAns.rob, leftAns.notRob) + Math.max(rightAns.rob, rightAns.notRob);
        }
        
        return ans;
    }
}</code></pre>
</div>
</div>
