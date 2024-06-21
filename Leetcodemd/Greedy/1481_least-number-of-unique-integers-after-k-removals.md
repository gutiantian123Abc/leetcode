<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 600px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*
https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

Given an array of integers arr and an integer k. 
Find the least number of unique integers after removing exactly k elements.

 

Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.
Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 
1 and 3 will be left.
 

Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9
0 <= k <= arr.length
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>((A, B) -> {
            return A.getValue() - B.getValue();
        });

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if(!map.containsKey(num)) {
                map.put(num, 0);
            }
            //注意， 不管是HashMap 还是 Queue， 如果是<Integer, Integer>, 不能直接
            //改值: 例如： 
            //pair.getValue()++, 必须是 freq++; 
            // pq.add(new Pair<>(num, freq));
            // map 也一样
            map.put(num, map.get(num) + 1);
        }

        for(int num : map.keySet()) {
            int freq = map.get(num);
            pq.add(new Pair<>(num, freq));
        }

        for(int i = 0; i < k; i++) {
            Pair<Integer, Integer> pair = pq.poll();
            int num = pair.getKey();
            int freq = pair.getValue();
            freq--;

            //注意， 不管是HashMap 还是 Queue， 如果是<Integer, Integer>, 不能直接
            //改值: 例如： 
            //pair.getValue()++, 必须是 freq++; 
            // pq.add(new Pair<>(num, freq));
            // map 也一样
            if(freq > 0) {
                pq.add(new Pair<>(num, freq));
            }
        }

        int ret = 0;
        while(!pq.isEmpty()) {
            pq.poll();
            ret++;
        }

        return ret;
        
    }
}</code></pre>
</div>
</div>
