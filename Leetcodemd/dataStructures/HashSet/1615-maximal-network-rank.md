<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 1615. Maximal Network Rank

https://leetcode.com/problems/maximal-network-rank/

There is an infrastructure of n cities with some number of roads connecting these cities. 
Each roads[i] = [ai, bi] indicates that there is a bidirectional road between 
cities ai and bi.

The network rank of two different cities is defined as the total number of directly 
connected roads to either city. If a road is directly connected to both cities, 
it is only counted once.

The maximal network rank of the infrastructure is the maximum network rank of 
all pairs of different cities.

Given the integer n and the array roads, return the maximal network rank of the 
entire infrastructure.

 

Example 1:

Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
Output: 4
Explanation: The network rank of cities 0 and 1 is 4 as there are 4 roads that are 
connected to either 0 or 1. The road between 0 and 1 is only counted once.



Example 2:

Input: n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
Output: 5
Explanation: There are 5 roads that are connected to cities 1 or 2.




Example 3:

Input: n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
Output: 5
Explanation: The network rank of 2 and 5 is 5. Notice that all the cities do not 
have to be connected.
 

Constraints:

2 <= n <= 100
0 <= roads.length <= n * (n - 1) / 2
roads[i].length == 2
0 <= ai, bi <= n-1
ai != bi
Each pair of cities has at most one road connecting them.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> neighborMap = new HashMap<>();
        for(int i = 0; i < roads.length; i++) {
            int c1 = roads[i][0];
            int c2 = roads[i][1];

            if(!neighborMap.containsKey(c1)) {
                neighborMap.put(c1, new HashSet<>());
            }

            if(!neighborMap.containsKey(c2)) {
                neighborMap.put(c2, new HashSet<>());
            }

            neighborMap.get(c1).add(c2);
            neighborMap.get(c2).add(c1);
        }

        int max = 0;

        for(int c1 : neighborMap.keySet()) {
            for(int c2 : neighborMap.keySet()) {
                if(c1 != c2) {
                    if(neighborMap.get(c1).contains(c2)) { //connected
                        max = Math.max(max, neighborMap.get(c1).size() + neighborMap.get(c2).size() - 1);
                    } else {
                        max = Math.max(max, neighborMap.get(c1).size() + neighborMap.get(c2).size());
                    }
                }
            }
        }

        return max;
        
    }
}</code></pre>
</div>
</div>
