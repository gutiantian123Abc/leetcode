/* Inorder Predecessor in BST
Given a binary search tree and a node in it, find the in-order 
predecessor of that node in the BST.

Note: If the given node has no in-order predecessor in the tree, return null.

In Binary Tree, Inorder predecessor of a node is the last node in 
Inorder traversal of the Binary Tree. 
Inorder predecessor is NULL for the first node in Inorder traversal.
In Binary Search Tree, Inorder predecessor of an input node can also 
be defined as the node with the largerst key smaller than the key of input node. 
So, it is sometimes important to find last node in sorted order.

                   20
                  /  \
                 8   22
                / \
               4   12
                  /  \
                 10  14 

In the above diagram, inorder predecessor of 8 is 4, 
inorder predecessor of 10 is 8 and inorder predecessor of 14 is 12.
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
class Solution {
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while(root != null) {
            if(p.val <= root.val) { //往左拐
            	succ = root;
                root = root.left;
            }else { //往右拐
                root = root.right;
            }
        }
        
        return succ;
    }
}
