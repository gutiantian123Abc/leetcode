<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Spiral Matrix I
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example
Given the following matrix:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
/*Spiral Matrix II
Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.

Example
Given n = 3,

You should return the following matrix:

[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]
*/
    /**
     * @param n an integer
     * @return a square matrix
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse Right
            for (int j = left; j <= right; j ++) {
                res.add(matrix[top][j]);
            }
            top++;
            
            // Traverse Down
            for (int j = top; j <= bottom; j ++) {
                res.add(matrix[j][right]);
            }
            right--;
            
            if (top <= bottom) {
                // Traverse Left
                for (int j = right; j >= left; j --) {
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }else {
                break;
            }
                
            if (left <= right) {
                // Traver Up
                for (int j = bottom; j >= top; j --) {
                    res.add(matrix[j][left]);
                }
                left ++;
            }else {
                break;
            }
            
        }
        return res;
    }
}





public class Solution {
    public int[][] generateMatrix(int n) {
        // Write your code here
        int[][] res = new int[n][n];
        
        int num = 1;
        
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        
        while(top <= bottom && left <= right) {
            for(int j = left; j <= right; j++) {
                res[top][j] = num++;
            }
            top++;
            
            for(int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;
            
            if(top <= bottom) {
                for(int j = right; j >= left; j--) {
                    res[bottom][j] = num++;
                }
                bottom--;
            }else {
                break;
            }
            
            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    res[i][left] = num++;
                }
                left++;
            }else{
                break;
            }
        }
        return res;
    }
}

















</code></pre>
</div>
</div>
