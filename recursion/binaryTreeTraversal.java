/* Binary Tree Preorder Traversal
Given a binary tree, return the preorder traversal of its nodes' values.

Example
Given:

    1
   / \
  2   3
 / \
4   5
return [1,2,4,5,3].
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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        
        helper(result, root);
        return result;
    }
    
    private void helper(ArrayList<Integer> result, TreeNode root) {
        if(root == null) {
            return;
        }
        
        result.add(root.val);
        helper(result, root.left);
        helper(result, root.right);
    }
}


/* Binary Tree Postorder Traversal
Given a binary tree, return the postorder traversal of its nodes' values.
Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 

return [3,2,1].
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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        
        helper(result, root);
        return result;
    }
    
    private void helper(ArrayList<Integer> result, TreeNode root) {
        if(root == null) {
            return;
        }
        
        helper(result, root.left);
        helper(result, root.right);
        result.add(root.val);
    }
}



/* Binary Tree Inorder Traversal
Given a binary tree, return the inorder traversal of its nodes' values.

Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 

return [1,3,2].
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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        
        helper(result, root);
        return result;
    }
    
    private void helper(ArrayList<Integer> result, TreeNode root) {
        if(root == null) {
            return;
        }
        
        helper(result, root.left);
        result.add(root.val);
        helper(result, root.right);
    }
}













