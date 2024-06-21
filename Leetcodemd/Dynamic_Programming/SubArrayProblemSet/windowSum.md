<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 400px; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Window Sum
Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, 
find the sum of the element inside the window at each moving.

Example
For array [1,2,7,8,5], moving window size k = 3. 
1 + 2 + 7 = 10
2 + 7 + 8 = 17
7 + 8 + 5 = 20
return [10,17,20]
*/
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {


    //PrefixSum[i] = A[0] + A[1] + … A[i - 1], PrefixSum[0] = 0
   //Sum(i~j) = PrefixSum[j + 1] - PrefixSum[i]
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int len = nums.length;
        int[] ans = new int[len + 1 - k];
        int[] sums = new int[len + 1];
        sums[0] = 0;
        
        int prevSum = 0;
        for(int i = 1; i < len + 1; i++) {
            sums[i] = prevSum + nums[i - 1];
            prevSum = sums[i];
        }
    
        for(int i = 0; i < ans.length; i++) {
            ans[i] = sums[i + k] - sums[i];
        }
        return ans;
    }
}
</code></pre>
</div>
</div>
