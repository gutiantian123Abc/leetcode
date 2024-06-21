<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 700px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 1615. Maximal Network Rankhttps://leetcode.com/problems/maximal-network-rank/There is an infrastructure of n cities with some number of roads connecting these cities.Each roads[i] = [ai, bi] indicates that there is a bidirectional road betweencities ai and bi.The network rank of two different cities is defined as the total number of directlyconnected roads to either city. If a road is directly connected to both cities,it is only counted once.The maximal network rank of the infrastructure is the maximum network rank ofall pairs of different cities.Given the integer n and the array roads, return the maximal network rank of theentire infrastructure.Example 1:Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]Output: 4Explanation: The network rank of cities 0 and 1 is 4 as there are 4 roads that areconnected to either 0 or 1. The road between 0 and 1 is only counted once.Example 2:Input: n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]Output: 5Explanation: There are 5 roads that are connected to cities 1 or 2.Example 3:Input: n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]Output: 5Explanation: The network rank of 2 and 5 is 5. Notice that all the cities do nothave to be connected.Constraints:2 <= n <= 1000 <= roads.length <= n * (n - 1) / 2roads[i].length == 20 <= ai, bi <= n-1ai != biEach pair of cities has at most one road connecting them.*/</pre>
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
