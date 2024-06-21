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
/* 
Clone Graph
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
How we serialize an undirected graph:
Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.
The graph has a total of three nodes, and therefore contains three parts as separated by #.
First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

   1
  / \
 /   \
0 --- 2
     / \
     \_/

Example
return a deep copied graph.
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null) {
            return null;
        }
        ArrayList<UndirectedGraphNode> allNodes = BFS(node);

        //HashMap 的巧妙用法，值得学习
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        for(UndirectedGraphNode oldNode : allNodes) {
            map.put(oldNode, new UndirectedGraphNode(oldNode.label));
        }
        
        //Clone neighbors for each newNode, with HashMap, good thoughts!!!
        for(UndirectedGraphNode oldNode : allNodes) {
            UndirectedGraphNode newNode = map.get(oldNode);
            ArrayList<UndirectedGraphNode> newNeighbors = new ArrayList<UndirectedGraphNode>();
            for(UndirectedGraphNode oldNeighbor : oldNode.neighbors) {
                newNeighbors.add(map.get(oldNeighbor));
            }
            newNode.neighbors = newNeighbors;
        }
        
        return map.get(node);
    }
 
    
    ArrayList<UndirectedGraphNode> BFS(UndirectedGraphNode node) {
        ArrayList<UndirectedGraphNode> result = new ArrayList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>(); //可以用于鉴定是否访问过，很好用！！！！
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        set.add(node);
        while(queue.size() != 0) {
            int size = queue.size(); //标配， 固定模板
            for(int i = 0; i < size; i++) { 
                UndirectedGraphNode oldNode = queue.poll();
                result.add(oldNode);
                for(UndirectedGraphNode neighbor : oldNode.neighbors) {
                    if(!set.contains(neighbor)) {//可以用于鉴定是否访问过，很好用！！！！
                        queue.offer(neighbor);
                        set.add(neighbor);//可以用于鉴定是否访问过，很好用！！！！
                    }
                }
            }
        }
        return result;
    }
}</code></pre>
</div>
</div>
