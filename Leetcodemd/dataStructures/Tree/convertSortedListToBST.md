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
/* Convert Sorted List to Balanced BST
Given a singly linked list where elements are sorted in ascending order, 
convert it to a height balanced BST.

Have you met this question in a real interview? Yes
Example
               2
1->2->3  =>   / \
             1   3

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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//Solution1 (参考 convert sorted array to BST), 目前只会这一种方法）
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if(head == null) {
            return null;
        }
        
        int length = getLength(head);
        int[] A = new int[length];
        ListNode node = head;
        for(int i = 0; i < A.length; i++) {
            A[i] = node.val;
            node = node.next;
        }
        return buildTree(A, 0, length - 1);
    }
    
    private TreeNode buildTree(int[] A, int start, int end) {
        if(start > end) {
            return null;
        }
        
        TreeNode root = new TreeNode(A[(start + end) / 2]);
        TreeNode left = buildTree(A, start, (start + end) / 2 - 1);
        TreeNode right = buildTree(A, (start + end) / 2 + 1, end);
        root.left = left;
        root.right = right;
        return root;
        
    }
    
    private int getLength(ListNode head) {
        int size = 0;
        ListNode tmp = head;
        while(tmp != null) {
            tmp = tmp.next;
            size++;
        }
        return size;
    }
}






//Solution2: 目前不会， 待研究
public class Solution {
    private ListNode current;

    private int getListLength(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size;

        current = head;
        size = getListLength(head);

        return sortedListToBSTHelper(size);
    }

    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }
}</code></pre>
</div>
</div>
