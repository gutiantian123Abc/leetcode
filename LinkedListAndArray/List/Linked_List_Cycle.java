/* Linked List Cycle
Given a linked list, determine if it has a cycle in it.
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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
        if(head == null || head.next == null) {
            return false;
        } 
        
        ListNode slow = head;
        ListNode fast = slow.next;
        
        while(fast != null && fast.next != null ) {
            if(fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return false;
        
    }
}
