/* Find Peak Element
There is an integer array which has the following features:

The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peek if:

A[P] > A[P-1] && A[P] > A[P+1]
Find a peak element in this array. Return the index of the peak.

Notice
The array may contains multiple peeks, find any of them.
Example
Given [1, 2, 1, 3, 4, 5, 7, 6]

Return index 1 (which is number 2) or 6 (which is number 7)

Challenge 
Time complexity O(logN)
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int start = 1, end = A.length - 2; //注意， binary search start end 有可能最后是0 A.length - 1, 在不适用的地方要注意
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            }else if(A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) { //下坡
                end = mid;
            }else if(A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) { //上坡
                start = mid;
            }else {//低谷
                end = mid;
            }
        }
    
        return A[start] > A[end] ? start : end; //不是start, 就是end
    }
}
