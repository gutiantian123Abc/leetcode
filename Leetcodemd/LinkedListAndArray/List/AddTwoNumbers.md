<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Add Two Numbers I
You have two numbers represented by a linked list, where each node contains a single digit. 
The digits are stored in reverse order, such that the 1's digit is at the head of the list. 
Write a function that adds the two numbers and returns the sum as a linked list.

Example
Given 7->1->6 + 5->9->2. That is, 617 + 295.

Return 2->1->9. That is 912.

Given 3->1->5 and 5->9->2, return 8->0->8.
*/
/**
 * Definition for singly-linked list.
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
/* Similar Question: Add Binary
Given two binary strings, return their sum (also a binary string).

Example
a = 11
b = 1
Return 100
*/
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        int carry = 0, sum = 0;
        ListNode prev = new ListNode(0);
        ListNode node = prev;
        while(l1 != null && l2 != null) {
            sum = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            node.next = new ListNode(sum);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            sum = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            node.next = new ListNode(sum);
            node = node.next;
            l1 = l1.next;
        }
        
        while(l2 != null) {
            sum = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            node.next = new ListNode(sum);
            node = node.next;
            l2 = l2.next;
        }

      
        if(carry != 0) {
            node.next = new ListNode(carry);
        }
        
        return prev.next;
    }
}


public class Solution {
    public String addBinary(String a, String b) {
        // Write your code here
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        String ans = "";
        while(i >= 0 && j >= 0) { //注意这里如何实现char to int 的
            int sum = carry + (int)(a.charAt(i) - '0') + (int)(b.charAt(j) - '0');
            carry = sum / 2;
            ans = String.valueOf(sum%2) + ans;
            i--;
            j--;
        }
        
        while(i >= 0) {
            int sum = carry + (int)(a.charAt(i) - '0');
            carry = sum / 2;
            ans = String.valueOf(sum%2) + ans;
            i--;
        }
        
        while(j >= 0) {
            int sum = carry + (int)(b.charAt(j) - '0');
            carry = sum / 2;
            ans = String.valueOf(sum%2) + ans;
            j--;
        }  
        
        if(carry == 1) {
            ans = "1" + ans;
        }
            
        return ans;
    }
}


</code></pre>
</div>
</div>
