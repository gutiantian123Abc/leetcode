/* Find Bottom Left Tree Value
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.
*/

//注解， 这道题既可以用divide conquer, 又可以用bfs


//Divide Conquer:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private class ResultType {
        TreeNode node = new TreeNode(0);
        int depth = 0;
        
        public ResultType(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    
    public int findBottomLeftValue(TreeNode root) {
        ResultType res = helper(root, 0);
        return res.node.val;
    }
    
    private ResultType helper(TreeNode root, int depth) {
        if(root.left == null && root.right == null) {
            return new ResultType(root, depth);
        }
        
        if(root.left == null) {
            return helper(root.right, depth + 1);
        }
        
        if(root.right == null) {
            return helper(root.left, depth + 1);
        }
        
        ResultType left = helper(root.left, depth + 1);
        ResultType right = helper(root.right, depth + 1);
        
        if(left.depth >= right.depth) {
            return left;
        }else {
            return right;
        }  
    }  
}