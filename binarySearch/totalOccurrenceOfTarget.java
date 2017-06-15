/* Total Occurrence of Target
Given a target number and an integer array sorted in ascending order. 
Find the total number of occurrences of target in the array.
Have you met this question in a real interview? Yes
Example
Given [1, 3, 3, 4, 5] and target = 3, return 2.
Given [2, 2, 3, 4, 6] and target = 4, return 1.
Given [1, 2, 3, 4, 5] and target = 6, return 0.

Challenge 
Time complexity in O(logn)
*/

public class Solution {  // 二分法固定模板的套用: firstPosition & lastPosition
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        int start = firstPosition(A, target);
        int end = lastPosition(A, target);
        
        if(start == -1 || end == -1) {
            return 0;
        }
        
        return end - start + 1;
    }
    
    private int firstPosition(int[] nums, int target) {
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
    
    private int lastPosition(int[] nums, int target) {
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



