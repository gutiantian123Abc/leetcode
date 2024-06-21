## Problem Description
```
/* Populating Next Right Pointers in Each Node I
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree 
(ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/
    /**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
## Solution
```java



//本题是一道 根据已给Tree层级遍历的题目， 不需要BFS, 不需要额外空间， 很好, O(n), Space(1)
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        TreeLinkNode head = root;
        while(head != null) {
            TreeLinkNode pre = head;  
            if(pre.left != null) {
                pre.left.next = pre.right;
                if(pre.next != null) {
                    TreeLinkNode cur = pre.next;
                    while(cur != null) {   
                        pre.right.next = cur.left;
                        cur.left.next = cur.right;
                        pre = cur;
                        cur = cur.next;
                    }
                }
            }
            head = head.left;
        }
    }
}