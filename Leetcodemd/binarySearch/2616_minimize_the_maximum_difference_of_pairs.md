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
/* 
https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/
You are given a 0-indexed integer array nums and 
an integer p. Find p pairs of indices of nums 
such that the maximum difference amongst all the 
pairs is minimized. Also, ensure no index appears 
more than once amongst the p pairs.

Note that for a pair of elements at the index i and j, 
the difference of this pair is |nums[i] - nums[j]|,
where |x| represents the absolute value of x.

Return the minimum maximum difference among all p pairs. 
We define the maximum of an empty set to be zero.

 

Example 1:

Input: nums = [10,1,2,7,1,3], p = 2
Output: 1
Explanation: The first pair is formed from the indices 1 and 4, 
and the second pair is formed from the indices 2 and 5. 
The maximum difference is 
max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. 
Therefore, we return 1.

Example 2:

Input: nums = [4,2,1,2], p = 1
Output: 0
Explanation: Let the indices 1 and 3 form a pair. 
The difference of that pair is |2 - 2| = 0, which is the minimum we can attain.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109
0 <= p <= (nums.length)/2
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];

        while(left + 1 < right) {
            int maxDiff = left + (right - left)/2;
            int pairs = test(nums, p, maxDiff);

            if(pairs >= p) {
                right = maxDiff;
            } else {
                left = maxDiff;
            } 
        }

        if(test(nums, p, left) == p) {
            return findLargestDifference(nums, p, left);
        } else {
            return findLargestDifference(nums, p, right);
        }      
    }

    private int test(int[] nums, int p, int maxDiff) {
        int i = 1, pairs = 0, n = nums.length;
        while(i < n && pairs < p) {
            if(nums[i] - nums[i - 1] <= maxDiff) {
                i += 2;
                pairs++;
            } else {
                i++;
            }
        }

        return pairs;
    }

    private int findLargestDifference(int[] nums, int p, int maxDiff) {
        int pairs = 0, largestDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                largestDiff = Math.max(largestDiff, nums[i] - nums[i - 1]);
                pairs++;
                i++; // Skip the next element as it's already paired
            }
            if (pairs == p) break;
        }
        return largestDiff;
    }
}</code></pre>
</div>
</div>
