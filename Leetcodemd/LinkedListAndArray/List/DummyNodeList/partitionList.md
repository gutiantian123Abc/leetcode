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
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
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
</code></pre>
</div>
</div>
