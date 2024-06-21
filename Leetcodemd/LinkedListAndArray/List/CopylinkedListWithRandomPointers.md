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
/*
A linked list is given such that each node contains 
an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode temp = head, dummy = head;
        
        while(temp != null) {
            RandomListNode newNode = new RandomListNode(temp.label);
            map.put(temp, newNode);
            temp = temp.next;
        }
        
        while(dummy != null) {
            RandomListNode newNode = map.get(dummy);
            RandomListNode oldNext = dummy.next;
            RandomListNode oldRPT = dummy.random;
            newNode.next = map.get(oldNext);
            newNode.random = map.get(oldRPT);
            dummy = dummy.next;
        }
        
        return map.get(head);
    }
}

</code></pre>
</div>
</div>
