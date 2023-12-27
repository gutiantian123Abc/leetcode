/* Subsets
Given a set of distinct integers, return all possible subsets.

Notice
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.

Example
If S = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

// 对比 permutations, combinations, catlan combinations
//SPace and Time: O(2^n)
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(result, list, nums, 0);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] nums, int start) {
        
        result.add(new ArrayList<Integer>(list));
   
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

/* Subset II
Given a collection of integers that might contain duplicates, S, return all possible subsets.
Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets. For example, If S = [1,2,2], a solution is:
[ [2], [1], [1,2,2], [2,2], [1,2], [] ]
*/

class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) return results;
        
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<Integer>();
        helper(nums, 0, subset, results);
        
        return results;
        
        
    }
    public void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results){
        results.add(new ArrayList<Integer>(subset));
        for(int i = startIndex; i<nums.length; i++){
            if (i != startIndex && nums[i] == nums[i-1]) {
                continue;
            }
            subset.add(nums[i]);
            helper(nums, i+1, subset, results);
            subset.remove(subset.size()-1);
        }
    }
}

