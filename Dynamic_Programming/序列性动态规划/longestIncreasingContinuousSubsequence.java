/* Longest Increasing Continuous Subsequence
Give an integer array，find the longest increasing continuous subsequence in this array.

An increasing continuous subsequence:

Can be from right to left or from left to right.
Indices of the integers in the subsequence should be continuous.

Example
For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
*/


//Time: O(n), Space:O(1)
public class Solution {
    /*
     * @param : An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if(A.length == 0) {
            return 0;
        }
        int res = 1;
        int maxPre = 1;
        
        for(int i = 1; i < A.length; i++) {
            if(A[i] > A[i - 1]) {
                maxPre += 1;
            }else {
                maxPre = 1;
            }
        
            res = Math.max(res, maxPre);
        }
        
        maxPre = 1;
        for(int i = A.length - 2; i >= 0; i--) {
            if(A[i] > A[i + 1]) {
                maxPre += 1;
            }else {
                maxPre = 1;
            }
            
            res = Math.max(res, maxPre);
            
            
        }
        
        return res;
    }
};