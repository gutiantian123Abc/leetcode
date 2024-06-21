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
/* Search Graph NodesGiven a undirected graph, a node and a target,return the nearest node to given node which value of it is target,return NULL if you can't find.There is a mapping store the nodes' values in the given parameters.Example2------3  5 \     |  |  \    |  |   \   |  |    \  |  |      1 --4Give a node 1, target is 50there a hash named values which is [3,4,10,50,50], represent:Value of node 1 is 3Value of node 2 is 4Value of node 3 is 10Value of node 4 is 50Value of node 5 is 50Return node 4*//** * Definition for graph node. * class UndirectedGraphNode { *     int label; *     ArrayList<UndirectedGraphNode> neighbors; *     UndirectedGraphNode(int x) { *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); *     } * }; */    /**     * @param graph a list of Undirected graph node     * @param values a hash mapping, <UndirectedGraphNode, (int)value>     * @param node an Undirected graph node     * @param target an integer     * @return the a node     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {  //经典的BFS, 王中王
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here
        if(values.get(node) == target) {
            return node;
        } 
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        
        while(queue.size() != 0) {
            UndirectedGraphNode curr = queue.poll();
            ArrayList<UndirectedGraphNode> neighbors = curr.neighbors;
            
            for(UndirectedGraphNode neighbor : neighbors) {
                if(values.get(neighbor) == target) {
                    return neighbor;
                }
                
                queue.add(neighbor);
            }
        }
        return null;
    }
}</code></pre>
</div>
</div>
