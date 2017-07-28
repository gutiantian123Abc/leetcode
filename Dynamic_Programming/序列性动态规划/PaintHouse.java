/* Paint House 

There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... 
Find the minimum cost to paint all houses.

All costs are positive integers.

Example
Given costs = [[14,2,11],[11,14,5],[14,3,10]] return 10
house 0 is blue, house 1 is green, house 2 is blue, 2 + 5 + 3 = 10
*/

public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // Write your code here
        int houseNum = costs.length;
        if(houseNum == 0) {
            return 0;
        }
        
        int colorNum = costs[0].length;
        int[][] f = new int[2][colorNum];
        int oldLine = 0;
        int newLine = 0;
        
        for(int i = 1; i <= houseNum; i++) {//以0作为基石的就要从1 到 <= n
            oldLine = newLine; //Toggle pointers
            newLine = 1 - newLine;

            for(int j = 0; j < colorNum; j++) {
                f[newLine][j] = Integer.MAX_VALUE;
                for(int k = 0; k < colorNum; k++) {
                    if(k != j && f[oldLine][k] + costs[i - 1][j] < f[newLine][j]) {//迭代找与非自己加和最小
                        f[newLine][j] = f[oldLine][k] + costs[i - 1][j];//注意cost[i - 1]下标
                    }
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < colorNum; i++) {
            res = Math.min(res, f[newLine][i]);
        }
        
        return res;
    }
}