## Problem Description
```
/* Minimum Size Subarray Sum 
Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. 
If there isn't one, return -1 instead.

Example
Given the array [2,3,1,2,4,3] and s = 7, 
the subarray [4,3] has the minimal length under the problem constraint.
O(2n)
*/
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
        /* 窗口类指针移动模板
        int j = 0;

        for(int i = 0; i < nums.length; i++) {

        	while(j < nums.length) {
        		if(满足条件) {
					j++;
					更行j状态
        		}else{
					break;
        		}
        	}

        	更新i状态
        }
        */
## Solution
```java

public class Solution {
    public int minimumSize(int[] nums, int s) {
        // write your code here

        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int j = 0;
        
        for(int i = 0; i < nums.length; i++) {
            while(j < nums.length) {
                if(sum < s) {
                    sum += nums[j];
                    j++;
                }else {
                    break;
                }
            }
            
            if(sum >= s) {
                ans = Math.min(ans, j - i);
            }
            
            sum -= nums[i];
        }
        
        if(ans == Integer.MAX_VALUE) {
            ans = -1;
        }
           
        return ans;
    }
}