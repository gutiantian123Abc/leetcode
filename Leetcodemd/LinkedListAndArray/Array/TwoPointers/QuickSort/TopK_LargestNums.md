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
/* Top k Largest Numbers 
Given an integer array, find the top k largest numbers in it.

Example
Given [3,10,1000,-99,4,100] and k = 3.
Return [1000, 100, 10].

这里用quicksort 而 不用quickselect 的原因是 quicksort: nlogn, quickselect 尽管一次是n, 但要执行k次， 而k最坏可能是n, 所以最坏可能是n^2, 所以不用
*/
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int[] topk(int[] nums, int k) {
        // Write your code here
        quicksort(nums, 0, nums.length - 1);
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = nums[i];
        }
        
        return ans;
    }
    
    
    
    private void quicksort(int[] nums, int start, int end) {
        if(start >= end) { //记住， quicksort 这里一定是 start >= end; 对比quickselect: if(start == end) {return nums[start]}
            return;
        }
        
        int i = start, j = end;
        int pivot = nums[(start + end) / 2];
        while(i <= j) {
            while(i <= j && nums[i] > pivot) {
                i++;
            }
            
            while(i <= j && nums[j] < pivot) {
                j--;
            }
            
            if(i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        
        quicksort(nums, start, j);
        quicksort(nums, i, end);
    }
    
    private void swap(int[] nums, int a, int b) {
    	int tmp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = tmp;
    }
};
</code></pre>
</div>
</div>
