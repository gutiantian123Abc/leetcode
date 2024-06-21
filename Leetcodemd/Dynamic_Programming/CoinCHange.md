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
/* Coin Change
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.
Notice
You may assume that you have an infinite number of each kind of coin.
Example
Given coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Given coins = [2], amount = 3
return -1.
*/
    /**
     * @param coins  a list of integer
     * @param amount a total amount of money amount
     * @return the fewest number of coins that you need to make up
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int coinChange(int[] coins , int amount) {
        // Write your code here
        int[] f = new int[amount + 1];
        f[0] = 0;//基石, 这一点人家没说， 要问明白！！！
        for(int i = 1; i < amount + 1; i++) {
            f[i] = -1;
            for(int j = 0; j < coins.length; j++) {
                if(f[i] == -1) {
                    if(qualified(f, coins, i, j)) {
                        f[i] = f[i - coins[j]] + 1;
                    }
                }else {
                    if(qualified(f, coins, i, j) && f[i - coins[j]] + 1 < f[i]) {
                        f[i] = f[i - coins[j]] + 1;
                    }
                }
            }
        }
        
        return f[amount];
    }
    
    private boolean qualified(int[] f, int[] coins, int i, int j) {
        return i - coins[j] >= 0 && f[i - coins[j]] != -1;
    }
}</code></pre>
</div>
</div>
