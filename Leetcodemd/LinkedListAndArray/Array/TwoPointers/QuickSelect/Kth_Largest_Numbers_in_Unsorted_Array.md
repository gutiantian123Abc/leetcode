<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 700px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Kth Largest ElementExampleIn array [9,3,2,4,8], the 3rd largest element is 4.In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is3 and etc.ChallengeO(n) time, O(1) extra memory.*/    /*     * @param k : description of k     * @param nums : array of nums     * @return: description of return     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    private int quickSelect(int[] nums, int start, int end, int k) {
        if(start == end) {
            return nums[start];
        }
        
        int i = start, j = end;
        int pivot = nums[start + (end - start) / 2];
        while(i <= j) {
        	//必须是：nums[i] < pivot， 不能是 nums[i] <= pivot, 对比分区划分Partition Array！！！这里与分区或分数划分不同的原因在于我们最后可以乘return nums[j + 1]的便利
            while(i <= j && nums[i] > pivot) {
                i++;
            }
            
            //必须是：nums[j] > pivot， 不能是 nums[j] >= pivot, 对比分区划分Partition Array！！！这里与分区或分数划分不同的原因在于我们最后可以乘return nums[j + 1]的便利
            while(i <= j && nums[j] < pivot) {
                j--;
            }
            
            if(i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        
        //最终的结果：   start ****************** j (0 或 1 个数) i ********************** end

        //注意 k - 1 是 offset
        if(start + k - 1 <= j) {
            return quickSelect(nums, start, j, k);
        }
        
        if(start + k - 1 >= i) {
            return quickSelect(nums, i, end, k - (i - start));
        }
        
        return nums[j + 1];//此种情况代表 j 和 i 之间存在一个数， 因此选它
    }
    


    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
};</code></pre>
</div>
</div>
