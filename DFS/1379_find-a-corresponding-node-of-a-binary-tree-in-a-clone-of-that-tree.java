/*
1379 find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree

https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

Given two binary trees original and cloned and given a reference to a node target in the original tree.

The cloned tree is a copy of the original tree.

Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a 
reference to a node in the cloned tree.

Constraints:

The number of nodes in the tree is in the range [1, 104].
The values of the nodes of the tree are unique.
target node is a node from the original tree and is not null.
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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        } else if (original.val == target.val) {
            return cloned;
        } else {
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            if (left != null && left.val == target.val) {
                return left;
            } else {
                return getTargetCopy(original.right, cloned.right, target);
            }
        }
    }
}