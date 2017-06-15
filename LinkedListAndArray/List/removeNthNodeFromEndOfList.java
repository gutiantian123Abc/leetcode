/* Remove Nth Node From End of List
Given a linked list, remove the nth node from the end of list and return its head.

Example
Given linked list: 1->2->3->4->5->null, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5->null.
Challenge 
Can you do it without getting the length of the linked list?
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
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fakeHead = dummy;
        ListNode node = dummy;
        int count = 0;
        while(count < n + 1) {
            fakeHead = fakeHead.next;
            count++;
        }
        
        while(fakeHead != null) {
            fakeHead = fakeHead.next;
            node = node.next;
        }
        
        node.next = node.next.next;
        return dummy.next;
    }
}
