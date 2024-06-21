<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 50%; margin: auto; padding: 20px; }
  .comment-block { max-width: 50%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume NO duplicates in the array.

Example
[1,3,5,6], 5 → 2

[1,3,5,6], 2 → 1

[1,3,5,6], 7 → 4

[1,3,5,6], 0 → 0

*/
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A.length < 1) {
            return 0;
        }
        int start = 0, end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(target < A[mid]) {
                end = mid;
            }else if(target > A[mid]) {
                start = mid;
            }else{
                return mid;
            }
        }
        if(target <= A[start]) {
            return start;
        }else if(target <= A[end]) {
            return end;
        }else{
            return end + 1;
        }
    }
}
</code></pre>
</div>
</div>
