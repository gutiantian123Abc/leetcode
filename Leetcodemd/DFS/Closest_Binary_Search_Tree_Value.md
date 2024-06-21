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
/* Closest Binary Search Tree Value I

/*Given a non-empty binary search tree and a target value, 
find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
class Solution {
    private class RT {
        double dis = 0;
        int val = 0;
        public RT(double dis, int val) {
            this.dis = dis;
            this.val = val;
        }
    }
    
    
    public int closestValue(TreeNode root, double target) {
        RT res = traverse(root, target);
        return res.val;
    }
    
    
    private RT traverse(TreeNode root, double target) {
        if(root.left == null && root.right == null) {//leaf
            return new RT(Math.abs(target - root.val), root.val);
        }
        
        if(target == root.val) {
            return new RT(0, root.val);
        }
        
        double curDis = Math.abs(target - root.val);
        int curVal = root.val;
        
        if(target > root.val) {
            if(root.right != null) {
                RT right = traverse(root.right, target);
                if(curDis < right.dis) {
                    return new RT(curDis, curVal);
                }else {
                    return new RT(right.dis, right.val);
                }
            }else {
                return new RT(curDis, curVal);
            }    
        }else {//target < root.val
            if(root.left != null) {
                RT left = traverse(root.left, target);
                if(curDis < left.dis) {
                    return new RT(curDis, curVal);
                }else {
                    return new RT(left.dis, left.val);
                }
            }else {
                return new RT(curDis, curVal);
            }            
        }
    }
}

</code></pre>
</div>
</div>
