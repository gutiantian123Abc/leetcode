<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 646. Maximum Length of Pair Chain
https://leetcode.com/problems/maximum-length-of-pair-chain/description/

You are given an array of n pairs pairs 
where pairs[i] = [lefti, righti] and lefti < righti.

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. 
A chain of pairs can be formed in this fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. 
You can select pairs in any order.


Example 1:

Input: pairs = [[1,2],[2,3],[3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4].
Example 2:

Input: pairs = [[1,2],[7,8],[4,5]]
Output: 3
Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
 

Constraints:

n == pairs.length
1 <= n <= 1000
-1000 <= lefti < righti <= 1000
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length, len = 1, p1 = 0, p2 = 1;
        Arrays.sort(pairs, (a, b) -> {
            return a[1] - b[1];
        });

        while(p2 < n) {
            int[] pair1 = pairs[p1];
            
            while(p2 < n && pairs[p2][0] <= pair1[1]) {
                p2++;
            }

            if(p2 < n && pairs[p2][0] > pair1[0]) {
                len++;
                p1 = p2;
            }
        }

        return len;
    }
}</code></pre>
</div>
</div>
