/* Missing Ranges
Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example 1
Given nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99
return ["2", "4->49", "51->74", "76->99"].

Example 2
Given nums = [0, 1, 3, 50, 75], lower = -1 and upper = 99
return ["-1", "2", "4->49", "51->74", "76->99"].

Example 3
Given nums = [0, 1, 3, 50, 75], lower = -10 and upper = 100
return ["-10 -> -1", "2", "4->49", "51->74", "76->100"].
记住， upper and lower must includes the given nums!!!
*/

public class Solution {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        List<String> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            addRange(ans, lower, upper);
            return ans;
        }
        
        addRange(ans, lower, (long)nums[0] - 1);
        
        for(int i = 1; i < nums.length; i++) {
            addRange(ans, (long)nums[i - 1] + 1, (long)nums[i] - 1);
        }
        
        addRange(ans, (long)nums[nums.length - 1] + 1, upper);
        return ans;
    }
    
    private void addRange(List<String> ans, long lower, long upper) { //记住，add array ranges 模板
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