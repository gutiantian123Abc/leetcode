<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Partition Array I
Given an array nums of integers and an int k, partition the array 
(i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

Notice
You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
If all elements in nums are smaller than k, then return nums.length

Example
If nums = [3,2,2,1] and k=2, a valid answer is 1.

Challenge 
Can you partition the array in-place and in O(n)?
中间爱咋排序咋哦排序 (in place)
*/
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
/* Partition Array II 
Partition an unsorted integer array into three parts:

The front part < low
The middle part >= low & <= high
The tail part > high
Return any of the possible solutions.
Example
Given [4,3,4,1,2,3,1,2], and low = 2 and high = 3.

Change to [1,1,2,3,2,3,4,4].

([1,1,2,2,3,3,4,4] is also a correct answer, but [1,2,1,2,3,3,4,4] is not)
中间爱咋排序咋哦排序 (in place)!!
*/
/*
解题思路： 经典的分区式分割排序， 跟上体思路一致， 只是在每个loop之后right 重置到 nums.length - 1
*/
    /**
     * @param nums an integer array
     * @param low an integer
     * @param high an integer
     * @return nothing
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    int left = 0, right = nums.length - 1;
	    while(left <= right) {  // 记住， 这里是 <= 而非 twp pointers 例如 two sum 的 while(start < end)
	        while(left <= right && nums[left] < k) {
	            left++;
	        }
	        
	        while(left <= right && nums[right] >= k) {
	            right--;
	        }
	        
	        if(left <= right) {
	            swap(nums, left, right);
	            left++;
	            right--;
	        }
	    }
	    return left;

    }
    
	   private void swap(int[] nums, int left, int right) {
	       int tmp = nums[left];
	       nums[left] = nums[right];
	       nums[right] = tmp;
	   } 
}







public class Solution { 
    public void partition2(int[] nums, int low, int high) {
        // Write your code here
        int left = 0, right = nums.length - 1;

        // 首先把区间分为 < low 和 >= low 的两个部分 
        while(left <= right) {
            while(left <= right && nums[left] < low) {
                left++;
            }
            
            while(left <= right && nums[right] >= low) {
                right--;
            }
            
            if(left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        // 然后从 >= low 的部分里分出 <= high 和 > high 的两个部分
        right = nums.length - 1;
        while(left <= right) {
            while(left <= right && nums[left] <= high) {
                left++;
            }
            
            while(left <= right && nums[right] > high) {
                right--;
            }
            
            if(left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }
        
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}



</code></pre>
</div>
</div>
