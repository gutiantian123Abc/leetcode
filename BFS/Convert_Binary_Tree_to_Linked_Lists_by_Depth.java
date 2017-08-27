/*Convert Binary Tree to Linked Lists by Depth

Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth 
(e.g., if you have a tree with depth D, you'll have D linked lists).

Example
Given binary tree:

    1
   / \
  2   3
 /
4
return

[
  1->null,
  2->3->null,
  4->null
]

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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> ans = new ArrayList<ListNode>();
        if(root == null) {
            return ans;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(queue.size() != 0) {
            int size = queue.size();
            TreeNode firstnode = queue.poll();
            ListNode listNode = new ListNode(firstnode.val);
            ListNode head = listNode;
            if(firstnode.left != null) {
                queue.offer(firstnode.left);
            }
            
            if(firstnode.right != null) {
                queue.offer(firstnode.right);
            }
            
            for(int i = 1; i < size; i++) {
                TreeNode node = queue.poll();
                listNode.next = new ListNode(node.val);
                listNode = listNode.next;
                if(node.left != null) {
                    queue.offer(node.left);
                }
                
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            ans.add(head);
        }
        
        return ans;
    }
}