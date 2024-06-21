<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 50%; margin: auto; padding: 20px; }
  .comment-block { max-width: 50%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Implement an iterator over a binary search tree (BST). 
Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory,
where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    /** @return whether we have a next smallest number */
    /** @return the next smallest number */
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


public class BSTIterator {
    Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<Integer>();
        helper(root);
    }
    
    private void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        
        helper(root.left);
        queue.offer(root.val);
        helper(root.right);
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public int next() {
        return queue.poll();
    }
}

</code></pre>
</div>
</div>
