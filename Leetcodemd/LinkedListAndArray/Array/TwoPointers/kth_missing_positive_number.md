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
/* 1539. Kth Missing Positive Number
https://leetcode.com/problems/kth-missing-positive-number/
Given an array arr of positive integers sorted in a strictly increasing order,
and an integer k.
Find the kth positive integer that is missing from this array.
Example 1:
Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...].
The 5th missing positive integer is 9.
Example 2:
Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...].
The 2nd missing positive integer is 6.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int p = 0;
        for(int i = 1; i < Integer.MAX_VALUE; i++) {
            if(p < arr.length) {
                if(i != arr[p]) {
                    k--;
                }else {
                    p++;
                }
            }else {
                k--;
            }
            
            if(k == 0) {
                return i;
            }

        }
        
        return 0;
        
    }
}</code></pre>
</div>
</div>
