<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 400px; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Insertion Sort List
Sort a linked list using insertion sort.

Example
Given 1->3->2->0->null, return 0->1->2->3->null.
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
     * @return: The head of linked list.
     */
/* Merge sort a list
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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
     */
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
     *             using constant space complexity.
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution { 
    public ListNode insertionSortList(ListNode head) {
    	// List edge case
    	if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        
        while(head != null) {
        	//注意巧妙利用dummy
            ListNode node = dummy;
            while(node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            //注意如何插入的
            ListNode tmp = head.next;
            head.next = node.next;
            node.next = head;
            head = tmp;
        }
        
        return dummy.next;
    }
}





public class Solution {
    public ListNode sortList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        //Split
        ListNode middle = get_middle(head);
        ListNode right = sortList(middle.next);
        middle.next = null;
        ListNode left = sortList(head);
        
        //Merge
        return mergeTwoSortedList(left, right);
    }
    
    private ListNode mergeTwoSortedList(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while(A != null && B != null) {
            if(A.val < B.val) {
                tail.next = A;
                A = A.next;
            }else {
                tail.next = B;
                B = B.next;
            }
            tail = tail.next;
        }
        
        if(A != null) { // Simpler!!
            tail.next = A;
        }
        
        if(B != null) {
            tail.next = B;
        }
        
        return dummy.next;
    }
    
    private ListNode get_middle(ListNode head) { // !!!!非常重要！！！！
        if(head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next, slow = head; // 固定模板
        while(fast != null && fast.next != null) {// 固定模板
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}


// Quick Sort a list
public class Solution {
     
    // Quick Sort
       class Pair {
        public ListNode left;
        public ListNode right;
        
        public Pair(ListNode left, ListNode right) {
            this.left = left;
            this.right = right;
        }
    }
    public ListNode sortList(ListNode head) {  
        if (head == null || head.next == null) {
            return head;
        }
        // write your code here
        ListNode mid = find_middle(head);
        Pair pair = partition(head, mid.val);
        ListNode left = sortList(pair.left);
        ListNode right = sortList(pair.right);
        
        ListNode left_tail = find_tail(left);
        left_tail.next = right;
        
        return left;
    }
    
    private ListNode find_tail(ListNode head) { 
        if(head == null) {
            return head;
        }
        
        while(head.next != null) { //注意这里 while(head.next != null)
            head = head.next;
        } 
        
        return head;

        
    }
    private ListNode find_middle(ListNode head) { //固定模板
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private Pair partition(ListNode head, int val) {
        ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
        ListNode equalDummy = new ListNode(0), equalTail = equalDummy;
        while(head != null) {
            if(head.val < val) {
                leftTail.next = head;
                leftTail = leftTail.next;
            }else if(head.val == val) {
                equalTail.next = head;
                equalTail = equalTail.next;
            }else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        
        leftTail.next = null; //注意这里， 因为leftTail 或 rightTail或equalTail 可能在任意一点终结， 后面还有
        rightTail.next = null;//很多点， 所以一定要保证每条后头都是null !!
        equalTail.next = null;
              
        if(leftDummy.next == null && rightDummy.next == null) {
            ListNode mid = find_middle(equalDummy.next);
            leftDummy.next = equalDummy.next;
            rightDummy.next = mid.next;
            mid.next = null; // 终结leftDummy 那一条
        }else if(leftDummy.next == null) {
            leftTail.next = equalDummy.next;
        }else {
            rightTail.next = equalDummy.next;
        }
        
        return new Pair(leftDummy.next, rightDummy.next);
    }
    
}

</code></pre>
</div>
</div>
