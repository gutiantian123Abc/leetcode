/* Partition List
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater 
than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example
Given 1->4->3->2->5->2->null and x = 3,
return 1->2->2->4->3->5->null.
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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode LeftDummy = new ListNode(0);
        ListNode RightDummy = new ListNode(0);
        
        ListNode Left = LeftDummy; //注意Left 和 Dummy 的混搭使用
        ListNode Right = RightDummy;
        
        while(head != null) {
            if(head.val < x) {
                Left.next = head; //注意Left 和 Dummy 的混搭使用
                Left = Left.next; ////注意Node 的变换
            }else {
                Right.next = head;
                Right = Right.next;
            }
            head = head.next;
        }
        
        Right.next = null;
        Left.next = RightDummy.next;
        return LeftDummy.next;
    }
}
