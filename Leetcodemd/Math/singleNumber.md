<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 1000px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*  Single Number I
Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

Example
Given [1,2,2,1,3,4,3], return 4

Challenge 
One-pass, constant extra space.
*/
/* 知识点：bitwise XOR ^
1.	if(A == B) {
		A ^ B = 0;
	}

2.	0 ^ A = A
*/
    /**
      *@param A : an integer array
      *return : a integer 
      */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>




public class Solution {
    public int singleNumber(int[] A) {
        // Write your code here
        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            ans ^= A[i];
        }
        return ans;
    }
}</code></pre>
</div>
</div>
