<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Largest Plus Sign
In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, 
except those cells in the given list mines which are 0. 
What is the largest axis-aligned plus sign of 1s contained in the grid? 
Return the order of the plus sign. If there is none, return 0.

An "axis-aligned plus sign of 1s of order k" has some center 
grid[x][y] = 1 along with 4 arms of length k-1 going up, down, left, 
and right, and made of 1s. This is demonstrated in the diagrams below. 
Note that there could be 0s or 1s beyond the arms of the plus sign, 
only the relevant area of the plus sign is checked for 1s.

Examples of Axis-Aligned Plus Signs of Order k:

Order 1:
000
010
000

Order 2:
00000
00100
01110
00100
00000

Order 3:
0000000
0001000
0001000
0111110
0001000
0001000
0000000
Example 1:

Input: N = 5, mines = [[4, 2]]
Output: 2
Explanation:
11111
11111
11111
11111
11011
In the above grid, the largest plus sign can only be order 2.  
One of them is marked in bold.
Example 2:

Input: N = 2, mines = []
Output: 1
Explanation:
There is no plus sign of order 2, but there is of order 1.
Example 3:

Input: N = 1, mines = [[0, 0]]
Output: 0
Explanation:
There is no plus sign, so return 0.
Note:

N will be an integer in the range [1, 500].
mines will have length at most 5000.
mines[i] will be length 2 and consist of integers in the range [0, N-1].
(Additionally, programs submitted in C, C++, or C# will be judged with a 
slightly smaller time limit.)
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        
        int[][] Mines = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                Mines[i][j] = 1; 
            }
        }
        
        for(int i = 0; i < mines.length; i++) {
            int[] index = mines[i];
            int x = index[0];
            int y = index[1];
            Mines[x][y] = 0;
        }
            
        int[][] left = getLeft(Mines, N);
        int[][] right = getRight(Mines, N);
        int[][] up = getUp(Mines, N);
        int[][] bottom = getBottom(Mines, N);
        
        int Max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int length = Math.min(Math.min(Math.min(left[i][j], right[i][j]), up[i][j]), bottom[i][j]);
                Max = Math.max(length, Max);
            }
        }
        
        return Max;
    }
    
    private int[][] getLeft(int[][] Mines, int N) {
  
        int[][] left = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(j == 0) {
                    left[i][j] = Mines[i][j];
                }else {
                    if(Mines[i][j] == 0) {
                        left[i][j] = 0; 
                    }else {
                        left[i][j] = 1 + left[i][j - 1];
                    }
                }   
            }   
        }
        return left;   
    }
    
    private int[][] getRight(int[][] Mines, int N) {
        
        int[][] right = new int[N][N];
 
        for(int i = 0; i < N; i++) {
            for(int j = N - 1; j >= 0; j--) {
                if(j == N - 1) {
                    right[i][j] = Mines[i][j];
                }else {
                    if(Mines[i][j] == 0) {
                        right[i][j] = 0;
                    }else {
                        right[i][j] = 1 + right[i][j + 1];
                    }
                }   
            }   
        }
        return right;
    }
    
    private int[][] getUp(int[][] Mines, int N) {

        int[][] up = new int[N][N];
 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == 0) {
                    up[i][j] = Mines[i][j];
                }else {
                    if(Mines[i][j] == 0) {
                        up[i][j] = 0;
                    }else {
                        up[i][j] = 1 + up[i - 1][j];
                    }
                }   
            }   
        }
        return up;        
    }
    
    private int[][] getBottom(int[][] Mines, int N) {
        int[][] bottom = new int[N][N];
        for(int i = N - 1; i >= 0; i--) {
            for(int j = 0; j < N; j++) {
                if(i == N - 1) {
                    bottom[i][j] = Mines[i][j];
                }else {
                    if(Mines[i][j] == 0) {
                        bottom[i][j] = 0;
                    }else {
                        bottom[i][j] = 1 + bottom[i + 1][j];
                    }
                }   
            }   
        }
        return bottom;
    }
}</code></pre>
</div>
</div>
