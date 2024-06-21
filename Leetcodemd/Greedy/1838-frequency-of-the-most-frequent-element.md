<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 600px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*1838. Frequency of the Most Frequent Element
https://leetcode.com/problems/frequency-of-the-most-frequent-element/

The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. 
In one operation, you can choose an index of nums and increment 
the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.

 

Example 1:

Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element 
two times to make nums = [4,4,4].
4 has a frequency of 3.

Example 2:

Input: nums = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
Example 3:

Input: nums = [3,9,6], k = 2
Output: 1
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
1 <= k <= 105
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int start = 0, end = 0;
        long curSum = 0; //(long) here means to prevent Integer Overflow
        int maxFreq = 0;

        while(end < nums.length) {
            curSum += nums[end];

            while((long) nums[end] * (end - start + 1) - curSum > k) {
                //(long) here means to prevent Integer Overflow
                curSum -= nums[start];
                start++;
            }
            maxFreq = Math.max(end - start + 1, maxFreq);
            end++;
        }

        return maxFreq;
    
    }
}</code></pre>
</div>
</div>
