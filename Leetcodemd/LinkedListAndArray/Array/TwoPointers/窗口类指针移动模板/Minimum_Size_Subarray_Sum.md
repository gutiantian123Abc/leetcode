<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 400px; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Minimum Size Subarray Sum 
Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. 
If there isn't one, return -1 instead.

Example
Given the array [2,3,1,2,4,3] and s = 7, 
the subarray [4,3] has the minimal length under the problem constraint.
O(2n)
*/
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
        /* 窗口类指针移动模板
        int j = 0;

        for(int i = 0; i < nums.length; i++) {

        	while(j < nums.length) {
        		if(满足条件) {
					j++;
					更行j状态
        		}else{
					break;
        		}
        	}

        	更新i状态
        }
        */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int minimumSize(int[] nums, int s) {
        // write your code here

        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int j = 0;
        
        for(int i = 0; i < nums.length; i++) {
            while(j < nums.length) {
                if(sum < s) {
                    sum += nums[j];
                    j++;
                }else {
                    break;
                }
            }
            
            if(sum >= s) {
                ans = Math.min(ans, j - i);
            }
            
            sum -= nums[i];
        }
        
        if(ans == Integer.MAX_VALUE) {
            ans = -1;
        }
           
        return ans;
    }
}</code></pre>
</div>
</div>
