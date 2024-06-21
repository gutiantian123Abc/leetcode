## Problem Description
```
/* 
Part 1:
Given an array and a value, remove all occurrences of that value in place and return the new length.

The order of elements can be changed, and the elements after the new length don't matter.

Given an array [0,4,4,0,0,2,4,4], value=4

return 4 and front four elements of the array is [0,0,0,2]
*/
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
/* 
Part 2:

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].

*/
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
## Solution
```java

public class Solution {
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null) {
            return 0;
        }
        int size = 0, i = 0, j = 0;
        for(i = 0; i < nums.length;) {
            int now = nums[i];
            for(j = i; j < nums.length; j++) {
                if(nums[j] != now) {
                    break;
                }else {
                    if(j == i) {
                        nums[size++] = now;
                    }
                }
            }
            i = j;
        }
        return size;
    }
}







public class Solution {
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null) {
            return 0;
        }
        
        int i, j, size = 0;
        for(i = 0; i < nums.length;) {
            int now = nums[i];
            for(j = i; j < nums.length; j++) {
                if(nums[j] != now) {
                    break;
                }else {
                    if(j - i < 2) {
                        nums[size++] = nums[j];
                    }
                }              
            }        
            i = j;  
        }
        return size; 
    }
}