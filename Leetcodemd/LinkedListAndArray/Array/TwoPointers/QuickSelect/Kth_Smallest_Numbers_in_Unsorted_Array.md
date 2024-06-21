<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 50%; margin: auto; padding: 20px; }
  .comment-block { max-width: 50%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Find the kth smallest numbers in an unsorted integer array.
Example
Given [3, 4, 1, 2, 5], k = 3, the 3rd smallest numbers are [1, 2, 3].
Complexity O(n)!!!
*/
    /*
     * @param k an integer
     * @param nums an integer array
     * @return kth smallest element
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
//经典模板！！！！！
class Solution {
    public int kthSmallest(int k, int[] nums) {
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
            while(i <= j && nums[i] < pivot) {
                i++;
            }
            
            //必须是：nums[j] > pivot， 不能是 nums[j] >= pivot, 对比分区划分Partition Array！！！这里与分区或分数划分不同的原因在于我们最后可以乘return nums[j + 1]的便利
            while(i <= j && nums[j] > pivot) {
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
