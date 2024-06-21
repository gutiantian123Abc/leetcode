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
/* 973. K Closest Points to Origin

https://leetcode.com/problems/k-closest-points-to-origin/

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, 
return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 

Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.

*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                long dis1 = (p1[0])*(p1[0]) + (p1[1])*(p1[1]);
                long dis2 = (p2[0])*(p2[0]) + (p2[1])*(p2[1]);
                return (int)(dis2 - dis1);
            }
        });
        
        
        for(int[] p : points) {
            pq.add(p);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        
        return ans;
    }
}</code></pre>
</div>
</div>
