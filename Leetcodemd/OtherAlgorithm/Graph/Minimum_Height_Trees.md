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
/* Minimum Height Trees
For a undirected graph with tree characteristics,
we can choose any node as the root. The result
graph is then a rooted tree.
Among all possible rooted trees, those with
minimum height are called minimum height trees
(MHTs). Given such a graph,
write a function to find all the MHTs and return a
list of their root labels.
Format
The graph contains n nodes which are labeled from
0 to n - 1.
You will be given the number n and a list of
undirected edges (each edge is a pair of labels).
You can assume that no duplicate edges will appear
in edges.
Since all edges are undirected, [0, 1] is the same
as [1, 0] and thus will not appear together in
edges.
Example 1:
Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
        0
        |
        1
       / \
      2   3
return [1]
Example 2:
Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4,
3], [5, 4]]
     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]
Note:
(1) According to the definition of tree on
Wikipedia:
“a tree is an undirected graph in which any two
vertices are connected by exactly one path. In
other words,
any connected graph without simple cycles is a
tree.”
(2) The height of a rooted tree is the number of
edges on the longest downward path between the
root and a leaf.
*/
/* Solution:
OK. Let's stop here and look at our problem.
Our problem want us to find the minimum height
trees and return their root labels.
First we can think about a simple case -- a path
graph.
For a path graph of n nodes, find the minimum
height trees is trivial. Just designate the middle
point(s) as roots.
Despite its triviality, let design a algorithm to
find them.
Suppose we don't know n, nor do we have random
access of the nodes. We have to traversal.
It is very easy to get the idea of two pointers.
One from each end and move at the same speed.
When they meet or they are one step away,
(depends on the parity of n), we have the roots we
want.
This gives us a lot of useful ideas to crack our
real problem.
For a tree we can do some thing similar. We start
from every end, by end we mean vertex of degree 1
(aka leaves).
We let the pointers move the same speed. When two
pointers meet,
we keep only one of them, until the last two
pointers meet or one step away we then find the
roots.
It is easy to see that the last two pointers are
from the two ends of the longest path in the
graph.
The actual implementation is similar to the BFS
topological sort.
Remove the leaves, update the degrees of inner
vertexes. Then remove the new leaves.
Doing so level by level until there are 2 or 1
nodes left. What's left is our answer!
The time complexity and space complexity are both
O(n).
Note that for a tree we always have V = n, E =
n-1.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>



class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            map.put(i, new HashSet<Integer>());
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            map.get(u).add(v);
            map.get(v).add(u);
        }
        
        HashSet<Integer> leaves = new HashSet<>();
        
        for(Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            if(entry.getValue().size() == 1) {
                leaves.add(entry.getKey());
            }
        }
        
        
        while(map.size() > 2) {
            HashSet<Integer> newLeaves = new HashSet<>();
            for(Integer leaf : leaves) {
                for(Integer neighbor : map.get(leaf)) {
                    map.get(neighbor).remove(leaf);
                    if(map.get(neighbor).size() == 1) {
                        newLeaves.add(neighbor);
                    }
                }
                map.remove(leaf);
            }
            
            leaves = newLeaves;
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        for(Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            ans.add(entry.getKey());
        }
        
        return ans;
    }
}



</code></pre>
</div>
</div>
