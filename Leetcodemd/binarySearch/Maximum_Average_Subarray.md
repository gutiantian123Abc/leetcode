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
/* Maximum Average SubarrayGiven an array with positive and negative numbers,find the maximum average subarray which length should be greater or equalto given length k.It's guaranteed that the size of the array is greater or equal to k.ExampleGiven nums = [1, 12, -5, -6, 50, 3], k = 3Return 15.667 // (-6 + 50 + 3) / 3 = 15.667*/    /**     * @param nums an array with positive and negative numbers     * @param k an integer     * @return the maximum average     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>



public class Solution {
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        double error = 1e-12; //看题意！！！
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
            }
            
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        
        while(min + error < max)  { //1e-6 是double 的 1， 对比int 的 start + 1 < end
            double mid = (min + max) / 2.0;
            if(check(nums, mid, k)) {
                min = mid;
            }else {
                max = mid;
            }
        }
        
        return min; //这种double 的estimate 只返回min (left)
    }
    
    
    
    private boolean check(int[] nums, double mid, int k) {
        double[] sums = new double[nums.length + 1];
        sums[0] = 0;
        for(int i = 1; i < sums.length; i++) { //subarray sum : sums[n + 1], sums[0] = 0
            sums[i] += sums[i - 1] + nums[i - 1] - mid;
        }
        double min_pre = sums[0];
        for(int i = k; i < sums.length; i++) {
            if(sums[i] - min_pre >= 0) {
                return true;
            }
            
            min_pre = Math.min(min_pre, sums[i - k + 1]);
        }
        
        return false;
    }
}
</code></pre>
</div>
</div>
