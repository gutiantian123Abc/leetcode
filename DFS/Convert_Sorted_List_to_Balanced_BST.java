/*Convert Sorted List to Balanced BST 
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
Example:
               2
1->2->3  =>   / \
             1   3
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if(head == null) {
            return null;
        }
        
        int length = getLength(head);
        int[] A = new int[length];
        ListNode node = head;
        for(int i = 0; i < A.length; i++) {
            A[i] = node.val;
            node = node.next;
        }
        return buildTree(A, 0, length - 1);
    }
    
    private TreeNode buildTree(int[] A, int start, int end) {
        if(start > end) {
            return null;
        }
        
        TreeNode root = new TreeNode(A[(start + end) / 2]);
        TreeNode left = buildTree(A, start, (start + end) / 2 - 1);
        TreeNode right = buildTree(A, (start + end) / 2 + 1, end);
        root.left = left;
        root.right = right;
        return root;
        
    }
    
    
    
    private int getLength(ListNode head) {
        int size = 0;
        ListNode tmp = head;
        while(tmp != null) {
            tmp = tmp.next;
            size++;
        }
        return size;
    }
}