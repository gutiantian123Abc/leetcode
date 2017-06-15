/* Binary Tree Zigzag Level Order Traversal 
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
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
 */
 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return result;
        }
        
        boolean even = true; 
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); //BFS固定模板
        queue.offer(root);
        
        while(queue.size() != 0) {
            
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll();
                
                list.add(node.val);

                if(node.left != null) {
                    queue.offer(node.left);
                }
                
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            if(even == true) {
                result.add(new ArrayList<Integer>(list));
                even = false;
            }else {
                Collections.reverse(list);//注意使用
                result.add(new ArrayList<Integer>(list));//注意
                even = true;
            }
        }
        
        return result;
    }
}