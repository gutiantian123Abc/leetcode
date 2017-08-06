/* Best Time to Buy and Sell Stock I

Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.

Example
Given array [3,2,3,1,2], return 1.
*/

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length < 2) {
            return 0;
        }
        
        int minPrice = prices[0], res = 0;
        for(int i = 1; i < prices.length; i++) {
            int currPrice = prices[i];
            res = Math.max(res, currPrice - minPrice);
            minPrice = Math.min(minPrice, currPrice);
        }
        
        return res;
    }
}



/* Best Time to Buy and Sell Stock II 
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example
Given an example [2,1,2,0,1], return 2
*/

/* 解题原理： 买卖任意多次
最优策略是如果今天的价格比明天的价格低，就今天买，明天卖（贪心）

正确性证明可以从这里下手：
– 如果最优策略第10天买，第15天卖，我们可以把它分解成5天，结果不会变差
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length < 2) {
            return 0;
        }
        
        int profit = 0;
        
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
        
    }
};


















