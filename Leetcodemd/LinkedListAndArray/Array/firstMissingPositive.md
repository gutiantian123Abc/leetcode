## Problem Description
```
/* First Missing Positive
Given an unsorted integer array, find the first missing positive integer.

Example
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
## Solution
```java

public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A == null ) {
            return 1;
        }
        
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != i + 1) {
                if (A[A[i] - 1] == A[i]) {
                    break;
                }
                swap(A, A[i] - 1, i);
            }
        }
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) {
                return i + 1;
            }
        }
        
        return A.length + 1;
    }
    
    private void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}