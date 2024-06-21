<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 1762. Buildings With an Ocean View


https://leetcode.com/problems/buildings-with-an-ocean-view/


There are n buildings in a line. You are given an integer array heights of size n 
that represents the heights of the buildings in the line.

The ocean is to the right of the buildings. A building has an ocean view if the 
building can see the ocean without obstructions. Formally, a building has an ocean 
view if all the buildings to its right have a smaller height.

Return a list of indices (0-indexed) of buildings that have an ocean view, 
sorted in increasing order.


Example 1:

Input: heights = [4,2,3,1]
Output: [0,2,3]
Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.


Example 2:

Input: heights = [4,3,2,1]
Output: [0,1,2,3]
Explanation: All the buildings have an ocean view.


Example 3:

Input: heights = [1,3,2,4]
Output: [3]
Explanation: Only building 3 has an ocean view.
 

Constraints:

1 <= heights.length <= 105
1 <= heights[i] <= 109
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        if(n == 1) {
            int[] res = {0};
            return res;
        }

        int[] maxHeights = new int[n + 1];


        for(int i = n - 1; i >= 0; i--) {
            maxHeights[i] = Math.max(maxHeights[i + 1], heights[i]);
        }


        List<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(heights[i] > maxHeights[i + 1]) {
                indexes.add(i);
            }
        }

        int[] res = new int[indexes.size()];

        for(int i = 0; i < indexes.size(); i++) {
            res[i] = indexes.get(i);
        }

        return res;

    }
}


</code></pre>
</div>
</div>
