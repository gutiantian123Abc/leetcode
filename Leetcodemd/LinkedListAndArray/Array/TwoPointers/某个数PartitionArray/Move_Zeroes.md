<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Move Ks  不理解， 待解决！！！！！！！！
Given an array nums, write a function to move all k's to the end of it while maintaining the relative order of the non-zero elements.

Notice

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Example
Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
*/
/* 解题思路： 
经典模板： 把某个数移到Array的一端， in place, no extra space
较难理解，好好理解！！！
*/
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>



public class Solution {
    public void moveZeroes(int[] nums, int k) {
        // Write your code here
        int left = 0, right = 0; //解题关键： right 是下一个不是k的位置，left 是下一个是k的位置， 它俩互换
        
        while(right < nums.length) {
            if(nums[right] != k) {
                if(nums[left] == k) {
                    swap(nums, left, right);  
                }
                
                left++;
                right++;             
            }else {
                right++;
            }
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}</code></pre>
</div>
</div>
