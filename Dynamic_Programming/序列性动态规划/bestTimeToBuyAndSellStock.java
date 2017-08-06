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