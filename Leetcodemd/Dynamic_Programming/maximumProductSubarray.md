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
/* Maximum Product Subarray
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
Example
For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
*/
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//Space: O(n), Time: O(n)
public class Solution {
    public int maxProduct(int[] nums) {
        // write your code here
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int res = nums[0];
        
        max[0] = min[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            max[i] = min[i] = nums[i];
            if(nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);//也防止max[i - 1] == 0, 有可能就是max[i]自己
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);//也防止min[i - 1] == 0, 有可能就是min[i]自己
            }else if(nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);//也防止max[i - 1] == 0, 有可能就是max[i]自己
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);//也防止min[i - 1] == 0, 有可能就是min[i]自己
            }
            
            res = Math.max(res, max[i]);
        }
        
        return res;
    }
}





//Space: O(1), Time: O(n)
public class Solution {
    public int maxProduct(int[] nums) {
        // write your code here
        int maxPre = nums[0];
        int minPre = nums[0];
        int maxCurrent = 0;
        int minCurrent = 0;
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxCurrent = minCurrent = nums[i];//对付nums[i] == 0的情况
            if(nums[i] > 0) {
                maxCurrent = Math.max(maxCurrent, maxPre * nums[i]);//也防止maxPre == 0, 有可能就是maxCurrent自己
                minCurrent = Math.min(minCurrent, minPre * nums[i]);//也防止minPre == 0, 有可能就是minCurrent自己
            }else if(nums[i] < 0) {
                maxCurrent = Math.max(maxCurrent, minPre * nums[i]);//也防止maxPre == 0, 有可能就是maxCurrent自己
                minCurrent = Math.min(minCurrent, maxPre * nums[i]);//也防止minPre == 0, 有可能就是minCurrent自己
            }
            
            maxPre = maxCurrent;
            minPre = minCurrent;
            
            res = Math.max(res, maxCurrent);
        }
        
        return res;
    }
}</code></pre>
</div>
</div>
