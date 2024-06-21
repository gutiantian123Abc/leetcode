<style>
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Maximal Square
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

Example
For example, given the following matrix:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/
/* Idea:
Well, this problem desires for the use of dynamic programming. 
They key to any DP problem is to come up with the state equation. 
In this problem, we define the state to be the maximal size of the square that can be achieved at point (i, j),
denoted as res[i][j]. Remember that we use size instead of square as the state (square = size^2).
Now let's try to come up with the formula for res[i][j].
First, it is obvious that for the topmost row (i = 0) and the leftmost column (j = 0), 
res[i][j] = matrix[i][j]. This is easily understood. 
Let's suppose that the topmost row of matrix is like [1, 0, 0, 1]. 
Then we can immediately know that the first and last point can be a square of size 1 while the two middle points cannot make any square, giving a size of 0. 
Thus, res = [1, 0, 0, 1], which is the same as matrix. The case is similar for the leftmost column. 
Till now, the boundary conditions of this DP problem are solved.
Let's move to the more general case for res[i][j] in which i > 0 and j > 0. 
First of all, let's see another simple case in which matrix[i][j] = 0. It is obvious that res[i][j] = 0 too.
Why? Well, since matrix[i][j] = 0, no square will contain matrix[i][j]. 
According to our definition of res[i][j], res[i][j] is also 0.
Now we are almost done. The only unsolved case is matrix[i][j] = 1. Let's see an example.
Suppose matrix = [[0, 1], [1, 1]], it is obvious that res[0][0] = 0, res[0][1] = res[1][0] = 1, 
what about res[1][1]? Well, to give a square of size larger than 1 in res[1][1], all of its three neighbors (left, up, left-up) should be non-zero, right? 
In this case, the left-up neighbor res[0][0] = 0, so res[1][1] can only be 1, which means that it contains the square of itself.

Now you are near the solution. In fact, res[i][j] = min(res[i - 1][j], res[i][j - 1], res[i - 1][j - 1]) + 1 in this case.

Taking all these together, we have the following state equations.

res[0][j] = matrix[0][j] (topmost row);
res[i][0] = matrix[i][0] (leftmost column);
For i > 0 and j > 0: if matrix[i][j] = 0, res[i][j] = 0; if matrix[i][j] = 1, res[i][j] = min(res[i - 1][j], res[i][j - 1], res[i - 1][j - 1]) + 1.
*/
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>




public class Solution {
    public int maxSquare(int[][] matrix) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        
        //Initialize
        for(int i = 0; i < m; i++) {
            res[i][0] = matrix[i][0] == 1 ? 1 : 0;
            ans = Math.max(res[i][0], ans);
        }
        
        for(int j = 0; j < n; j++) {
            res[0][j] = matrix[0][j] == 1 ? 1 : 0;
            ans = Math.max(res[0][j], ans);
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 1) {
                    res[i][j] = 1 + Math.min(res[i - 1][j], Math.min(res[i][j - 1], res[i - 1][j - 1]));
                }else{
                    
                }
                ans = Math.max(ans, res[i][j]);
            }
        }
        
        return ans * ans;
    }
}





</code></pre>
</div>
