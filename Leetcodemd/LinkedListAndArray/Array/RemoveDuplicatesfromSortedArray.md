<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 50px auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*Given a sorted array, remove the duplicates in place such that each element appear only once 
and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
*/
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
/* Remove Duplicates from Sorted Array II
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int size = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == nums[size]) {
                continue;
            }else{
                size++;
                nums[size] = nums[i];
            }
        }
        return size + 1;
    }
}


class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        
        if(nums.length == 1) {
            return 1;
        }
        
        int size = 0, count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[size]) {
                if(count < 2) {
                    size++;
                    nums[size] = nums[i];
                    count++;
                }
            }else {
                size++;
                nums[size] = nums[i];
                count = 1;
            }
        }
        
        return size + 1;
    }
}</code></pre>
</div>
</div>
