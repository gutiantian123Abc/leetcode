<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Convert Binary Search Tree to Doubly Linked List
Convert a binary search tree to doubly linked list with in-order traversal.
Example
Given a binary search tree:

    4
   / \
  2   5
 / \
1   3
return 1<->2<->3<->4<->5
*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public class ResultType {
        public DoublyListNode first;
        public DoublyListNode last;
        
        public ResultType(DoublyListNode first, DoublyListNode last) {
            this.first = first;
            this.last = last;
        }
    }
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if(root == null) {
            return null;
        }
        ResultType result = helper(root);
        return result.first;
    }
    
    private ResultType helper(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        ResultType result = new ResultType(null, null);
        DoublyListNode node = new DoublyListNode(root.val);
        
        if(left == null) {
            result.first = node;
        }else {
            result.first = left.first;
            left.last.next = node;
            node.prev = left.last;
        }
        
        if(right == null) {
            result.last = node;
        }else {
            node.next = right.first;
            right.first.prev = node;
            result.last = right.last;
        }
        
        return result;
    }
}</code></pre>
</div>
</div>
