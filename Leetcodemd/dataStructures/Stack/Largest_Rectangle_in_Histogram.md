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
/* Largest Rectangle in Histogram
https://www.lintcode.com/problem/largest-rectangle-in-histogram/description?_from=ladder&&fromId=4
Description
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.
*/
/* 讲解： 
我们可以看到，直方图矩形面积要最大的话，需要尽可能的使得连续的矩形多，并且最低一块的高度要高。有点像木桶原理一样，
总是最低的那块板子决定桶的装水量。那么既然需要用单调栈来做，首先要考虑到底用递增栈，还是用递减栈来做。
我们想啊，递增栈是维护递增的顺序，当遇到小于栈顶元素的数就开始处理，而递减栈正好相反，维护递减的顺序，当遇到大于栈顶元素的数开始处理。
计算以当前值为高的矩形面积，所以要找到它的左右边界。建立栈，存储当前元素在数组中的位置。
将数组元素一次推入栈中，如果它比栈顶元素小，则栈顶元素的右边界出现了，现在确定他的左边界。
此时将栈顶元素出栈。栈中都是比当前元素小的值，因为比当前值大的都因当前值而出栈，
所以，可以借此确定当前矩形的左边界，如果栈为空，说明当前元素是栈中最小值，左边界就是0。
知道左右边界之后就可以计算面积了，高度是当前值，宽度是 i 或者 i-stack.peek()-1, 或i-stack.peek()(一样大的话)
为了使得最后一块板子也被处理，这里用了个小trick，在高度数组最后面加上一个0，这样原先的最后一个板子也可以被处理了。
*/
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


public class Solution {
    public int largestRectangleArea(int[] height) {
        // write your code here
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
