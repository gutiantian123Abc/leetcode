/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Notice
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.

Example
For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
(-1, 0, 1)
(-1, -1, 2)
*/
public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numbers == null) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(numbers);
        helper(numbers, 0, list, 0, result);
        return result;
    }
     
    private void helper(int[] numbers, int target, ArrayList<Integer> list, int index,
        ArrayList<ArrayList<Integer>> result) {
        if(list.size() == 3) {
            if (target == 0) {
                result.add(new ArrayList<Integer>(list));
                return;
            }else{
                return;
            }
        }
        
        for (int i = index; i < numbers.length; i++) {
            if (i != index && numbers[i] == numbers[i - 1]) {// repetation
                continue;
            }
            list.add(numbers[i]);
            helper(numbers, target - numbers[i], list, i + 1, result);
            list.remove(list.size() - 1);
            prev = numbers[i];// repetation
        }
    }
}