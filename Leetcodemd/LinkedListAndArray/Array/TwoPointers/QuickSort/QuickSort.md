<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 400px; margin: 50px; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 50px; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Quick Sort
*/
    /**
     * @param A an integer array
     * @return void
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int start, int end) {

        if (start >= end) {//记住， quicksort 这里一定是 start >= end; 对比quickselect: if(start == end) {return nums[start]}
            return;
        }
        
        int i = start, j = end;
        // key point 1: pivot is the value, not the index
        int pivot = A[(start + end) / 2];

        // key point 2: every time you compare left & right, it should be 
        // left <= right not left < right
        while (i <= j) {
            // key point 3: A[left] < pivot not A[left] <= pivot
            while (i <= j && A[i] < pivot) {
                i++;
            }
            // key point 3: A[right] > pivot not A[right] >= pivot
            while (i <= j && A[j] > pivot) {
                j--;
            }

            if (i <= j) {
            	swap(nums, i, j);
                i++;
                j--;
            }
        }
        
         //最终的结果：   start ****************** j (0 或 1 个数) i ********************** end
        quickSort(A, start, j);
        quickSort(A, i, end);
    }


    private void swap(int[] nums, int a, int b) {
    	int tmp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = tmp;
    }
}</code></pre>
</div>
</div>
