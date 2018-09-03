/* Dices Sum
Throw n dices, the sum of the dices' faces is S. Given n, 
find the all possible value of S along with its probability.

Example
Given n = 1, return [ [1, 0.17], [2, 0.17], [3, 0.17], [4, 0.17], [5, 0.17], [6, 0.17]].
*/

public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        
        //dp[i][j] 保存投掷i次得到和为j的概率,当前位置的概率为当前投掷1 ~ 6的情况下的前序概率的和除以6.0
        double[][] dp = new double[n + 1][6 * n + 1];
        List<Map.Entry<Integer, Double>> res = new ArrayList<>();
        for(int j = 1; j <= 6; j++) {
            dp[1][j] = 1.0 / 6.0;
        }
        
        for(int i = 2; i <= n; i++) {
            for(int j = i; j <= 6 * i; j++) {
                for(int k = 1; k <= 6; k++) {
                    if(j > k) {
                        dp[i][j] += dp[i - 1][j - k] / 6.0;
                    }
                }
            }
        }
        
        for(int i = n; i <= 6 * n; i++) {
            res.add(new AbstractMap.SimpleEntry<Integer, Double>(i, dp[n][i]));
        }
        
        return res;
        
    }
}