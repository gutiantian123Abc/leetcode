<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 700px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Backpack IGiven n items with size Ai, an integer m denotes the size of a backpack. How full you can fill thisbackpack?You can not divide any item into small pieces.ExampleIf we have 4 items with size [2, 3, 5, 7],the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is10.If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.You function should return the max size we can fill in the given backpack.ChallengeO(n x m) time and O(m) memory.O(n x m) memory is also acceptable if you do not know how to optimize memory.*//* 原理及解析：这道题可以演绎成在一个全为正数的数组中， 找到任意组合的加和 <= target 的最大值，这道题可以用subset sum 来做， 但时间与空间的复杂度都是 O(2 ^ n). Subset sum 可以应用于负数但这道题如果在所有数都为正数的情况下则可以用DP里面的背包问题来解决， O(n x m) time and O(m) memory本体原理：设f[i][w] = 能否用前i个物品拼出重量w (TRUE / FALSE)f[i][w]    =        f[i-1][w]          OR         f[i-1][w-A[i-1]]能否用前i个物品拼出    能否用前i-1个物品     或         能否用前i-1个物品拼出重量w - A[i-1]，重量w                             拼出重量w                         再加上第i个物品*/    /**     * @param m: An integer m denotes the size of a backpack     * @param A: Given n items with size A[i]     * @return: The maximum size     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int backPack(int m, int[] A) {
        // write your code here
        if(A == null || A.length < 1 || m < 1) {
            return 0;
        }
        
        boolean[][] dp = new boolean[2][m + 1];
        int oldLine = 0, newLine = 0;
        dp[0][0] = true;
        for(int i = 0; i < A.length; i++) {
            oldLine = newLine;//双层滚动式数组
            newLine = 1 - oldLine;
            for(int w = 0; w <= m; w++) {
                
                dp[newLine][w] = dp[oldLine][w];
                
                if(w >= A[i] && dp[oldLine][w - A[i]]) {
                    dp[newLine][w] = true;
                }
                
            }
        }
        
        for(int w = m; w >= 0; w--) {
            if(dp[newLine][w] == true) {
                return w;
            }
        }
        
        return 0;
    }
}</code></pre>
</div>
</div>
