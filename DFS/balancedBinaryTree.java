/* Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differ by more than 1.

Example
Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}

A)  3            B)    3 
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7
The binary tree A is a height-balanced binary tree, but B is not.
*/

//Solution 1:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
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
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    private class ResultType {
        public int depth;
        public boolean isBalanced;
        
        public ResultType(int depth, boolean isBalanced) {
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }
    public boolean isBalanced(TreeNode root) {
        // write your code here
        ResultType answer = helper(root);
        return answer.isBalanced;
    }
    
    private ResultType helper(TreeNode root) {
        if(root == null) {
            return new ResultType(0, true);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        if(left.isBalanced == false || right.isBalanced == false || 
        Math.abs(left.depth - right.depth) > 1) {
            return new ResultType(-1, false);
        }
        
        return new ResultType(1 + Math.max(left.depth, right.depth), true);
    }
}