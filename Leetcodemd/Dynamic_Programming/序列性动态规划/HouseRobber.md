<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 1000px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* House Robber I
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses 
have security system connected and it will automatically contact the police if two adjacent houses
were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example
Given [3, 8, 4], return 8.

Challenge 
O(n) time and O(1) memory.
*/
    /*
     * @param : An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
/* House Robber II 
After robbing those houses on that street, 
the thief has found himself a new place for his thievery so that he will not get too much attention. 
This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. Meanwhile, 
the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

Notice
This is an extension of House Robber.
Example
nums = [3,6,4], return 6
*/
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
/* House Robber III
The thief has found himself a new place for his thievery again. 
There is only one entrance to this area, called the "root." 
Besides the root, each house has one and only one parent house. 
After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.
Example
  3
 / \
2   3
 \   \ 
  3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

    3
   / \
  4   5
 / \   \ 
1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
/* 典型的DFS divide conquer, 不是DP， 参见DFS
*/
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public long houseRobber(int[] A) {
        // write your code here
        if(A == null || A.length == 0) {
            return 0;
        }

        long[][] f = new long[2][2];
        
        int oldLine = 0, newLine = 0;
        
        //注意双线前倚式不需要考虑 i 从 0 还是 1 开始， 就算是要搞initialize, 也是顶多initilize f[oldLine][0], f[oldLine][1]啥的
        //需要考虑i 从0还是1开始的是老方法
        for(int i = 0; i < A.length; i++) {
            oldLine = newLine; //经典前倚式
            newLine = 1 - newLine;
            
            f[newLine][0] = Math.max(f[oldLine][0], f[oldLine][1]);//经典前倚式， 只更新 f[newLine][0],  f[newLine][1]
            f[newLine][1] = A[i] + f[oldLine][0];
        }
        
        return Math.max(f[newLine][0], f[newLine][1]);
    }
};




public class Solution {
    public int houseRobber2(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        int res = 0;
        //偷0号房， 不偷最后房子
        int[][] f = new int[2][2];
        int oldLine = 0, newLine = 0;
        
        //注意双线前倚式不需要考虑 i 从 0 还是 1 开始， 就算是要搞initialize, 也是顶多initilize f[oldLine][0], f[oldLine][1]啥的
        //需要考虑i 从0还是1开始的是老方法
        for(int i = 0; i < nums.length - 1; i++) {
            oldLine = newLine;
            newLine = 1 - newLine;
            
            f[newLine][0] = Math.max(f[oldLine][0], f[oldLine][1]);
            f[newLine][1] = nums[i] + f[oldLine][0];
        }
        
        
        res = Math.max(f[newLine][0], f[newLine][1]);
        
        //不偷0号房， 偷最后房子
        
        oldLine = 0;
        newLine = 0;
        f = new int[2][2];
        
        //注意双线前倚式不需要考虑 i 从 0 还是 1 开始， 就算是要搞initialize, 也是顶多initilize f[oldLine][0], f[oldLine][1]啥的
        //需要考虑i 从0还是1开始的是老方法
        for(int i = 1; i < nums.length; i++) {
            oldLine = newLine;
            newLine = 1 - newLine;
            
            f[newLine][0] = Math.max(f[oldLine][0], f[oldLine][1]);
            f[newLine][1] = nums[i] + f[oldLine][0];
        }
        
        
        res = Math.max(Math.max(f[newLine][0], f[newLine][1]), res);
        
        return res;
    }
}





public class Solution {
    public class ResultType {
        public int rob;
        public int notRob;
        
        public ResultType() {
            rob = 0;
            notRob = 0;
        }
    }
    
    
    public int houseRobber3(TreeNode root) {
        // write your code here
        ResultType ans = traverse(root);
        return Math.max(ans.rob, ans.notRob);
    }
    
    private ResultType traverse(TreeNode root) {
        ResultType ans = new ResultType();
        if(root == null) {
            return ans;
        }
        
        ResultType leftAns;
        ResultType rightAns;
        
        if(root.right == null && root.left == null) {
            ans.rob = root.val;
        }else if(root.right == null) { //root.left != null
            leftAns = traverse(root.left);
            ans.rob = root.val + leftAns.notRob;
            ans.notRob = Math.max(leftAns.rob, leftAns.notRob);
        }else if(root.left == null) {//root.right != null
            rightAns = traverse(root.right);
            ans.rob = root.val + rightAns.notRob;
            ans.notRob = Math.max(rightAns.rob, rightAns.notRob);
        }else {
            leftAns = traverse(root.left);
            rightAns = traverse(root.right);
            ans.rob = root.val + leftAns.notRob + rightAns.notRob;
            ans.notRob = Math.max(leftAns.rob, leftAns.notRob) + Math.max(rightAns.rob, rightAns.notRob);
        }
        
        return ans;
    }
}

</code></pre>
</div>
</div>
