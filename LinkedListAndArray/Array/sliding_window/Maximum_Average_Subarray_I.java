/* Maximum Average Subarray I
Given an array consisting of n integers, 
find the contiguous subarray of given length k that has the maximum average value. 
And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
*/

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
}