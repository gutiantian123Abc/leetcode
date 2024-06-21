## Problem Description
```
/* Reverse Nodes in k-Group 
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.


Example
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    	/* 解题思路：
    	原本： head --> n1 -->  ....... nk --> nkPLus --> ....

    	变成： head --> nk -->  ....... n1 --> nkPlus --> ....

    	返回： n1 (注意： head 只是dummy node, 借用一下)
    	*/
## Solution
```java

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (head == null || k <= 1) {
            return head;
        }
        // Write your code here
        ListNode dummy = new ListNode(0); //经典的dummy运用
        dummy.next = head;
        ListNode tempHead = dummy;
        
        while(true) { // 很好的 while(true) {break;} 芡用
            tempHead = reverse(tempHead, k); //循环套用tempHead很好的例子
            if(tempHead == null) {
                break;
            }
        }
        
        return dummy.next;
    }
    
    
    private ListNode reverse(ListNode head, int k) {
        ListNode nk = head;
        for(int i = 0; i < k; i++) {
            if(nk == null) {
                return null;
            }
            nk = nk.next;
        }
        
        if(nk == null) {
            return null;
        }
        
        ListNode n1 = head.next;
        ListNode nkPlus = nk.next;
        
        //经典的回旋list模板
        
        ListNode prev = null;
        ListNode cur = n1;
        
        while(cur != nkPlus) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        //Connect
        head.next = nk;
        n1.next = nkPlus;
        return n1;
    }
}
