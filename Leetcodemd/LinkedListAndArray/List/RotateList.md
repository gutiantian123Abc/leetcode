<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Rotate List
Given a list, rotate the list to the right by k places, where k is non-negative.
Example
Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.
*/
/*
  Definition for singly-linked list.
*/
	/**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
/* 变形 Reverse Linked List I

Example
For linked list 1->2->3, the reversed linked list is 3->2->1
*/
/**
 * Definition for ListNode.
 */
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
/* 拓展  Reverse Linked List II

Reverse a linked list from position m to n.
Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.

Example
Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.

Challenge 
Reverse it in-place and in one-pass
*/
/**
 * Definition for ListNode
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


  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {

    	// List questions edge case
        if (head == null || head.next == null) return head;
        
        int length = getLength(head);
        k %= length;

        //巧妙运用个dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //巧妙运用fast, slow pointers
        ListNode fast = head, slow = head;
        for(int i = 0; i < k; i++) {
            fast = fast.next;
        }
        
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        //巧妙运用个dummy node得到需要的东西和任务
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;

    }
    
    private int getLength(ListNode head) {
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}





public class ListNode {
     int val;
     ListNode next;
      ListNode(int val) {
         this.val = val;
         this.next = null;
     }
}
 
public class Solution {
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        
        while(head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        
        return prev;
    }
}



public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class Solution {
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for(int i = 1; i < m; i++) {
            head = head.next;
        }
        
        ListNode prevNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postNode = nNode.next;
        
        //Reverse Linked List I
        for(int i = m; i < n; i++) {
            ListNode tmp = postNode.next;
            postNode.next = nNode;
            nNode = postNode;
            postNode = tmp;
        }
        
        prevNode.next = nNode;
        mNode.next = postNode;
        
        return dummy.next;
    }
}





</code></pre>
</div>
</div>
