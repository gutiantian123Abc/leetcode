/* Populating Next Right Pointers in Each Node II
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution 
still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

*/

    /**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

    //本题是一道 根据已给Tree层级遍历的题目， 不需要BFS, 不需要额外空间， 很好!!!O(n), Space(1)
public class Solution {
    private class entry {
        public TreeLinkNode parentNext;
        public TreeLinkNode childNext;
        public entry() {
            this.parentNext = null;
            this.childNext = null;
        }        
        public entry(TreeLinkNode parentNext, TreeLinkNode childNext) {
            this.parentNext = parentNext;
            this.childNext = childNext;
        }
    }
    
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        TreeLinkNode head = root;
        while(head != null) {
            TreeLinkNode levelHead = head;
            
            while(levelHead != null) {
                entry nextEntry = getNext(levelHead);
                TreeLinkNode childNext = nextEntry.childNext;
                TreeLinkNode parentNext = nextEntry.parentNext;
                if(levelHead.left != null && levelHead.right != null) {
                    levelHead.left.next = levelHead.right;
                    levelHead.right.next = childNext;
                }else if(levelHead.left != null && levelHead.right == null) {
                    levelHead.left.next = childNext;
                }else if(levelHead.left == null && levelHead.right != null) {
                    levelHead.right.next = childNext;
                }
                levelHead = parentNext;
            }
            
            head = getChildHead(head);
        }   
    }
    
    private TreeLinkNode getChildHead(TreeLinkNode head) {
        while(head != null) {
            if(head.left != null) {
                return head.left;
            }
            
            if(head.right != null) {
                return head.right;
            }
            
            head = head.next;
        }
        
        return head;
    }
    
    private entry getNext(TreeLinkNode root) {
        entry ans = new entry();
        TreeLinkNode next = root.next;
        while(next != null) {
            if(next.left != null) {
                ans.parentNext = next;
                ans.childNext = next.left;
                return ans;
            }
            
            if(next.right != null) {
                ans.parentNext = next;
                ans.childNext = next.right;
                return ans;
            }
            next = next.next;
        }

        return ans;
    }
}