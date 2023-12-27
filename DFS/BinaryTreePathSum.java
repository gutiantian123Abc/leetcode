/* Binary Tree Path Sum

Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.
A valid path is from root node to any of the leaf nodes.
Have you met this question in a real interview? Yes
Example
Given a binary tree, and target = 5:

     1
    / \
   2   4
  / \
 2   3
return

[
  [1, 2, 2],
  [1, 4]
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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        
        List<Integer> path = new ArrayList<Integer>();
        path.add(root.val);//注意这里的先加， 因为不可能有空集的情况！！！！！
        DFS(result, path, root, root.val, target);
        return  result;
    }
    
    private void DFS(List<List<Integer>> result, List<Integer> path, TreeNode root, int sum, int target) {
        if(root.left == null && root.right == null) {
            if(sum == target) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
              
        if(root.left != null) {
            path.add(root.left.val);//注意这里的先加， 因为不可能有空集的情况！！！！！
            DFS(result, path, root.left, sum + root.left.val, target);
            path.remove(path.size() - 1);
        }
        
        if(root.right != null) {
            path.add(root.right.val);
            DFS(result, path, root.right, sum + root.right.val, target);
            path.remove(path.size() - 1);
        }
    }
}