/*Longest Increasing Subsequence
Given a sequence of integers, find the longest increasing subsequence (LIS).

You code should return the length of the LIS.

Have you met this question in a real interview? Yes
Clarification
What's the definition of longest increasing subsequence?

The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's 
elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. 
This subsequence is not necessarily contiguous, or unique.

https://en.wikipedia.org/wiki/Longest_increasing_subsequence

Example
For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4

Challenge 
Time complexity O(n^2) or O(nlogn)
*/

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length < 1) {
            return 0;
        }
        
        int[] f = new int[nums.length];
        int ans = 0;
        f[0] = 1;
        
        for(int i = 1; i < nums.length; i++) {
            f[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
              
            }
            
            ans = Math.max(ans, f[i]); //记住， 这里是每次都得比
        }
        
        return ans;
    }
}
