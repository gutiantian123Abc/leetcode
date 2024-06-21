<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 600px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Reverse Linked List
Example
For linked list 1->2->3, the reversed linked list is 3->2->1

Challenge 
Reverse it in-place and in one-pass
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
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
/* Reverse Linked List II
Reverse a linked list from position m to n.

Notice
Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
Example
Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.

Challenge 
Reverse it in-place and in one-pass
*/
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null; // Dummy Node 应用
        while(head != null) { // Reverse Manipulation
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }
}


public class Solution {
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (m >= n || head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode, postnNode = mNode.next;
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;
        
        return dummy.next;
        
    }
}</code></pre>
</div>
</div>
