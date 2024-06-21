<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 50%; margin: auto; padding: 20px; }
  .comment-block { max-width: 50%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example
Given array [3,2,3,1,2], return 1.
*/
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
/* Best Time to Buy and Sell Stock II
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example
Given an example [2,1,2,0,1], return 2
*/
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
/*Best Time to Buy and Sell Stock III
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.

Notice
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example
Given an example [4,4,6,1,1,4,2,5], return 6.
*/
/*DP !!!!*/
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int result = 0, min = prices[0];

        for(int i = 0; i < prices.length; i++) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return result;
    }
}



class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i] < prices[i+1]) {
                res += prices[i+1] - prices[i];
            }
        }
        return res;
    }
};




class Solution {
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        
        int min = prices[0];
        int[] left = new int[prices.length];
        left[0] = 0;
        for(int i = 1; i < prices.length; i++) {
            left[i] = Math.max(left[i-1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        
        int max = prices[prices.length - 1];
        int[] right = new int[prices.length];
        right[prices.length - 1] = 0;
        for(int i = prices.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        
        int maxP = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            maxP = Math.max(maxP, left[i] + right[i]);
        }
        return maxP;
    }
};



</code></pre>
</div>
</div>
