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
/* 939. Minimum Area Rectanglehttps://leetcode.com/problems/minimum-area-rectangle/description/You are given an array of points in the X-Y plane points where points[i] = [xi, yi].Return the minimum area of a rectangle formed from these points,with sides parallel to the X and Y axes. If there is not any such rectangle, return 0.Example 1:Input: points = [[1,1],[1,3],[3,1],[3,3],[2,2]]Output: 4Example 2:Input: points = [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]Output: 2Constraints:1 <= points.length <= 500points[i].length == 20 <= xi, yi <= 4 * 104All the given points are unique.*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return this.x == pair.x && this.y == pair.y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int minAreaRect(int[][] points) {
        Set<Pair> pairSet = new HashSet<>();
        int minArea = Integer.MAX_VALUE;

        for(int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int x = point[0], y = point[1];
            Pair pair = new Pair(x, y);
            pairSet.add(pair);
        }

        for(int i = 0; i < points.length - 1; i++) {
            for(int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];

                if(x1 != x2 && y1 != y2) {
                    if(pairSet.contains(new Pair(x1, y2)) && pairSet.contains(new Pair(x2, y1))) {
                        minArea = Math.min(minArea, Math.abs(x1-x2) * Math.abs(y1 - y2));
                    }
                }
            }
        }

        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}</code></pre>
</div>
</div>
