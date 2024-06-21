<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 500px; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/description/

You are given three positive integers: n, index, and maxSum. 
You want to construct an array nums (0-indexed) that satisfies 
the following conditions:

nums.length == n
nums[i] is a positive integer where 0 <= i < n.
abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
The sum of all the elements of nums does not exceed maxSum.
nums[index] is maximized.
Return nums[index] of the constructed array.

Note that abs(x) equals x if x >= 0, and -x otherwise.

 

Example 1:

Input: n = 4, index = 2,  maxSum = 6
Output: 2
Explanation: nums = [1,2,2,1] is one array that satisfies all 
the conditions.

There are no arrays that satisfy all the conditions 
and have nums[2] == 3, 
so 2 is the maximum nums[2].
Example 2:

Input: n = 6, index = 1,  maxSum = 10
Output: 3
 

Constraints:

1 <= n <= maxSum <= 109
0 <= index < n
*/
    	/*
    	Forming two arithmetic sequences. 
    	One sequence increases towards index, and the other decreases away from it.
		（首项 加 末项）乘以 项数 除以2
    	*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int start = 0, end = maxSum;
        //In each iteration, use binary search to find 
        //the potential value for nums[index].
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            long sum = getSum(mid, index, n);

            if(sum > maxSum) {
                end = mid;
            } else if(sum < maxSum) {
                start = mid;
            } else {
                return mid + 1;
            }
        }

        long startSum = getSum(start, index, n);
        long endSum = getSum(end, index, n);

        if(endSum <= maxSum) {
            return end + 1;
        } else {
            return start + 1;
        }
    }

    private long getSum(int val, int index, int n) {
        int leftBase = Math.max(0, val - index);
        int leftDigitNums = val - leftBase + 1;
        long leftSum = (long)(leftBase + val) * leftDigitNums / 2;

        int rightBase = Math.max(0, (val - (n - 1 - index)));
        int rightDigitNums = val - rightBase + 1;
        long rightSum = (long)(rightBase + val) * rightDigitNums / 2;

        return leftSum + rightSum - val;
    }
}</code></pre>
</div>
</div>
