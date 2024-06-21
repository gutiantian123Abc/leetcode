<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Android Unlock Patterns
Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤
9,
count the total number of unlock patterns of the Android lock screen, which
consist of minimum of m keys and maximum n keys.
Rules for a valid pattern:
Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any
other keys,
the other keys must have previously selected in the pattern. No jumps through
non selected key is allowed.
The order of keys used matters.
Explanation:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6
Line 1 - 3 passes through key 2 which had not been selected in the pattern.
Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.
Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in
the pattern
Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in
the pattern.
Example:
Given m = 1, n = 1, return 9.
注意， 1， 8 中间算没有点，1， 6 也一样
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int numberOfPatterns(int m, int n) {
        int skip[][] = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        int len = 0;
        boolean[] v = new boolean[10];
        int count = 0;  
        for(int remain = m; remain <= n; remain++) {
            for(int start = 1; start <= 9; start++) {
                count += dfs(skip, start, remain, v);
            }
        }
        return count;
    }
    
    
    private int dfs(int[][] skip, int start, int remain, boolean[] v) {
        if(v[start]) {
            return 0;
        }
        
        if(remain == 1) { //注意边界问题
            return 1;
        }
        
        v[start] = true;
        int count = 0;
        for(int next = 1; next <= 9; next++) {
            if(skip[start][next] == 0 || skip[start][next] != 0 && v[skip[start][next]]) {
                count += dfs(skip, next, remain - 1, v);
            }
        }
        
        v[start] = false;
        return count;
    }
}</code></pre>
</div>
</div>
