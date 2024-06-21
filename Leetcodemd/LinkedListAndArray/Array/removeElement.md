<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container {{ max-width: 100%; margin: 0 auto; padding: 10px; }}
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 
Part 1:
Given an array and a value, remove all occurrences of that value in place and return the new length.

The order of elements can be changed, and the elements after the new length don't matter.

Given an array [0,4,4,0,0,2,4,4], value=4

return 4 and front four elements of the array is [0,0,0,2]
*/
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
/* 
Part 2:

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].

*/
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null) {
            return 0;
        }
        int size = 0, i = 0, j = 0;
        for(i = 0; i < nums.length;) {
            int now = nums[i];
            for(j = i; j < nums.length; j++) {
                if(nums[j] != now) {
                    break;
                }else {
                    if(j == i) {
                        nums[size++] = now;
                    }
                }
            }
            i = j;
        }
        return size;
    }
}







public class Solution {
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null) {
            return 0;
        }
        
        int i, j, size = 0;
        for(i = 0; i < nums.length;) {
            int now = nums[i];
            for(j = i; j < nums.length; j++) {
                if(nums[j] != now) {
                    break;
                }else {
                    if(j - i < 2) {
                        nums[size++] = nums[j];
                    }
                }              
            }        
            i = j;  
        }
        return size; 
    }
}</code></pre>
</div>
</div>
