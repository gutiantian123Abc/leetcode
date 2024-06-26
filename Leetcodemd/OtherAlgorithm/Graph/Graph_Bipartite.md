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
/*  Is Graph Bipartite?
Given an undirected graph, return true if and only
if it is bipartite.
Recall that a graph is bipartite if we can split
it's set of nodes into
two independent subsets A and B such that every
edge in the graph has one
node in A and another node in B.
The graph is given in the following form: graph[i]
is a list of indexes j
for which the edge between nodes i and j exists.
Each node is an integer
between 0 and graph.length - 1.  There are no self
edges or parallel edges:
graph[i] does not contain i, and it doesn't
contain any element twice.
Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation:
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2}
and {1, 3}.
Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation:
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes
into two independent subsets.
Note:
graph will have length in range [1, 100].
graph[i] will contain integers in range [0,
graph.length - 1].
graph[i] will not contain i or duplicate values.
The graph is undirected: if any element j is in
graph[i], then i will be in graph[j].
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>



//讲解： https://www.geeksforgeeks.org/bipartite-graph/

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length]; // 0 not visited, 1 black, 2 red
     
        for(int i = 0; i < graph.length; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                Queue<Integer> q = new LinkedList<Integer>();
                q.offer(i);
                
                while(!q.isEmpty()) {
                    int size = q.size();
                    for(int j = 0; j < size; j++) {
                        int current = q.poll();
                        int currentColor = visited[current];
                        int[] neighbors = graph[current];
                        for(int neighbor : neighbors) {
                            if(visited[neighbor] != 0) {
                                if(visited[neighbor] == currentColor) {
                                    return false;
                                } 
                            }else {
                                visited[neighbor] = (currentColor == 1) ? 2 : 1;
                                q.offer(neighbor);
                            }
                        }
                    }
                }
                
            }
        }
        
        return true;
    }
}



</code></pre>
</div>
</div>
