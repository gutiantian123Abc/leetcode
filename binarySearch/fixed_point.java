/* 1064. Fixed Point
https://leetcode.com/problems/fixed-point/

Given an array of distinct integers arr, where arr is sorted in ascending order, 
return the smallest index i that satisfies arr[i] == i. 
If there is no such index, return -1.

Example 1:

Input: arr = [-10,-5,0,3,7]
Output: 3
Explanation: For the given array, arr[0] = -10, arr[1] = -5, arr[2] = 0, arr[3] = 3, thus the output is 3.
Example 2:

Input: arr = [0,2,5,8,17]
Output: 0
Explanation: arr[0] = 0, thus the output is 0.
Example 3:

Input: arr = [-10,-5,3,4,7,9]
Output: -1
Explanation: There is no such i that arr[i] == i, thus the output is -1.
*/

class Solution {
    public int fixedPoint(int[] arr) {
        int start = 0, end = arr.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(arr[mid] >= mid) {
                end = mid;
            }else if(arr[mid] < mid) {
                start = mid;
            }
        }
        
        if(arr[start] == start) {
            return start;
        }
        
        if(arr[end] == end) {
            return end;
        }
        
        return -1;
        
    }
}