## Problem Description
```
/* Binary Tree Paths DQ mode (注意看 traverse mode)
Given a binary tree, return all root-to-leaf paths.

Example
Given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

[
  "1->2->5",
  "1->3"
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
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
## Solution
```java

public class Solution { //记住， DQ 方法一定是返回 Result!!!!!!!!!!!!
     
    private class ResultType {
        public List<String> paths;
        public ResultType(List<String> paths) {
            this.paths = paths;//记住， DQ 方法一定是返回 Result!!!!!!!!!!!!
        }
    } 
    
    public List<String> binaryTreePaths(TreeNode root) {
        // Divide Qonquer
        
        List<String> result = new ArrayList<String>();
        if(root == null) {
            return result;
        }
        
        ResultType answer = helper(root);
        return answer.paths;
    }
    
    private ResultType helper(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if(root.left == null && root.right == null) {
            paths.add(String.valueOf(root.val));
            return new ResultType(paths);
        }
        
        if(root.left != null) {
            ResultType left = helper(root.left);
            List<String> leftPaths = left.paths;
            for(String leftPath : leftPaths) {
                paths.add(String.valueOf(root.val) + "->" + leftPath);
            }
        }
        
        if(root.right != null) {
            ResultType right = helper(root.right);
            List<String> rightPaths = right.paths;
            for(String rightPath : rightPaths) {
                paths.add(String.valueOf(root.val) + "->" + rightPath);
            }
        }
        return new ResultType(paths);
    }
}