/* Minimum Subtree (Related Problem: Subtree with Maximum Average)
Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

Example
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   2 -4  -5 
return the node 1.
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
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
     
    private class ResultType { //注意巧用 ResultType
        public int sum;
        public int minSum;
        public TreeNode minNode;
        
        public ResultType(int sum, int minSum, TreeNode minNode) {
            this.sum = sum;
            this.minSum = minSum;
            this.minNode = minNode;
        }
    }
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        if(root == null || root.left == null && root.right == null) {
            return root;
        }
        
        ResultType answer = helper(root);
        return answer.minNode;
    }
    
    private ResultType helper(TreeNode root) {
        if(root == null) {
            return new ResultType(0, Integer.MAX_VALUE, null); //注意这里是min, 不是avg, 所以要用Integer.MAX_VALUE 而不是0!!!
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int currSum = root.val + left.sum + right.sum;
        
        if(currSum < left.minSum && currSum < right.minSum) {
            return new ResultType(currSum, currSum, root);
        }else {
            if(left.minSum < right.minSum) {
                return new ResultType(currSum, left.minSum, left.minNode);
            }else {
                return new ResultType(currSum, right.minSum, right.minNode);
            }
        }
    }
}