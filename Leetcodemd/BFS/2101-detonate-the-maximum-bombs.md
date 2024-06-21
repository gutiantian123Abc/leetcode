<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 744px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 2101. Detonate the Maximum Bombs
https://leetcode.com/problems/detonate-the-maximum-bombs/description/

You are given a list of bombs. The range of a bomb is defined as 
the area where its effect can be felt. This area is in the shape 
of a circle with the center as the location of the bomb.

The bombs are represented by a 0-indexed 2D integer array bombs 
where bombs[i] = [xi, yi, ri]. xi and yi denote the X-coordinate 
and Y-coordinate of the location of the ith bomb, whereas ri 
denotes the radius of its range.

You may choose to detonate a single bomb. When a bomb is detonated, 
it will detonate all bombs that lie in its range. 
These bombs will further detonate the bombs that lie in their ranges.

Given the list of bombs, return the maximum number of bombs that 
can be detonated if you are allowed to detonate only one bomb.

 

Example 1:
Input: bombs = [[2,1,3],[6,1,4]]
Output: 2
Explanation:
The above figure shows the positions and ranges of the 2 bombs.
If we detonate the left bomb, the right bomb will not be affected.
But if we detonate the right bomb, both bombs will be detonated.
So the maximum bombs that can be detonated is max(1, 2) = 2.


Example 2:
Input: bombs = [[1,1,5],[10,10,5]]
Output: 1
Explanation:
Detonating either bomb will not detonate the other bomb, 
so the maximum number of bombs that can be detonated is 1.


Example 3:
Input: bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
Output: 5
Explanation:
The best bomb to detonate is bomb 0 because:
- Bomb 0 detonates bombs 1 and 2. The red circle denotes the range of bomb 0.
- Bomb 2 detonates bomb 3. The blue circle denotes the range of bomb 2.
- Bomb 3 detonates bomb 4. The green circle denotes the range of bomb 3.
Thus all 5 bombs are detonated.
 

Constraints:

1 <= bombs.length <= 100
bombs[i].length == 3
1 <= xi, yi, ri <= 105

*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = buildGraph(bombs);

        int maxNum = 0;

        for(int i = 0; i < bombs.length; i++) {
            maxNum = Math.max(maxNum, bfs(graph, i, bombs.length));
        }

        return maxNum;
    }

    private int bfs(Map<Integer, List<Integer>> graph, int start, int n) {
        int firedNum = 0;
        boolean[] v = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        v[start] = true; // Mark firing bomb as visited when adding
                        // Must mark here on adding to queue, not when poll()

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int curBomb = queue.poll();
                firedNum++;
                List<Integer> neighbors = graph.get(curBomb);
                for(Integer neighbor : neighbors) {
                    if(!v[neighbor]) {
                        queue.add(neighbor);
                        v[neighbor] = true;// Mark firing when adding to the queue
                        // Must mark here on adding to queue, not when poll()

                    }
                }
            }
        }

        return firedNum;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < bombs.length; i++) {
            graph.put(i, new ArrayList<Integer>());
            for(int j = 0; j < bombs.length; j++) {
                if(j != i && inRange(bombs[i], bombs[j])) {
                    graph.get(i).add(j);
                }
            }
        }

        return graph;
    }

    private boolean inRange(int[] bomb1, int[] bomb2) {
        long x1 = bomb1[0], y1 = bomb1[1], r = bomb1[2];
        long x2 = bomb2[0], y2 = bomb2[1];
        long diffx = x1 - x2, diffy = y1 - y2;
        return diffx * diffx + diffy * diffy <= r * r;
    }
}</code></pre>
</div>
</div>
