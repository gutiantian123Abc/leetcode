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
/* Rotate Image
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Example
Given a matrix
[
    [1,2],
    [3,4]
]
rotate it by 90 degrees (clockwise), return
[
    [3,1],
    [4,2]
]
*/
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
/*
The idea was firstly transpose the matrix and then flip it symmetrically. For
instance,
1  2  3
4  5  6
7  8  9
after transpose, it will be swap(matrix[i][j], matrix[j][i])
1  4  7
2  5  8
3  6  9
Then flip the matrix horizontally. (swap(matrix[i][j],
matrix[i][matrix.length-1-j])
7  4  1
8  5  2
9  6  3
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public void rotate(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int length = matrix.length;
         // Square Transpose !!!!!!!!!!!!!!
         for(int i = 0; i < length; i++) {
             for(int j = i; j < length; j++) {
                 int tmp = matrix[i][j];
                 matrix[i][j] = matrix[j][i];
                 matrix[j][i] = tmp;
             }
         }
         
         //Rectangle flip left right
         for(int i = 0; i < length; i++) {
             for(int j = 0; j < length / 2; j++) {
                 int tmp = matrix[i][j];
                 matrix[i][j] = matrix[i][length - 1 - j];
                 matrix[i][length - 1 - j] = tmp;
             }
         }
    }
}
</code></pre>
</div>
</div>
