/*  3Sum Closest
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.

Notice
You may assume that each input would have exactly one solution.

Example
For example, given array S = [-1 2 1 -4], and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

O(n^2) time, O(1) extra space
*/

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        int result = numbers[0] + numbers[1] + numbers[2];
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length; i++) {
            int start = i + 1, end = numbers.length - 1;
            while(start < end) {
                int sum = numbers[i] + numbers[start] + numbers[end];
                result = Math.abs(target - result) > Math.abs(target - sum) ? sum : result;
                if(sum == target) {
                    return sum;
                }else if(sum < target) {
                    start++;
                }else{
                    end--;
                }
            }
        }
        return result;
    }
}


/*
总结： 对于 N Sum 的问题， 总是先sort, 然后 for ...   while(start < end) 这一形式， 只是无限接近
答案， 从中挑选出最优解
*/
