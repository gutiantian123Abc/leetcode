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

public class Solution {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */


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
