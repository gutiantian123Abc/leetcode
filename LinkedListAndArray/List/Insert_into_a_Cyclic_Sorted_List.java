/*
Insert into a Cyclic Sorted List
Given a node from a cyclic linked list which has been sorted, 
write a function to insert a value into the list such that it remains a cyclic sorted list. 
The given node can be any single node in the list. Return the inserted new node.
Notice
3->5->1 is a cyclic list, so 3 is next node of 1.
3->5->1 is same with 5->1->3


Example
Given a list, and insert a value 4:
3->5->1
Return 5->1->3->4
*/

/*
解题要义：
本题要意在于sorted:
分两种情况：1. 3->5： 顺序， 只有当  3<=x<=5 才插入
          2. 5->1： 逆序， 只有当  x >= 5 才插入
*/

          /**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        ListNode newNode = new ListNode(x);
        if(node == null) {
            newNode.next = newNode;
            return newNode;
        }
        
        ListNode p = node;

        do{												//do while loop 是解决cyclic list 很好的办法！
            if(p.val <= p.next.val) {
                if(x >= p.val && x <= p.next.val) {
                    break;
                }
            }else{
                if(x >= p.val) {
                    break;
                }
            }
            p = p.next;
        }while(p != node);
        
        newNode.next = p.next;
        p.next = newNode;
        
        return newNode;
    }
}