<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Paint House I & II

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
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
/*
更好的方法: 原理：
f[i][j] = mink≠j {f[i-1][k]} + cost[i-1][j]
如果最小值是第i个元素，次小值是第j个元素
1. 只要除掉的元素不是第i个，剩下的最小值就是第i个元素
2. 如果除掉的元素是第i个，剩下的最小值就是第j个元素
Time: O(NK)
Space: O(N)
*/
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
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
        
        for(int i = 0; i < houseNum; i++) {//以0作为基石的就要从1 到 <= n
            oldLine = newLine; //Toggle pointers
            newLine = 1 - newLine;

            for(int j = 0; j < colorNum; j++) {
                f[newLine][j] = Integer.MAX_VALUE;
                for(int k = 0; k < colorNum; k++) {
                    if(k != j && f[oldLine][k] + costs[i][j] < f[newLine][j]) {//迭代找与非自己加和最小
                        f[newLine][j] = f[oldLine][k] + costs[i][j];//注意cost[i - 1]下标
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




public class Solution {
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
        
        for(int i = 0; i < houseNum; i++) {
            oldLine = newLine;
            newLine = 1 - newLine;
            
            //每次需要求f[i-1][1], …, f[i-1][K]中除了一个元素之外其他元素的最小值!!!!!!!!
            //  |
            //  |
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            
            for(int j = 0; j < colorNum; j++) {
                if(f[oldLine][j] < min1) {
                    min2 = min1;
                    min1 = f[oldLine][j];
                }else {
                    if(f[oldLine][j] < min2) {
                        min2 = f[oldLine][j];
                    }
                }
            }
            
            for(int j = 0; j < colorNum; j++) {
                if(f[oldLine][j] == min1) {
                    f[newLine][j] = min2 + costs[i][j];
                }else {
                    f[newLine][j] = min1 + costs[i][j];
                }
            }

            //  |
            //  |
            //每次需要求f[i-1][1], …, f[i-1][K]中除了一个元素之外其他元素的最小值!!!!!!!!

        }
      
      
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < colorNum; i++) {
            res = Math.min(res, f[newLine][i]);
        }
        
        return res;
    }
}
</code></pre>
</div>
</div>
