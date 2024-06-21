<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 500px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 

https://leetcode.com/problems/knight-dialer/

935. Knight Dialer


The chess knight has a unique movement, it may move two squares vertically and one square horizontally, 
or two squares horizontally and one square vertically (with both forming the shape of an L). 
The possible movements of chess knight are shown in this diagaram:

A chess knight can move as indicated in the chess diagram below:


We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).


Given an integer n, return how many distinct phone numbers of length n we can dial.

You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps 
to dial a number of length n. All jumps should be valid knight jumps.

As the answer may be very large, return the answer modulo 109 + 7.

 

Example 1:

Input: n = 1
Output: 10
Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is sufficient.
Example 2:

Input: n = 2
Output: 20
Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
Example 3:

Input: n = 3131
Output: 136006598
Explanation: Please take care of the mod.
 

Constraints:

1 <= n <= 5000
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    private static final int MOD = 1000000007;
    public long[][][] dp;
    public int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    public int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public int knightDialer(int n) {
        initBoard(n);

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (isValid(i, j)) {
                        for (int dir = 0; dir < 8; dir++) {
                            int nx = i + dx[dir];
                            int ny = j + dy[dir];
                            if (isValid(nx, ny)) {
                                dp[i][j][len] = (dp[i][j][len] + dp[nx][ny][len - 1]) % MOD;
                            }
                        }
                    }
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (isValid(i, j)) {
                    ans = (ans + dp[i][j][n]) % MOD;
                }
            }
        }

        return (int) ans;
    }

    private void initBoard(int n) {
        this.dp = new long[4][3][n + 1];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (isValid(i, j)) {
                    dp[i][j][1] = 1;
                }
            }
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 3 && !(x == 0 && y == 0) && !(x == 0 && y == 2);
    }
}
</code></pre>
</div>
</div>
