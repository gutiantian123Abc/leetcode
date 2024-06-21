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
/* 703. Kth Largest Element in a Stream
https://leetcode.com/problems/kth-largest-element-in-a-stream/

Design a class to find the kth largest element in a stream. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 

Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
*/
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class KthLargest {
    public int K = 0;
    public PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        K = k;
        pq = new PriorityQueue<>(K, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if(a > b) {
                    return 1;
                }else if(a < b) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        
        PriorityQueue<Integer> pq2 = pq;
        
        for(int num : nums) {
            add(num);
        }
        
        int a = 0;
        
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > K) {
             pq.poll();
        } 
        return pq.peek();

    }
}

</code></pre>
</div>
</div>
