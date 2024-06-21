## Problem Description
```
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
## Solution
```java

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
}