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
/* Maximum Average Subarray IGiven an array consisting of n integers,find the contiguous subarray of given length k that has the maximum average value.And you need to output the maximum average value.Example 1:Input: [1,12,-5,-6,50,3], k = 4Output: 12.75Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75Note:1 <= k <= n <= 30,000.Elements of the given array will be in the range [-10,000, 10,000].*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = -Double.MAX_VALUE; //注意， 这才是Double的最小值，而不是Double.MIN_VALUE
        if(k == 1) {
            for(int i = 0; i < nums.length; i++) {
                max = Math.max(max, (double)nums[i]);
            }
            return max;
        }
        
        int sum = 0;
        for(int i = 0; i < k - 1; i++) { //注意， sliding window
            sum += nums[i];
        }
        int index = 0;
        
        for(int i = k - 1; i < nums.length; i++) { //注意， sliding window
            sum += nums[i];
            double avg = ((double)sum) / k;
            max = Math.max(max, avg);
            sum -= nums[index];
            index++;
        }
        
        return max;   
    }
}</code></pre>
</div>
</div>
