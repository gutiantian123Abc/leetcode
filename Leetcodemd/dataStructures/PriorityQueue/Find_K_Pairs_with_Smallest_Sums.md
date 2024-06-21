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
/* Find K Pairs with Smallest Sums
You are given two integer arrays nums1 and nums2 sorted in ascending order and
an integer k.
Define a pair (u,v) which consists of one element from the first array and one
element from the second array.
Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
Example 1:
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence:
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence:
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
Original Question: https://leetcode.com/problems/find-k-pairs-with-smallest-
sums/description/
Solution: https://leetcode.com/problems/find-k-pairs-with-smallest-
sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public class Pair {
        int a;
        int b;
        int id1;
        int id2;
        
        public Pair(int a, int b, int id1, int id2) {
            this.a = a;
            this.b = b;
            this.id1 = id1;
            this.id2 = id2;
        }
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0) {
            return res;
        }
        
        //Always pop out minimum
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new Comparator<Pair>() {
            public int compare(Pair A, Pair B) {
                return (A.a + A.b) - (B.a + B.b);
            }
        });
        
        for(int i = 0; i < k && i < nums1.length; i++) {
            pq.offer(new Pair(nums1[i], nums2[0], i, 0));
        }
        
        int count = 0;
        while(count < k && !pq.isEmpty()) {
            Pair pair = pq.poll();
            int id1 = pair.id1;
            int id2 = pair.id2;
            res.add(new int[]{pair.a, pair.b});
            if(id2 < nums2.length - 1) {
                pq.offer(new Pair(pair.a, nums2[id2 + 1], id1, id2 + 1));
            }
            count++;
        }
        
        return res;

    }
}
</code></pre>
</div>
</div>
