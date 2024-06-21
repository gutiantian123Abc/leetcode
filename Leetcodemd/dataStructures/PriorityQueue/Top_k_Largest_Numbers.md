<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Top k Largest Numbers
Given an integer array, find the top k largest numbers in it.

Have you met this question in a real interview? Yes
Example
Given [3,10,1000,-99,4,100] and k = 3.
Return [1000, 100, 10].这道题的另一种方法是QuickSort(nlogn), 但显然没有PQ好(O(n). S(k))
*/
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int[] topk(int[] nums, int k) {
        // Write your code here
        //PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(k, new Comparator<Integer>(){ //注意如何写Comparator
            public int compare(Integer a1, Integer a2) {//minheap
                if(a1 > a2) {//minheap
                    return 1;
                }else if(a1 < a2) {//minheap
                    return -1;
                }else {//minheap
                    return 0;
                }
            }
        });
        
        for(int i = 0; i < nums.length; i++) { //注意这里的PQ如何处理的
            maxheap.add(nums[i]);
            if(maxheap.size() > k) {
                maxheap.poll();
            }
        }
        
        
        int[] result = new int[k];
        //注意， 一定是从后往前注入
        for(int i = k - 1; i >= 0; i--) {
            result[i] = maxheap.poll();
        }
        
        return result;
    }
};
</code></pre>
</div>
</div>
