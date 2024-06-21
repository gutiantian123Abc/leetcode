<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Data Stream Median
Numbers keep coming, return the median of numbers at every time a new number added.

Clarification
What's the definition of Median?
- Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.

Example
For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

For numbers coming list: [2, 20, 100], return [2, 2, 20].

Challenge 
Total run time in O(nlogn).
*/
/* 解题注释： 这道题是找寻动态数组中位数， 用PQ做好， PQ O(logn)插入， 查找O(1), 总共O(nlogn)
如果这道题是静态的数组， 那中位数最好用quick select top k smallest. O(n)
*/
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


public class Solution {
    private int numElement = 0;
    private Comparator<Integer> minComparator= new Comparator<Integer>() { //minheap, 记住， top ... largest //就用 minheap, smallest 就用maxheap
        public int compare(Integer a, Integer b) {
            if(a > b) {
                return 1;
            }else if(a < b) {
                return -1;
            }else {
               return 0;
            }
        }
    };
    
    private Comparator<Integer> maxComparator= new Comparator<Integer>() { //minheap, 记住， top ... largest //就用 minheap, smallest 就用maxheap
        public int compare(Integer a, Integer b) {
            if(a > b) {
                return -1;
            }else if(a < b) {
                return 1;
            }else {
               return 0;
            }
        }
    };
    
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public int[] medianII(int[] nums) {
        // write your code here
        int n = nums.length;
        maxHeap = new PriorityQueue<Integer>(n, maxComparator);
        minHeap = new PriorityQueue<Integer>(n, minComparator);
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            addNum(nums[i]);
            result[i] = getMedian();
        }
        
        return result;
    }
    
    private void addNum(int num) {
        if(maxHeap.size() == minHeap.size()) {
            maxHeap.offer(num);
            if(minHeap.size() == 0) {
                return;
            }else {
                transit(maxHeap, minHeap);
            }
        }else if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(num);
            transit(maxHeap, minHeap);
        }
        else { //maxHeap.size() > minHeap.size()
            minHeap.offer(num);
            transit(maxHeap, minHeap);
        }
    }
    
    private void transit(PriorityQueue<Integer> maxheap, PriorityQueue<Integer> minheap) { //俩PriorityQueue求median倒腾
        if(maxHeap.peek() > minHeap.peek()) {
            Integer maxPeek = maxHeap.poll();
            Integer minPeek = minHeap.poll();
            maxHeap.offer(minPeek);
            minHeap.offer(maxPeek);
        }
    }
    
    
    private int getMedian() {
        return maxHeap.peek();
    }
}</code></pre>
</div>
</div>
