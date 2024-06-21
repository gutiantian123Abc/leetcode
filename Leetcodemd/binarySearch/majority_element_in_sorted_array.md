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
/* 1150. Check If a Number Is Majority Element in a Sorted Array
https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/

Given an integer array nums sorted in non-decreasing order and an integer target, 
return true if target is a majority element, or false otherwise.

A majority element in an array nums is an element that appears more than nums.length / 2 times in the array.

 
Example 1:

Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
Output: true
Explanation: The value 5 appears 5 times and the length of the array is 9.
Thus, 5 is a majority element because 5 > 9/2 is true.
Example 2:

Input: nums = [10,100,101,101], target = 101
Output: false
Explanation: The value 101 appears 2 times and the length of the array is 4.
Thus, 101 is not a majority element because 2 > 4/2 is false.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int N = nums.length, start = 0, end = nums.length - 1;
        int firstIndex = -1, lastIndex = N;
        // Find first index
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] >= target) {
                end = mid;
            }else {
                start = mid;
            }
        }
        
        if(nums[start] == target) {
            firstIndex = start;
        }else if(nums[end] == target) {
            firstIndex = end;
        }else {
            return false;
        }
        
        
        
        // Find last index
        start = 0;
        end = N - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] <= target) {
                start = mid;
            }else {
                end = mid;
            }
        }
        
        if(nums[end] == target) {
            lastIndex = end;
        } else if(nums[start] == target) {
            lastIndex = start;
        }        
        
        
        return (lastIndex - firstIndex + 1) > N/2;
        
    }
}</code></pre>
</div>
</div>
