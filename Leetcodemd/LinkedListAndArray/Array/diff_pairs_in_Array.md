<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* K-diff Pairs in an Array
Given an array of integers and an integer k, you need to find the number of unique 
k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), 
where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
*/
                /*
                if(map.containsKey(entry.getKey() - k)) { //不能加， 会重复
                    count++;
                }     
                */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length < 1 || k < 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }
        
        int count = 0;
        if(k == 0) {
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() >= 2) {
                    count++;
                }
            }
        }else {
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) { 
                if(map.containsKey(entry.getKey() + k)) {
                    count++;
                }
                
            }
        }
        
           return count;
    }
}</code></pre>
</div>
</div>
