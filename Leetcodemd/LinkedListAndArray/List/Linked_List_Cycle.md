<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 600px; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
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
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
public class Solution {
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
</code></pre>
</div>
</div>
