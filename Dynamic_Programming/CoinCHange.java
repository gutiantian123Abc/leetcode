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

public class Solution {
    /**
     * @param coins  a list of integer
     * @param amount a total amount of money amount
     * @return the fewest number of coins that you need to make up
     */
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
}