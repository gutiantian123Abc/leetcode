/*Best Time to Buy and Sell Stock III
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.

Notice
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example
Given an example [4,4,6,1,1,4,2,5], return 6.
*/

/*DP !!!!*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
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
