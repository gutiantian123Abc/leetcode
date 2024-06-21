<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Best Time to Buy and Sell Stock I

Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.

Example
Given array [3,2,3,1,2], return 1.
*/
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
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
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
/* Best Time to Buy and Sell Stock III (昨日多态法f[2][j]  !!!)
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example
Given an example [4,4,6,1,1,4,2,5], return 6.
*/
/* 解题原理：
五个阶段：
1.第一次买之前   （第一次买）   2.持有股票     （第一次卖）    3.第一次卖之后，     （第二次买）   4.持有股票      （第二次卖）  5.第二次卖之后
                                                          第二次买之前

状态：f[i][j]表示前i天(第i-1天)结束后，在阶段j的最大获利

阶段1,	3,	5	--- 手中无股票状态:
f[i][j]	=	max{f[i-1][j],	       f[i-1][j-1] + Pi-1 – Pi-2}
	            昨天没有持有股票      昨天持有股票，今天卖出清仓


阶段2,	4 --- 手中有股票状态:
f[i][j]	=	max{f[i-1][j]	+	Pi-1 – Pi-2,	f[i-1][j-1]}
                昨天就持有股票，继续持有并获利       昨天没有持有股票，今天买入
*/
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
/*Best Time to Buy and Sell Stock IV 
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most k transactions.
Example
Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.

Challenge 
O(nk) time.
*/
/* 解题原理：(与上同)
五个阶段：
1.第一次买之前   （第一次买）   2.持有股票     （第一次卖）    3.第一次卖之后，     （第二次买）   4.持有股票      （第二次卖）  5.第二次卖之后
                                                          第二次买之前

状态：f[i][j]表示前i天(第i-1天)结束后，在阶段j的最大获利

阶段1,    3,  5   --- 手中无股票状态:
f[i][j] =   max{f[i-1][j],         f[i-1][j-1] + Pi-1 – Pi-2}
                昨天没有持有股票      昨天持有股票，今天卖出清仓


阶段2,    4 --- 手中有股票状态:
f[i][j] =   max{f[i-1][j]   +   Pi-1 – Pi-2,    f[i-1][j-1]}
                昨天就持有股票，继续持有并获利       昨天没有持有股票，今天买入
*/
    /*
     * @param : An integer
     * @param : An integer array
     * @return: Maximum profit
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
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





class Solution {
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




class Solution {
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length < 2) {
            return 0;
        }
        
        int[][] f = new int[2][5];
        int newLine = 0, oldLine = 0;
        int yesterday_Price = prices[0];
        for(int i = 1; i < prices.length; i++) {//记住， newLine 是跟着 i 走的，i 从1开始是因为 today_Pirce - yesterday_Price，第0天不该获利
            oldLine = newLine;
            newLine = 1 - newLine;
            int today_Pirce = prices[i];
            for(int j = 0; j < 5; j++) {
                if(j % 2 == 0) { //no
                    if(j == 0) {
                        f[newLine][j] = f[oldLine][j];
                    }else {
                        f[newLine][j] = Math.max(f[oldLine][j], f[oldLine][j - 1] + today_Pirce - yesterday_Price);
                    }
                }else {//yes
                    f[newLine][j] = Math.max(f[oldLine][j - 1], f[oldLine][j] + today_Pirce - yesterday_Price);
                }
            }
            yesterday_Price = prices[i];
        }
         
        int res = 0;
        for(int i = 0; i < 5; i++) {
                res = Math.max(res, f[newLine][i]);
        }
        
        return res;
    }
};




public class Solution {
    public int maxProfit(int K, int[] prices) {
        // write your code here
        if(prices == null || prices.length < 2) {
            return 0;
        }
        
        int n = prices.length;
        
        if (K == 0) {
            return 0;
        }
        
        int res = 0;
        
        if (K > n) { //非常重要， 好好体会
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }
        
        int[][] f = new int[2][2 * K + 1];
        int oldLine = 0, newLine = 0;
        
        for(int i = 1; i < prices.length; i++) {
            oldLine = newLine;
            newLine = 1 - newLine;
            int price_today = prices[i];
            int price_yesterday = prices[i - 1];
            for(int j = 0; j < 2 * K + 1; j++) {
                if(j % 2 == 0) {  //even, 没股票
                    if(j == 0) {
                        f[newLine][j] = f[oldLine][j];
                    }else {
                        f[newLine][j] = Math.max(f[oldLine][j], f[oldLine][j - 1] + price_today - price_yesterday);
                    }
                }else { //Odd, 有股票
                    f[newLine][j] = Math.max(f[oldLine][j - 1], f[oldLine][j] + price_today - price_yesterday);
                }
            }
        }
        
        for(int i = 0; i < 2 * K + 1; i++) {
            res = Math.max(res, f[newLine][i]);
        }
        
        return res;
    }
};


















</code></pre>
</div>
</div>
