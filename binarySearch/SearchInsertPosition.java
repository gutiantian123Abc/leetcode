/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume NO duplicates in the array.

Example
[1,3,5,6], 5 → 2

[1,3,5,6], 2 → 1

[1,3,5,6], 7 → 4

[1,3,5,6], 0 → 0

*/

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        if(A.length < 1) {
            return 0;
        }
        int start = 0, end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(target < A[mid]) {
                end = mid;
            }else if(target > A[mid]) {
                start = mid;
            }else{
                return mid;
            }
        }
        if(target <= A[start]) {
            return start;
        }else if(target <= A[end]) {
            return end;
        }else{
            return end + 1;
        }
    }
}
