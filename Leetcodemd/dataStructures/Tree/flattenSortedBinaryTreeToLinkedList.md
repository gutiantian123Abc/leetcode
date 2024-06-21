## Problem Description
```
/* Flatten Binary Tree to Linked List 
Flatten a binary tree to a fake "linked list" in pre-order traversal.
Here we use the right pointer in TreeNode as the next pointer in ListNode.
Example
              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6
Challenge 
Do it in-place without any extra memory.
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
## Solution
```java

public class Solution {
     
    private TreeNode lastNode = null; // 非常重要的 update private Node 的 recursion 思想！！！！ 
    public void flatten(TreeNode root) { //Related: Convert sorted LinkedList to BST
        // write your code here
        if(root == null) {
            return;
        }
        
        if(lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }
        
        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}
