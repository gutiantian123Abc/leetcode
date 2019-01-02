/* Summary Ranges
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
        List<String> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return ans;
        }
        
        int j = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] + 1 == nums[i]) {
                continue;
            }
            addRange(ans, nums[j], nums[i - 1]);
            j = i;
        }
        
        addRange(ans, nums[j], nums[nums.length - 1]);
        
        return ans;
    }
    
    private void addRange(List<String> ans, int lower, int upper) {
        if(lower > upper) {
            return;
        }
        
        if(lower == upper) {
            ans.add(lower + "");
            return;
        }
        
        ans.add(lower + "->" + upper);
    }
}