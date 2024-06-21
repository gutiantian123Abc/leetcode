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
/* 307. Range Sum Query - Mutable
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
*/
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
//SegmentTree Knowledge: https://leetcode.com/problems/range-sum-query-mutable/solution/

class NumArray {
    class SegmentTreeNode {
        int start, end, sum;
        SegmentTreeNode left, right;
        
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }
    
    public SegmentTreeNode root = null;
    
    private SegmentTreeNode buildTree(int start, int end, int[] nums) { //O(n), S(n)
        if(start > end) {
            return null;
        }else {
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            if(start == end) {
                node.sum = nums[start];
            }else {
                int mid = start + (end - start) / 2;
                node.left = buildTree(start, mid, nums);//等于mid时放在左边
                node.right = buildTree(mid + 1, end, nums);
                node.sum = node.left.sum + node.right.sum;
            }
            return node;
        }  
    }

    public NumArray(int[] nums) {
        root = buildTree(0, nums.length - 1, nums);
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    private void update(SegmentTreeNode node, int pos, int val) {//O(log(n)) S(1)
        if(node.start == node.end) {
            node.sum = val;
        }else {
            int mid = node.start + (node.end - node.start) / 2;
            if(pos <= mid) {//等于mid时放在左边
                update(node.left, pos, val);
            }else {
                update(node.right, pos, val);
            }
            node.sum = node.left.sum + node.right.sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private int sumRange(SegmentTreeNode node, int start, int end) {//O(log(n)) S(1)
        if(node.start == start && node.end == end) {
            return node.sum;
        }else {
            int mid = node.start + (node.end - node.start) / 2;
            if(end <= mid) {
                return sumRange(node.left, start, end);
            }else if(start >= mid + 1) { //等于mid 在左边
                return sumRange(node.right, start, end);
            }else {
                return sumRange(node.left, start, mid) + sumRange(node.right, mid + 1, end);
            }  
        }
    }
}




</code></pre>
</div>
</div>
