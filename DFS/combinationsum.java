/* Combination Sum
Given a collection of candidate numbers (C) and a target number (T), 
Each number in C may only be used once in the combination.
All numbers (including target) could be any positive or negative integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
*/

/* 异常重要的题型，融合了DFS 与 DP 的双源变种， 异常强大
 */


/* 
All numbers (including target) could be any positive or negative integers.
The solution set must not contain duplicate combinations.
一. 变种1. 找寻任意加和等于target的combination
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] candidates,
            int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<Integer>();
        int sum = 0;
        helper(candidates, 0, combination, sum, target, results);

        return results;
    }

    private void helper(int[] candidates,
                        int startIndex,
                        List<Integer> combination,
                        int sum,
                        int target,
                        List<List<Integer>> results) {

        if(sum == target) {
            results.add(new ArrayList<Integer>(combination));
            return;            
        }
        
        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            if (sum > target) {
                break;
            }
            combination.add(candidates[i]);
            helper(candidates, i + 1, combination, sum, target, results);
            combination.remove(combination.size() - 1);
            sum -= candidates[i];
        }
    }
}













/* 
All numbers (including target) could be any positive or negative integers.
The solution set must not contain duplicate combinations.
二. 变种2. 找寻任意加和小于target的combination
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] candidates,
            int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<Integer>();
        int sum = 0;
        helper(candidates, 0, combination, sum, target, results);

        return results;
    }

    private void helper(int[] candidates,
                        int startIndex,
                        List<Integer> combination,
                        int sum,
                        int target,
                        List<List<Integer>> results) {
        if(sum == target) {
            results.add(new ArrayList<Integer>(combination));
            return;            
        }
        
        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            if (sum >= target) {//跟小于等于仅有 >= 和 > 的区别
                break;
            }
            combination.add(candidates[i]);
            results.add(new ArrayList<Integer>(combination));//于等于的区别
            helper(candidates, i + 1, combination, sum, target, results);
            combination.remove(combination.size() - 1);
            sum -= candidates[i];
        }
    }
}
















/* 
All numbers (including target) could be any positive or negative integers.
The solution set must not contain duplicate combinations.
三. 变种3. 找寻任意加和小于等于target的combination
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] candidates,
            int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<Integer>();
        int sum = 0;
        helper(candidates, 0, combination, sum, target, results);

        return results;
    }

    private void helper(int[] candidates,
                        int startIndex,
                        List<Integer> combination,
                        int sum,
                        int target,
                        List<List<Integer>> results) {
        if(sum == target) {
            results.add(new ArrayList<Integer>(combination));
            return;            
        }
        
        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            if (sum > target) {//跟小于仅有 >= 和 > 的区别
                break;
            }
            combination.add(candidates[i]);
            results.add(new ArrayList<Integer>(combination));//于等于的区别
            helper(candidates, i + 1, combination, sum, target, results);
            combination.remove(combination.size() - 1);
            sum -= candidates[i];
        }
    }
}




