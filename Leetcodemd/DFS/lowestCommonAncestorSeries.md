<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 200px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*  Lowest Common Ancestor I
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7
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
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
/* Lowest Common Ancestor III
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Return null if LCA does not exist.

Notice
node A or node B may not exist in tree.

Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7
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
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution { 
    public class ResultType {
        public TreeNode LCA;
        public ResultType (TreeNode LCA) {
            this.LCA = LCA;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType result = divideConquer(root, A, B);
        return result.LCA;
    }
     // 规律： Divide Qonquer 一般原来有几个parameters， helper 里面就有原样的几个params, 因为divide qonquer 的本质就是
   //         把一个大问题分解成几个小问题来解决
    private ResultType divideConquer(TreeNode root, TreeNode A, TreeNode B) {
        if(root == null || root == A || root == B) {
            return new ResultType(root);
        }
        
        ResultType left = divideConquer(root.left, A, B);
        ResultType right = divideConquer(root.right, A, B);
        
        if(left.LCA != null && right.LCA != null) {
            return new ResultType(root);
        }
        
        if(left.LCA != null) {
            return left;
        }
        
        if(right.LCA != null) {
            return right;
        }
        
        return new ResultType(null);
    }
}



public class Solution {
    private class ResultType {
        public TreeNode LCA;
        public boolean containsA;
        public boolean containsB;
        public ResultType(TreeNode LCA, boolean containsA, boolean containsB) {
            this.LCA = LCA;
            this.containsA = containsA;
            this.containsB = containsB;
        }
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType res = helper(root, A, B);
        if(res.containsA == true && res.containsB == true) {
            return res.LCA;
        }
        
        return null;
    }
    
    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if(root == null) {
            return new ResultType(null, false, false);
        }
        
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        
        boolean containsA = left.containsA || right.containsA || root == A;  // Learn this common factor result type
        boolean containsB = left.containsB || right.containsB || root == B;
        
        if(root == A || root == B) {
            return new ResultType(root, containsA, containsB);
        }
        
        if(left.LCA != null && right.LCA != null) {
            return new ResultType(root, containsA, containsB);
        }
        if(left.LCA != null) {
            return new ResultType(left.LCA, containsA, containsB);
        }
        if(right.LCA != null) {
            return new ResultType(right.LCA, containsA, containsB);
        }
        
        return new ResultType(null, containsA, containsB);
    }
}
</code></pre>
</div>
</div>
