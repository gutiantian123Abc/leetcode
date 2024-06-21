<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container {{ max-width: 100%; margin: 0 auto; padding: 10px; }}
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Search in Rotated Sorted Array I*/
/*
Suppose an array sorted in ascending order is rotated at 
some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, 
otherwise return -1.

You may assume no duplicate exists in the array.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//大忌： 二分法只能用在 1. sorted + (duplicates) array 或者 2. rotated sorted non-duplicates array!
//      决不能用在duplicated rotated sorted array(那样的话只能用一遍遍历O(n))

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(target == nums[mid]) {
                return mid;
            }

            if(nums[mid] >= nums[start]) {
                if(nums[start] <= target && target < nums[mid]) {
                    end = mid;
                }else {
                    start = mid;
                }
            }else {
                if(nums[mid] < target && target <= nums[end]) {
                    start = mid;
                }else {
                    end = mid;
                }
            }
            
        }
        
        if(nums[start] == target) {
            return start;
        }
        
        if(nums[end] == target) {
            return end;
        }
        
        return -1;   
    }
}</code></pre>
</div>
</div>
