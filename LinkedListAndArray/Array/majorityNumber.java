/* Majority Number I

Given an array of integers, 
the majority number is the number that occurs more than half of the size of the array. Find it.

Example
Given [1, 1, 1, 1, 2, 2, 2], return 1

Challenge 
O(n) time and O(1) extra space
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {

        // Majority Voting Algorithm :
        int count = 0, candidate = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.size(); i++) {
            if(count == 0) {
                candidate = nums.get(i);
                count++;
            }else if(nums.get(i) == candidate) {
                count++;
            }else{
                count--;
            }
        }
          
        // Make sure candidate is really the answer
        count = 0;
        for(int num : nums) {
            if(num == candidate) {
                count++;
            }
        }
        
        return count > nums.size() / 2 ? candidate : -1;
    }
}







/* Majority Number II
Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.
Find it.

Example
Given [1, 2, 1, 2, 1, 3, 3], return 1.

Challenge 
O(n) time and O(1) extra space.
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int count1 = 0, count2 = 0, candidate1 = Integer.MAX_VALUE, candidate2 = Integer.MIN_VALUE;
        
        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            }else if(num == candidate2) {
                count2++;
            }else if(count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }else if(count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            }
            
            if(num == candidate2) {
                count2++;
            }
        }
        
        return count1 > count2 ? candidate1 : candidate2;
    }
}


/* 总结：
例如找出 1/k majority numbers 的问题， 可以设置 k-1 个candidate
*/
