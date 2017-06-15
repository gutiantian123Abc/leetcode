/* Connecting Graph
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
        int root1 = find(a);
        int root2 = find(b);
        
        if(root1 != root2) {
            father[root1] = root2;
        }
    }
    
    
        
    public boolean  query(int a, int b) { //Find(Path Compression O(1))
        // Write your code here
        int root1 = find(a);
        int root2 = find(b);
        
        return root1 == root2;
    }
}