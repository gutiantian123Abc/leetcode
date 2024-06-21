## Problem Description
```
/* Trapping Rain Water： http://www.lintcode.com/en/problem/trapping-rain-water/
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

Example
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Challenge 
O(n) time and O(1) memory
O(n) time and O(n) memory is also acceptable.
*/
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
## Solution
```java

public class Solution {
    public int trapRainWater(int[] heights) {
        // write your code here
        if(heights == null || heights.length < 1) {
            return 0;
        }
        int left = 0, right = heights.length - 1;
        int leftHeight = heights[left];
        int rightHeight = heights[right];
        int res = 0;
        while(left < right) {
            if(rightHeight > leftHeight) {
                left++;
                if(leftHeight > heights[left]) {
                    res += leftHeight - heights[left];
                }else {
                    leftHeight = heights[left];
                }
            }else {
                right--;
                if(rightHeight > heights[right]) {
                    res += rightHeight - heights[right];
                }else {
                    rightHeight = heights[right];
                }
            }
        }
        
        return res;
    }
}