/* 234. Palindrome Linked List
https://leetcode.com/problems/palindrome-linked-list/

Given the head of a singly linked list, return true if it is a palindrome.


Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = mid(head);
        ListNode end = reverse(mid);
        while(head != null && end != null) {
            if(head.val != end.val) {
                return false;
            }
            head = head.next;
            end = end.next;
        }
        
        return true;
        
    }
    
    private ListNode mid(ListNode head) {
        ListNode s = head, f = head;
        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        
        return s;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
    
    
}









