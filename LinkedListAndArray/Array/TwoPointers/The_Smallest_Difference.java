/* The Smallest Difference
Given two array of integers(the first array is array A, 
the second array is array B), now we are going to find a element in array A which is A[i], 
and another element in array B which is B[j], so that the difference 
between A[i] and B[j] (|A[i] - B[j]|) is as small as possible, return their smallest difference.

Example
For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0

Challenge
O(n log n) time
*/

public class Solution {
    /**
     * @param A: An integer array
     * @param B: An integer array
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        Arrays.sort(A);
        Arrays.sort(B);
        int min = Integer.MAX_VALUE;
        int ai = 0, bi = 0;
        while(ai < A.length && bi < B.length) {
            min = Math.min(min, Math.abs(A[ai] - B[bi]));
            if(A[ai] < B[bi]) {
                ai++;
            }else {
                bi++;
            }
        }
        
        return min;
    }
}