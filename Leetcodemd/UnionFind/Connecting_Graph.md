<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Connecting Graph I
Given n nodes in a graph labeled from 1 to n. 
There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), add an edge to connect node a and node b. 2.query(a, b)`, 
check if two nodes are connected

Example
5 // n = 5
query(1, 2) return false
connect(1, 2)
query(1, 3) return false
connect(2, 4)
query(1, 4) return true
*/
/* Connecting Graph II
Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), an edge to connect node a and node b
2. query(a), Returns the number of connected component nodes which include node a.

Example
5 // n = 5
query(1) return 1
connect(1, 2)
query(1) return 2
connect(2, 4)
query(1) return 3
connect(1, 4)
query(1) return 3
*/
/*Connecting Graph III 
Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), an edge to connect node a and node b
2. query(), Returns the number of connected component in the graph

Example
5 // n = 5
query() return 5
connect(1, 2)
query() return 4
connect(2, 4)
query() return 3
connect(1, 4)
query() return 3
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class ConnectingGraph { 
    private int[] father = null;
    public ConnectingGraph(int n) { //记住， 这里一定是father[0 .. n], 长度 n + 1
        // initialize your data structure here.
        father = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            father[i] = i;
        }
    }

    private int find(int x) { //Find(Path Compression O(1))
        if(father[x] == x) {
            return x;
        }
        
        father[x] = find(father[x]);
        return father[x];
    }
    
    
    public void connect(int a, int b) { //Union O(1)
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        
        if(root_a != root_b) {
            father[root_b] = root_a;
        }
    }
    
    
        
    public boolean  query(int a, int b) { //Find(Path Compression O(1))
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        
        return root_a == root_b;
    }
}






public class ConnectingGraph2 {
    private int[] father;
    private int[] size;

    public ConnectingGraph2(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        size = new int[n + 1];
    
        for(int i = 1; i < n + 1; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }
    
    private int find(int x) {
        if(father[x] == x) {
            return x;
        }
        
        father[x] = find(father[x]);
        
        return father[x];
    }

    public void connect(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        
        if(root_a != root_b) {
            father[root_b] = root_a;
            size[root_a] += size[root_b];
        }
    }
        
    public int query(int a) {
        // Write your code here
        int root_a = find(a);
        return size[root_a];
    }
}






public class ConnectingGraph3 {
    private int[] father;
    private int count;

    private int find(int x) {
        if(father[x] == x) {
            return x;
        }
        
        father[x] = find(father[x]);
        
        return father[x];
    }
    
    
    public ConnectingGraph3(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        count = n;
        
        for(int i = 1; i < n + 1; i++) {
            father[i] = i;
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        
        if(root_a != root_b) {
            father[root_b] = root_a;
            count--;
        }
    }
        
    public int query() {
        // Write your code here
        return count;
    }
}
















</code></pre>
</div>
</div>
