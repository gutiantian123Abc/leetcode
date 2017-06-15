/* Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example
Given an example n=3 , 1+1+1=2+1=1+2=3

return 3
*/

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if(n == 0 || n == 1) {
            return 1;
        }

        if(n == 2) {
            return 2;
        }
        
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        
        return f[n];
    }
}