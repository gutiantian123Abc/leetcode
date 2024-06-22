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
/* Minimum Spanning Tree
Given a list of Connections, which is the Connection class
(the city name at both ends of the edge and a cost between
them),
 find some edges, connect all the cities and spend the least
amount.
Return the connects if can connect all the cities, otherwise
return empty list.
Example
Gievn the connections = ["Acity","Bcity",1],
["Acity","Ccity",2], ["Bcity","Ccity",3]
Return ["Acity","Bcity",1], ["Acity","Ccity",2]
Notice
Return the connections sorted by the cost,
or sorted city1 name if their cost is same, or sorted city2
if their city1 name is also same.
*/
/**
 * Definition for a Connection.
 * public class Connection {
 *   public String city1, city2;
 *   public int cost;
 *   public Connection(String city1, String city2, int cost)
{
 *       this.city1 = city1;
 *       this.city2 = city2;
 *       this.cost = cost;
 *   }
 * }
 */
    /**
     * @param connections given a list of connections
include two cities and cost
     * @return a list of connections from results
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//Totorial: https://en.wikipedia.org/wiki/Kruskal%27s_algorithm
//Union FInd 是为了防止把已经连起来的两点再相连出现Cycle

public class Solution {
    class UN {
        public HashMap<Integer, Integer> father;
        
        public UN() {
            father = new HashMap<Integer, Integer>();
        }
        
        public void start(int n) {
            for(int i = 0; i < n; i++) {
                father.put(i, i);
            }
        }
        
        public int getRoot(int n) {

            if(father.get(n) == n) {
                return n;
            }
            
            int parent = father.get(n);
            
            while(parent != father.get(parent)) {
                parent = father.get(parent);
            }
            
            //Path compression
            int tmp = 0;
            int cur = n;
            while(father.get(cur) != cur) {
                tmp = father.get(cur);
                father.put(cur, parent);
                cur = tmp;
            }
            
            return parent;
        }
        
        public void union(int a, int b) {
            int root1 = father.get(a);
            int root2 = father.get(b);
            father.put(root1, root2);
        }
        
        public boolean sameGroup(int a, int b) {
            return getRoot(a) == getRoot(b);
        }
    }
    
    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        Collections.sort(connections, new Comparator<Connection>() {
            public int compare(Connection a, Connection b) {
                if(a.cost != b.cost) {
                    return a.cost - b.cost;
                }else {
                    if(a.city1.equals(b.city1)) {
                        return a.city2.compareTo(b.city2);
                    }else {
                        return a.city1.compareTo(b.city1);
                    }
                }
            }
        });
        
        int n = 0;
        HashMap<String, Integer> hash = new HashMap<>();
        for(Connection connection : connections) {
            if(!hash.containsKey(connection.city1)) {
                hash.put(connection.city1, n++);
            }
            
            if(!hash.containsKey(connection.city2)) {
                hash.put(connection.city2, n++);
            }
        }
        
        UN un= new UN();
        un.start(n);
       
        
        ArrayList<Connection> result = new ArrayList<Connection>();
        
        for(Connection connection : connections) {
            int city1 = hash.get(connection.city1);
            int city2 = hash.get(connection.city2);
            if(!un.sameGroup(city1, city2)) {
                un.union(city1, city2);
                result.add(connection);
            }
        }
        

        if(result.size() != n - 1) {
            return new ArrayList<Connection>();
        }
        
        return result;
    }
}</code></pre>
</div>
</div>
