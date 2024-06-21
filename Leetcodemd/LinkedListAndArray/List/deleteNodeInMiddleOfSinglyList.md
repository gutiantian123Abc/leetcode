<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 80%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Delete Node in the Middle of Singly Linked List
Implement an algorithm to delete a node in the middle of a singly linked list, //注意是middle
given only access to that node.
Example
Given 1->2->3->4, and node 3. return 1->2->4
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
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public void deleteNode(ListNode node) {
        // write your code here
        if(node == null || node.next == null) {
            return;
        }
        
        int value = node.next.val;
        node.val = value;
        node.next = node.next.next;
    }
}</code></pre>
</div>
</div>
