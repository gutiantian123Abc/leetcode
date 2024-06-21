<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 2013. Detect Squares

https://leetcode.com/problems/detect-squares/


You are given a stream of points on the X-Y plane. Design an algorithm that:

Adds new points from the stream into a data structure. 
Duplicate points are allowed and should be treated as different points.
Given a query point, counts the number of ways to choose three points from 
the data structure such that the three points and the query point form an axis-aligned 
square with positive area.

An axis-aligned square is a square whose edges are all the same length and are 
either parallel or perpendicular to the x-axis and y-axis.

Implement the DetectSquares class:

DetectSquares() Initializes the object with an empty data structure.
void add(int[] point) Adds a new point point = [x, y] to the data structure.
int count(int[] point) Counts the number of ways to form axis-aligned squares 
with point point = [x, y] as described above.
 

Example 1:


Input
["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
[[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
Output
[null, null, null, null, 1, 0, null, 2]

Explanation
DetectSquares detectSquares = new DetectSquares();
detectSquares.add([3, 10]);
detectSquares.add([11, 2]);
detectSquares.add([3, 2]);
detectSquares.count([11, 10]); // return 1. You can choose:
                               //   - The first, second, and third points
detectSquares.count([14, 8]);  // return 0. The query point cannot form a square with any points 
in the data structure.
detectSquares.add([11, 2]);    // Adding duplicate points is allowed.
detectSquares.count([11, 10]); // return 2. You can choose:
                               //   - The first, second, and third points
                               //   - The first, third, and fourth points
 

Constraints:

point.length == 2
0 <= x, y <= 1000
At most 3000 calls in total will be made to add and count.
*/
/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class DetectSquares {
    public Map<String, Integer> countMap;

    public DetectSquares() {
        countMap = new HashMap<>();
    }
    
    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        if(!countMap.containsKey(key)) {
            countMap.put(key, 0);
        }
        countMap.put(key, countMap.get(key) + 1);
    }
    
    public int count(int[] point) {
        int count = 0, x1 = point[0], y1 = point[1];

        for(String p3 : countMap.keySet()) {
            int x3 = Integer.parseInt(p3.split(",")[0]);
            int y3 = Integer.parseInt(p3.split(",")[1]);
            if(validDiagnal(x1, y1, x3, y3)) {
                String p2 = x3 + "," + y1;
                String p4 = x1 + "," + y3;
                if(countMap.containsKey(p2) && countMap.containsKey(p4)) {
                    int p3Count = countMap.get(p3);
                    int p2Count = countMap.get(p2);
                    int p4Count = countMap.get(p4);

                    count += p3Count * p2Count * p4Count;
                }
            }
        }

        return count;     
    }

    public boolean validDiagnal(int x1, int y1, int x3, int y3) {
        return !(x1 == x3 && y1 == y3) && Math.abs(y3 - y1) == Math.abs(x3 - x1);
    }
}

</code></pre>
</div>
</div>
