<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 700px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*Remove Linked List ElementsRemove all elements from a linked list of integers that have value val.ExampleGiven: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6Return: 1 --> 2 --> 3 --> 4 --> 5*//** * Definition for singly-linked list. * public class ListNode { *     int val; *     ListNode next; *     ListNode(int x) { val = x; } * } */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode pre = null;
        
        while(head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp; 
        }
        
        return pre;
    }
}</code></pre>
</div>
</div>
