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
/* Brick Wall:  https://leetcode.com/problems/brick-wall/description/
There is a brick wall in front of you. The wall is rectangular 
and has several rows of bricks. The bricks have the same height 
but different width. You want to draw a vertical line from the 
top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. Each row is a 
list of integers representing the width of each brick in this 
row from left to right.

If your line go through the edge of a brick, then the brick is 
not considered as crossed. You need to find out how to draw the 
line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges 
of the wall, in which case the line will obviously cross no bricks.

Example:
Input: 
[[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]
Output: 2
Explanation: 

Note:
The width sum of bricks in different rows are the same and won't exceed INT_MAX.
The number of bricks in each row is in range [1,10,000]. The height of wall is 
in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < wall.size(); i++) {
            List<Integer> list = wall.get(i);
            int index = 0;
            for(int j = 0; j < list.size() - 1; j++) {
                Integer brick = list.get(j);
                index += brick;
                if(map.containsKey(index)) {
                    int oldfreq = map.get(index);
                    map.replace(index, oldfreq, oldfreq + 1);
                    
                }else {
                    map.put(index, 1);
                }
            }
        }
        
        int maxFreqIndex = 0;
        int maxFreq = 0;
        for(Integer index : map.keySet()) {
            if(map.get(index) > maxFreq) {
                maxFreq = map.get(index);
                maxFreqIndex = index;
            }
        }
        
        return wall.size() - maxFreq;
    }
}</code></pre>
</div>
</div>
