<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 600px; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Coins in a Line I

There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left. The player who take the last coin wins.

Could you please decide the first play will win or lose?

Have you met this question in a real interview? Yes
Example
n = 1, return true.

n = 2, return true.

n = 3, return false.

n = 4, return true.

n = 5, return true.

Challenge 
O(n) time and O(1) memory
*/
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public boolean firstWillWin(int n) {
        // write your code here
        
        if(n == 0) {
            return false;
        }
        
        if(n == 1 || n == 2) {
            return true;
        }
        
        boolean[] dp = new boolean[3];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        
        int oldLineOne = 1, oldLineTwo = 2, newLine = 0;
        
        for(int i = 3; i <= n; i++) {

            newLine = 3 - (oldLineOne + oldLineTwo);//三层滚动型数组
            
            dp[newLine] = !dp[oldLineOne] || !dp[oldLineTwo];
                
            dLineOne = oldLineTwo;//三层滚动型数组
            oldLineTwo = newLine;//三层滚动型数组
        }
        
        return dp[newLine];
       
    }
}</code></pre>
</div>
</div>
