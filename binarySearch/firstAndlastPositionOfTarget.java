/* First Position of Target
For a given sorted array (ascending order) and a target number, 
find the first index of this number in O(log n) time complexity.
If the target number does not exist in the array, return -1.
Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        
        while(start + 1 < end) {  // 固定模板 ！！！
            int mid = start + (end - start)/2; 
            if(nums[mid] == target) {
                end = mid;
            }else if(nums[mid] > target) {
                end = mid;
            }else {
                start = mid;
            }
        }
        
        if(nums[start] == target) { // 固定模板 ！！！
            return start;
        }    
        
        if(nums[end] == target) {
            return end;
        }
        
        return -1;
    }
}


/* Last Position of Target
Find the last position of a target number in a sorted array. Return -1 if target does not exist.

Example
Given [1, 2, 2, 4, 5, 5].
For target = 2, return 2.
For target = 5, return 5.
For target = 6, return -1.
*/

public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        // Write your code here
        
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                start = mid;
            }else if(nums[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }
        }
        
        if(nums[end] == target) {
            return end;
        }
        
        if(nums[start] == target) {
            return start;
        }
        
        return -1;
    }
}