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
/* Number of Islands II
Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k).
Originally, the 2D matrix is all 0 which means there is only sea in the matrix.
The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can
change the grid matrix[A[i].x][A[i].y] from sea to island.
Return how many island are there in the matrix after each operator.
0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them
in the same island. We only consider up/down/left/right adjacent.
Example
Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].
return [1,1,2,2].
*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//Method1: Array 并查集的应用

public class Solution {
     
    public class UnionFind { //万年不变固定模板
        private int[] father;
        
        public UnionFind(int n, int m) {
            father = new int[m * n];
            for(int i = 0; i < n; i++) { //只要是并查集， 都这么做initilize
                for(int j = 0; j < m; j++) {
                    int id = convertId(i, j, m);
                    father[id] = id;
                }
            }
        }
        

        
        private int find(int x) {
            if(father[x] == x) {
                return x;
            }
            
            father[x] = find(father[x]);
            
            return father[x];
        }
        
        public void union(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            
            if(root_a != root_b) {
                father[root_b] = root_a; //一定注意这里， 是老大和老大间服从
            }
        } 
    }
    
    public int convertId(int x, int y, int m) {
        return m * x + y;
    }
    
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();
        if(operators == null || operators.length < 1) {
            return res;
        }
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0 };
        
        int[][] grid = new int[n][m];
        UnionFind uf = new UnionFind(n, m);
        
        int count = 0;
        
        for(Point point : operators) {
            int x = point.x;
            int y = point.y;
            int id = convertId(x, y, m);
            if(grid[x][y] == 0) {
                grid[x][y] = 1;
                int root_current = uf.find(id);
                count++;
                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(inBound(nx, ny, n, m) && grid[nx][ny] == 1) {
                         int nId = convertId(x + dx[i], y + dy[i], m);
                         int root_n = uf.find(nId);
                         if(root_current != root_n) {
                             uf.union(id, nId);
                             count--;
                         }
                    }
                }
            }
            res.add(count);
        }
        
        return res;
    }
    
    private boolean inBound(int x, int y, int n, int m) {
        if(x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        return true;
    }
}




//HashMap Union Find Method
public class Solution {
    public int convertId(int x, int y, int m) {
        return x * m + y;
    }
     
    public class UnionFind {
        private HashMap<Integer, Integer> father;
        
        public UnionFind(int n, int m) {
            father = new HashMap<Integer, Integer>();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    int id = convertId(i, j, m);
                    father.put(id, id);
                }
            }
        }
        
        
        public int find(int x) {
            if(father.get(x) == x) {
                return x;
            }
            
            int parent = father.get(x);
            
            while(parent != father.get(parent)) {
                parent = father.get(parent);
            }
            
            int temp = -1;
            int fa = x;
            
            while(fa != father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
            }
            
            return parent;
        }
        
        
        public void union(int a, int b) {
            int root_a = father.get(a);
            int root_b = father.get(b);
            
            if(root_a != root_b) {
                father.put(root_a, root_b); //一定注意这里， 是老大和老大间服从
            }
        }
        
        public boolean sameUnion(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            
            return root_a == root_b;
        }
        
    }
    
    private boolean inBound(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> ans = new ArrayList<Integer>();
        
        if(operators == null || operators.length == 0) {
            return ans;
        }
        
        int[][] grid = new int[n][m];
        
        int count = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        UnionFind uf = new UnionFind(n, m);
        
        for(Point point : operators) {
            int x = point.x;
            int y = point.y;
            int id = convertId(x, y, m);
            
            if(grid[x][y] != 1) {
                count++;
                grid[x][y] = 1;
                
                for(int i = 0; i < 4; i++) {
                    
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if(inBound(nx, ny, n, m)) {
                        int nid = convertId(nx, ny, m);
                    
                        if(!uf.sameUnion(id, nid) && grid[nx][ny] == 1) {
                            uf.union(id, nid);
                            count--;
                        }
                    }
                    
                
                }
            }
            
            ans.add(count);
        }
        
        
        return ans;
    
    }
}










</code></pre>
</div>
</div>
