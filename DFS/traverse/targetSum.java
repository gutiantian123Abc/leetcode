/*Paths of target Sum

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.

*/

//非常好的DFS， DP 题目

//DFS 解法：
class Solution {
    int count = 0; //注意， int 不能像 ArrayList<Integer> result 那样跟traverse, 只能设为全局变量
    public int findTargetSumWays(int[] nums, int S) { 
        dfs(nums, S, 0, 0);
        return count;
    }
    
    private void dfs(int[] nums, int S, int sum, int index) {
        if(index == nums.length) {
            if(sum == S) {
                count++;
            }
            return;
        }

        int curNum = nums[index]; //这里注意与combination, permutation, subset 区别， 没有for loop, 因为不是从什么地方开始
        //+
        dfs(nums, S, sum + curNum, index + 1);
        //_
        dfs(nums, S, sum - curNum, index + 1);
    }
}