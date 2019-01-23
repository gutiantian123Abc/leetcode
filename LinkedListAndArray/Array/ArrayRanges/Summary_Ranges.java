s
/* Summary Ranges: https://www.lintcode.com/problem/summary-ranges/description
Given a sorted integer array without duplicates, return the summary of its ranges.

Example
Example 1:

Input: [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Example 2:

Input: [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Notice
The result is in ascending order
*/

public class Solution {
    /**
     * @param nums:  a sorted integer array without duplicates
     * @return: the summary of its ranges
     */
    public List<String> summaryRanges(int[] nums) {
        // Write your code here
        List<String> ans = new ArrayList<String>();
        if(nums == null || nums.length == 0) {
            return ans;
        }
        int j = 1, i = 0;
        
        while(j < nums.length) {
            while(j < nums.length && nums[j] == nums[j - 1] + 1) {
                j++;
            }
            
            addRange(nums, i, j - 1, ans);
            
            if(j >= nums.length) {
                return ans;
            }else {
                i = j;
                j++;
            }
        }
        
        addRange(nums, i, nums.length - 1, ans);
        return ans;
        
    }
    
    private void addRange(int[]nums, int start, int end, List<String> ans) {
        StringBuilder sb = new StringBuilder();
        if(start == end) {
            sb.append(nums[start]);
        }else{
            sb.append(nums[start]);
            sb.append("->");
            sb.append(nums[end]);
        }

        ans.add(sb.toString());
    }
}