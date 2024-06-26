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
/* The Skyline Problem
A city's skyline is the outer contour of the
silhouette formed by all the buildings in that
city when viewed from a distance.
Now suppose you are given the locations and height
of all the buildings as shown on a cityscape photo
(Figure A),
write a program to output the skyline formed by
these buildings collectively (Figure B).
Buildings  Skyline Contour
The geometric information of each building is
represented by a triplet of integers [Li, Ri, Hi],
where Li and Ri are the x coordinates of the left
and right edge of the ith building, respectively,
and Hi is its height. It is guaranteed that 0 ≤
Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li >
0.
You may assume all buildings are perfect
rectangles grounded on an absolutely flat surface
at height 0.
For instance, the dimensions of all buildings in
Figure A are recorded as: [ [2 9 10], [3 7 15], [5
12 12], [15 20 10], [19 24 8] ] .
The output is a list of "key points" (red dots in
Figure B) in the format of [ [x1,y1], [x2, y2],
[x3, y3], ... ]
 that uniquely defines a skyline. A key point is
the left endpoint of a horizontal line segment.
 Note that the last key point, where the rightmost
building ends, is merely used to mark the
termination of the skyline,
 and always has zero height. Also, the ground in
between any two adjacent buildings should be
considered part of the skyline contour.
For instance, the skyline in Figure B should be
represented as:[ [2 10], [3 15], [7 12], [12 0],
[15 10], [20 8], [24, 0] ].
Notes:
The number of buildings in any input list is
guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending
order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of
equal height in the output skyline.
For instance, [...[2 3], [4 5], [7 5], [11 5], [12
7]...] is not acceptable; the three lines of
height 5 should be merged
into one in the final output as such: [...[2 3],
[4 5], [12 7], ...]
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//讲解： https://blog.csdn.net/whdAlive/article/details/81152670   
// https://www.youtube.com/watch?v=11dq8ux25oE&feature=youtu.be
class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        
        for(int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        
        Collections.sort(heights, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) {
                    return a[0] - b[0];
                }else {
                    return a[1] - b[1];
                }
            }
        });
        
        //Max Queue
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        pq.offer(0);
        int prev = 0;
        for(int[] h : heights) {
            //left 
            if(h[1] < 0) {
                pq.offer(-h[1]);
            }else { //right
                pq.remove(h[1]);
            }
            
            int cur = pq.peek();
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        
        return result;   
    }
}</code></pre>
</div>
</div>
