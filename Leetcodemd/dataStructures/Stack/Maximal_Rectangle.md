<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 50px auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Maximal Rectangle
https://www.lintcode.com/problem/maximal-rectangle/description?_from=ladder&&fromId=4

Description
Given a 2D boolean matrix filled with False and True, 
find the largest rectangle containing all True and return its area.

Have you met this question in a real interview?  
Example
Given a matrix:

[
  [1, 1, 0, 0, 1],
  [0, 1, 0, 0, 1],
  [0, 0, 1, 1, 1],
  [0, 0, 1, 1, 1],
  [0, 0, 0, 0, 1]
]
return 6.
*/
    /**
     * @param matrix: a boolean 2D matrix
     * @return: an integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int maximalRectangle(boolean[][] matrix) {
        // write your code here
        
        if(matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] height = new int[row][col];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                    if(matrix[i][j] == false) {
                        height[i][j] = 0;
                    }else {
                        height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                    }
            }
        }
        
        int max = 0;
        
        for(int i = 0; i < row; i++) {
                max = Math.max(max, maxHis(height[i]));
        }
        
        return max;
    }
    
    
    //Largest_Rectangle_in_Histogram.java
    private int maxHis(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i <= height.length; i++) {//为了使得最后一块板子也被处理，这里用了个小trick，在高度数组最后面加上一个0
            int curt = i == height.length ? 0 : height[i];
            
            while(!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : curt == h ? i - stack.peek() : i - stack.peek() - 1; //处理相等的情况
                max = Math.max(h * w, max);
            }
            
            stack.push(i);//Stack 里只放递增值， 相等也不放
        }
        
        return max;
    }
}</code></pre>
</div>
</div>
