<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 400px; margin: 50px; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 50px; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 2055. Plates Between Candles

https://leetcode.com/problems/plates-between-candles/description/

There is a long table with a line of plates and candles arranged on top of it. 
You are given a 0-indexed string s consisting of characters '*' and '|' only, 
where a '*' represents a plate and a '|' represents a candle.

You are also given a 0-indexed 2D integer array queries where queries[i] = [lefti, righti] 
denotes the substring s[lefti...righti] (inclusive). For each query, you need to find the 
number of plates between candles that are in the substring. A plate is considered between 
candles if there is at least one candle to its left and at least one candle to its right 
in the substring.

For example, s = "||**||**|*", and a query [3, 8] denotes the substring "*||**|". 
The number of plates between candles in this substring is 2, as each of the two plates 
has at least one candle in the substring to its left and right.
Return an integer array answer where answer[i] is the answer to the ith query.

 
Example 1:
Input: s = "**|**|***|", queries = [[2,5],[5,9]]
Output: [2,3]
Explanation:
- queries[0] has two plates between candles.
- queries[1] has three plates between candles.


Example 2:
Input: s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
Output: [9,0,0,0,0]
Explanation:
- queries[0] has nine plates between candles.
- The other queries have zero plates between candles.
 

Constraints:

3 <= s.length <= 105
s consists of '*' and '|' characters.
1 <= queries.length <= 105
queries[i].length == 2
0 <= lefti <= righti < s.length
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prevPlateSum = new int[n];
        int[] rightMostCandleIndes = new int[n];
        int[] leftMostCandleIndes = new int[n];
        int platSum = 0;
        int rightMostCandleIndex = -1;
        int leftMostCandleIndex = -1;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '*') {
                platSum++;
            }
            prevPlateSum[i] = platSum;

            if(c == '|') {
                rightMostCandleIndex = i;
            }

            rightMostCandleIndes[i] = rightMostCandleIndex;
        }

        for(int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if(c == '|') {
                leftMostCandleIndex = i;
            }
        
            leftMostCandleIndes[i] = leftMostCandleIndex;
        }

        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            int leftIndex = leftMostCandleIndes[start];
            int rightIndex = rightMostCandleIndes[end];
            if(leftIndex == -1 || rightIndex == -1 || leftIndex >= rightIndex) {
                ans[i] = 0;
            } else {
                //注意： prevPlateSum[rightIndex] - prevPlateSum[leftIndex - 1]
                ans[i] = prevPlateSum[rightIndex] - (leftIndex == 0 ? 0 : prevPlateSum[leftIndex - 1]);
            }
        }

        return ans;
        
    }
}</code></pre>
</div>
</div>
