<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* next permutation
Implement next permutation, which rearranges numbers into the lexicographically next greater
permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted
in ascending order).
The replacement must be in-place and use only constant extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the
right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
/*解题思路：
网上看来一个示例，觉得挺好的，也没必要另外找一个了。
6 5 4 8 7 5 1
一开始没看对方的后面介绍，就自己在想这个排列的下一个排列是怎样的。
首先肯定从后面开始看，1和5调换了没有用。
7、5和1调换了也没有效果，因此而发现了8、7、5、1是递减的。
如果想要找到下一个排列，找到递增的位置是关键。
因为在这里才可以使其增长得更大。
于是找到了4，显而易见4过了是5而不是8或者7更不是1。
因此就需要找出比4大但在这些大数里面最小的值，并将其两者调换。
那么整个排列就成了：6 5 5 8 7 4 1
然而最后一步将后面的8 7 4 1做一个递增。
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


class Solution {
    private void reverse(int[] nums, int start, int end) {
        int i = start, j = end;
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;      
        }    
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    
    public void nextPermutation(int[] nums) {
        int lastIncresingIndex = -1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i + 1] > nums[i]) {
                lastIncresingIndex = i;
                break;
            }
        }
        
        if(lastIncresingIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        int biggerIndex = 0;
        for(int i = nums.length - 1; i > lastIncresingIndex; i--) {
            if(nums[i] > nums[lastIncresingIndex]) {
                biggerIndex = i;
                break;
            }
        }
        
        swap(nums, lastIncresingIndex, biggerIndex);
        
        reverse(nums, lastIncresingIndex + 1, nums.length - 1);
    }
}

</code></pre>
</div>
</div>
