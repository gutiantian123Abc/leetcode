<style>
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Graph Valid Tree
Given n nodes labeled from 0 to n - 1 and a list of undirected edges 
(each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Notice
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Knowledge:
For a graph to be a tree: 符合两个条件：
1、 边的数必须等于点数 - 1 (判断是否有环)
2. 从一个点做BFS 或DFS可以碰到所有点 （判断是否都联通）
*/
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n - 1) {
            return false;
        }
        
        Map<Integer, Set<Integer>> map = graphInitilize(n, edges);
        Set<Integer> visited = new HashSet<Integer>();
        int visit = 0;
        
        //传统BFS
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        visited.add(0);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) { //记住，每一层的划分在这里，这是模板！！！
                int node = queue.poll(); //poll()在这里执行
                visit++;
                for(Integer neighbor : map.get(node)) {
                    if(visited.contains(neighbor)) {
                        continue;
                    }
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        
        return visit == n;
    }
    
    private Map<Integer, Set<Integer>> graphInitilize(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        
        for(int i = 0; i < n; i ++) {
            map.put(i, new HashSet<Integer>());
        }
        
        for(int i = 0 ; i < edges.length; i++) {//记住这里记录点和邻居的数据结构
            int u = edges[i][0];
            int v = edges[i][1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        
        return map;
    }
}</code></pre>
</div>
