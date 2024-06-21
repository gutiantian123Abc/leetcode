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
/* Continuous Subarray Sum
Given a list of non-negative numbers and a target integer k, write a function to check if 
the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, 
sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
Note:
The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//1.简单方法， subarray sum 模板， Time O(n^2), Space O(n)
class Solution {
    private class Pair {
        public int sum = 0;
        public int index = 0;
        
        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
    
    public boolean checkSubarraySum(int[] nums, int k) { 
        int preSum = 0;
        Pair[] prefixSum = new Pair[nums.length + 1];
        prefixSum[0] = new Pair(0, 0);
        
        for(int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = new Pair(nums[i - 1] + preSum, i);
            preSum += nums[i - 1];
        }
        
        for(int start = 0; start < prefixSum.length - 1; start++) {
            for(int end = start + 1; end < prefixSum.length; end++) {
                if(k == 0) {
                    if(prefixSum[end].sum - prefixSum[start].sum == 0 && prefixSum[end].index - prefixSum[start].index >= 2) {
                        return true;
                    }
                }else {
                     if((prefixSum[end].sum - prefixSum[start].sum) % k == 0 && prefixSum[end].index - prefixSum[start].index >=                      2) {
                        return true;
                     }                   
                }

            }
        }
        
        return false;
    }
}</code></pre>
</div>
</div>
