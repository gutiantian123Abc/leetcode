<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 400px; margin: 50px; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 50px; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Sort Colors I
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Example
Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].
*/
/*
经典题型； Rainbow Sort， 其中套用了分区PartitionArray模板
O(nlogk, k 是数值最大跨度), no extra memory!!!
*/
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
/* Sort Colors II
Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, 
with the colors in the order 1, 2, ... k.

Notice
You are not suppose to use the library's sort function for this problem.
k <= n
Example
Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].

Challenge 
A rather straight forward solution is a two-pass algorithm using counting sort. 
That will cost O(k) extra memory. Can you do it without using extra memory?


Same thing !!!
O(nlogk, k 是数值最大跨度), no extra memory!!!
*/
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


class Solution {
    public void sortColors(int[] nums) {
        // write your code here
        rainbowSort(nums, 0, nums.length - 1, 0, 2);
    }
    
    private void rainbowSort(int[] nums, int start, int end, int from, int to) {
        if(from == to) {
            return;
        }
        
        if(start >= end) {
            return;
        }
        
        int i = start, j = end;
        int mid = (from + to) / 2;
        
        while(i <= j) {
            while(i <= j && nums[i] <= mid) {
                i++;
            }
            
            while(i <= j && nums[j] > mid) {
                j--;
            }
            
            if(i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        
        
        rainbowSort(nums, start, j, from, mid);
        rainbowSort(nums, i, end, mid + 1, to);

    }
    
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}


class Solution {
    public void sortColors2(int[] colors, int k) {
        // write your code here
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }
    
    private void rainbowSort(int[] nums, int start, int end, int from, int to) {
        if(from == to) {
            return;
        }
        
        if(start >= end) {
            return;
        }
        
        int i = start, j = end;
        int mid = (from + to) / 2;
        
        while(i <= j) {
            while(i <= j && nums[i] <= mid) {
                i++;
            }
            
            while(i <= j && nums[j] > mid) {
                j--;
            }
            
            if(i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        
        
        rainbowSort(nums, start, j, from, mid);
        rainbowSort(nums, i, end, mid + 1, to);

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
