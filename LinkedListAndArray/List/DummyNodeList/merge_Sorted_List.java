/* Merge Two Sorted Lists
Merge two sorted (ascending) linked lists and return it as a new sorted list. 
The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.

Example
Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
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
 */ 
public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here

        ListNode Dummy = new ListNode(0); //注意Node 和 Dummy 的混搭使用
        ListNode Node = Dummy;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                Node.next = l1; //注意Node 和 Dummy 的混搭使用
                Node = Node.next; //注意Node 的变换
                l1 = l1.next;
            }else {
                Node.next = l2;
                Node = Node.next;
                l2 = l2.next;
            }
        }
        
        if(l1 != null) {
            Node.next = l1;
        }
        
        if(l2 != null) {
            Node.next = l2;
        }
        
        return Dummy.next;
    }
}