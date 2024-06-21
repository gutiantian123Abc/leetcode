<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* K Closest Points
Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.

Example
Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
return [[1,1],[2,5],[4,4]]
*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public Point global_origin = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {  //maxheap, 记住， top ... largest 就用 minheap, smallest 就用maxheap
        // Write your code here
        global_origin = origin;
        PriorityQueue<Point> maxheap = new PriorityQueue(k, new Comparator<Point>(){
            
            public int compare(Point a1, Point a2) {
                double dis1 = Math.pow(a1.x - global_origin.x, 2) + Math.pow(a1.y - global_origin.y, 2);
                double dis2 = Math.pow(a2.x - global_origin.x, 2) + Math.pow(a2.y - global_origin.y, 2); 
                if(dis1 < dis2) {
                    return 1;
                }else if(dis1 > dis2) {
                    return -1;
                }else {
                    if(a1.x < a2.x) {
                        return 1;
                    }else if(a1.x > a2.x) {
                        return -1;
                    }else {
                        if(a1.y < a2.y) {
                            return 1;
                        }else if(a1.y > a2.y) {
                            return -1;
                        }else {
                            return -1;
                        }
                    }
                }
            }
        });
        
        
        for(Point pt : points) {
            maxheap.add(pt);
            if(maxheap.size() > k) {
                maxheap.poll();
            }
        }
        
        Point[] answer = new Point[k];
        
        for(int i = k - 1; i >= 0; i--) {
            answer[i] = maxheap.poll();
        }
        
        return answer;
        
    }
}</code></pre>
</div>
</div>
