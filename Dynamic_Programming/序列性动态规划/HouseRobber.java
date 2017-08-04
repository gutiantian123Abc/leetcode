/* House Robber I
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses 
have security system connected and it will automatically contact the police if two adjacent houses
were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example
Given [3, 8, 4], return 8.

Challenge 
O(n) time and O(1) memory.
*/

public class Solution {
    /*
     * @param : An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if(A == null || A.length == 0) {
            return 0;
        }

        long[][] f = new long[2][2];
        
        int oldLine = 0, newLine = 0;
        
        for(int i = 1; i <= A.length; i++) {//买0套房子花0快钱， 所以买几套房子挣的钱从 1 到 <= A.length
            oldLine = newLine; //经典前倚式
            newLine = 1 - newLine;
            
            f[newLine][0] = Math.max(f[oldLine][0], f[oldLine][1]);//经典前倚式， 只更新 f[newLine][0],  f[newLine][1]
            f[newLine][1] = A[i - 1] + f[oldLine][0];
        }
        
        return Math.max(f[newLine][0], f[newLine][1]);
    }
};
