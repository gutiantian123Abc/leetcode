<style>
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*
V1:
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Notice
You may assume that A has enough space (size that is greater or equal to m + n) 
to hold additional elements from B. The number of elements initialized in A and B are m and 
n respectively.

Example
A = [1, 2, 3, empty, empty], B = [4, 5]
After merge, A will be filled as [1, 2, 3, 4, 5]
*/
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
/*
V2:
Merge two given sorted integer array A and B into a new sorted integer array.
Example
A=[1,2,3,4]

B=[2,4,5,6]

return [1,2,2,3,4,4,5,6]
*/
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = m - 1, j = n - 1, index = m + n - 1;
        while(i >= 0 && j >= 0) {
            if(A[i] > B[j]) {
                A[index--] = A[i--];
            }else{
                A[index--] = B[j--];
            }
            
        }
        while(i >= 0) {
            A[index--] = A[i--];
        }
        while(j >= 0) {
            A[index--] = B[j--];
        }
    }
}





class Solution {
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        int m = A.length, n = B.length;
        int[] result = new int[m + n];
        int count = m + n - 1;
        int i = m - 1, j = n - 1;
        while(i >= 0 && j >= 0) {
            if(A[i] < B[j]) {
                result[count--] = B[j--];
            }else{
                result[count--] = A[i--];
            } 
        }
        
        while(i >= 0) {
            result[count--] = A[i--];
        }
        
        while(j >= 0) {
            result[count--] = B[j--];
        }

        return result;
    }
}







</code></pre>
</div>
