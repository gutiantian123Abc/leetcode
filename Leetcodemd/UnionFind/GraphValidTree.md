<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 500px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
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
(2). 从一个点做BFS 或DFS可以碰到所有点 （判断是否都联通）， 参考BFS类
3. 本体用UnionFind, 看最后是否只剩下一个component
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
    public class UnionFind {
        private int count;
        private HashMap<Integer, Integer> father;//HashMap做Union Find更好
        
        public UnionFind(int n) {
            count = n;
            father = new HashMap<Integer, Integer>();
            for(int i = 0; i < n; i++) {//HashMap做Union Find从0开始即可
                father.put(i, i);
            }
        }
        
        public int getCount() {
            return count;
        }
        
        
        public int find(int x) {
            int parent =  father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            int temp = -1;
            int fa = father.get(x);
            while(fa!=father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent) ;
                fa = temp;
            }
            return parent;

        }
        
        
        public void union(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            
            if(root_a != root_b) {
                father.put(root_b, root_a);
                count--;
            }
        }
        
    } 
     
     
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if(edges.length != n - 1) {
            return false;
        }
        
        
        UnionFind uf = new UnionFind(n);
        
        for(int[] edge : edges) {
            int node_a = edge[0];
            int node_b = edge[1];
            uf.union(node_a, node_b);
        }
        
        return uf.getCount() == 1;
    }
}</code></pre>
</div>
</div>
