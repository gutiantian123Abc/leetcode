<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 
https://leetcode.com/problems/add-two-numbers

2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
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
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode l4 = l3;
        int carry = 0;
        int len = 0;

        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int digit = sum % 10;
            l3.val = digit;
            l3.next = new ListNode();
            l3 = l3.next;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            len++;
        }


        while(l1 != null) {
            int sum = l1.val + carry;
            int digit = sum % 10;
            l3.val = digit;
            l3.next = new ListNode();
            l3 = l3.next;
            carry = sum / 10;
            l1 = l1.next;
            len++;
        }

        while(l2 != null) {
            int sum = l2.val + carry;
            int digit = sum % 10;
            l3.val = digit;
            l3.next = new ListNode();
            l3 = l3.next;
            carry = sum / 10;
            l2 = l2.next;
            len++;
        } 

        if(carry != 0) {
            l3.val = carry;
        }

        if(len >= 1) {
            ListNode l5 = l4;
            for(int i = 0; i < len - 1; i++) {
                l5 = l5.next;
            }
            if(l5.next.val == 0) {
                l5.next = null;
            }
        }

        return l4;
    }
}</code></pre>
</div>
</div>
