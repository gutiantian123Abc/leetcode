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
/* Median
Given a unsorted array with integers, find the
median of it.
A median is the middle number of the array after
it is sorted.
If there are even numbers in the array, return the
N/2-th number after sorted.
Example
Given [4, 5, 1, 2, 3], return 3.
Given [7, 9, 4, 5], return 5.
Challenge
O(n) time.
*/
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle
number of the array.
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//Quick Select : Complexity O(n)!!! 包含重复情况
//经典模板！！！！！
//记住， Median是 (len / 2) + 1 Smallest number, 不是largest number
//这里也可以用PriorityQueue 做， (O(n). S(k)), Top K smallest numbers

public class Solution {
    public int median(int[] nums) {
        // write your code here
        int len = nums.length;
        int k = (len + 1) / 2;
        return quickSelectTopKSmallest(nums, 0, len - 1, k);
    }
    
    private int quickSelectTopKSmallest(int[] nums, int start, int end, int k) {
        if(start == end) {
            return nums[start];
        }
        
        int i = start, j = end;
        int pivot = nums[start + (end - start) / 2];
        
        while(i <= j) {
            while(i <= j && nums[i] < pivot) {
                i++;
            }
            
            while(i <= j && nums[j] > pivot) {
                j--;
            }
            
            if(i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        
        
        if(start + k - 1 <= j) {
            return quickSelectTopKSmallest(nums, start, j, k);
        }
        
        if(start + k - 1 >= i) {
            return quickSelectTopKSmallest(nums, i, end, k - (i - start));
        }
        
        return nums[j + 1];
    }
    
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}</code></pre>
</div>
</div>
