<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 700px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Distinct Subsequences
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from 
the original string by deleting some (can be none) 
of the characters without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example
Given S = "rabbbit", T = "rabbit", return 3.
Challenge 
Do it in O(n2) time and O(n) memory.
O(n2) memory is also acceptable if you do not know how to optimize memory.
*/
/* Tutorial:
 遇到这种两个串的问题，很容易想到DP。但是这道题的递推关系不明显。可以先尝试做一个二维的表int[][] dp，用来记录匹配子序列的个数（以S ="rabbbit",T = "rabbit"为例）：

   "" r a b b b i t (S)

"" 1  1 1 1 1 1 1 1

r  0  1 1 1 1 1 1 1

a  0  0 1 1 1 1 1 1

b  0  0 0 1 2 3 3 3

b  0  0 0 0 1 3 3 3

i  0  0 0 0 0 0 3 3

t  0  0 0 0 0 0 0 3  

(T)

从这个表可以看出，无论T的字符与S的字符是否匹配，dp[i][j] = dp[i][j - 1].就是说，假设S已经匹配了j - 1个字符，得到匹配个数为dp[i][j - 1].现在无论S[j]是不是和T[i]匹配，匹配的个数至少是dp[i][j - 1]。除此之外，当S[j]和T[i]相等时，我们可以让S[j]和T[i]匹配，然后让S[j - 1]和T[i - 1]去匹配。所以递推关系为：

dp[0][0] = 1; // T和S都是空串.

dp[0][1 ... S.length() - 1] = 1; // T是空串，S只有一种子序列匹配。

dp[1 ... T.length() - 1][0] = 0; // S是空串，T不是空串，S没有子序列匹配。

dp[i][j] = dp[i][j - 1] + (T[i - 1] == S[j - 1] ? dp[i - 1][j - 1] : 0).1 <= i <= T.length(), 1 <= j <= S.length()

这道题可以作为两个字符串DP的典型：!!!!!

两个字符串：

先创建二维数组存放答案，如解法数量 ！！！注意二维数组的长度要比原来字符串长度+1，因为要考虑第一个位置是空字符串。

然后考虑dp[i][j]和dp[i-1][j],dp[i][j-1],dp[i-1][j-1]的关系，

如何通过判断S.charAt(i)和T.charAt(j)的是否相等来看看如果移除了最后两个字符，能不能把问题转化到子问题。

最后问题的答案就是dp[S.length()][T.length()]

还有就是要注意通过填表来找规律。
*/
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>



public class Solution {
    public int numDistinct(String S, String T) {
        // write your code here
        if (S == null || T == null) {
            return 0;
        }
        int[][] nums = new int[T.length() + 1][S.length() + 1];
        for(int j = 0; j < nums[0].length; j++) {
            nums[0][j] = 1;
        }
        
        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j < nums[0].length; j++) {
                if(T.charAt(i - 1) == S.charAt(j - 1)) {
                    nums[i][j] = nums[i - 1][j - 1] + nums[i][j - 1];
                }else {
                    nums[i][j] = nums[i][j - 1];
                }
            }
        }
        
        return nums[T.length()][S.length()];
    }
}</code></pre>
</div>
</div>
