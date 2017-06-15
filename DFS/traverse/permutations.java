/* Permutations
Given a list of numbers, return all possible permutations.
Notice
You can assume that there is no duplicate numbers in the list.
Example:
For nums = [1,2,3], the permutations are:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
// 对比 subsets, combinations, catlan combinations
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helper(result, list, nums);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(result, list, nums);
            list.remove(list.size() - 1);
        }
  
    }
}
