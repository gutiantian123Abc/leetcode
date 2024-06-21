<style>
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Evaluate Division

Equations are given in the format A / B = k, 
where A and B are variables represented as strings, and k is a real number (floating point number). 
Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: 
vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
where equations.size() == values.size(), and the values are positive. This represents the equations. 
Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries 
will result in no division by zero and there is no contradiction.
*/
/* 知识点： ArrayList & HashSet
ArrayList 有 index, 顺序有意义， .get(int index)   .get(Object)
ArrayList（1，2） ！= ArrayList（2，1）



HashSet 没有index, 顺序没意义， 没有get()等 method
HashSet(1,2) == HashSet(2,1)
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//Solution: Image a/b = k as a link between node a and b, 
//the weight from a to b is k, the reverse link is 1/k. Query is to find a path between two nodes.



class Solution {
    private class ResultType {
        boolean connected;
        double weight;
        
        public ResultType(boolean connected, double weight) {
            this.connected = connected;
            this.weight = weight;
        } 
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, ArrayList<String>> Graph = new HashMap<>();
        HashMap<String, ArrayList<Double>> Weight = new HashMap<>();
        
        
        for(int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            String a = equation[0];
            String b = equation[1];
            double value = values[i];
            
            if(!Graph.containsKey(a)) {
                Graph.put(a, new ArrayList<String>());
            }
         
            if(!Graph.containsKey(b)) {
                Graph.put(b, new ArrayList<String>());
            }
            
            if(!Weight.containsKey(a)) {
                Weight.put(a, new ArrayList<Double>());
            }
            
            if(!Weight.containsKey(b)) {
                Weight.put(b, new ArrayList<Double>());
            }
            
            Graph.get(a).add(b);
            Graph.get(b).add(a);
            Weight.get(a).add(value);
            Weight.get(b).add(1.0 / value);
        }
            
        double[] res = new double[queries.length];
        int index = 0;
            
        for(String[] query : queries) {
            String start = query[0];
            String end = query[1];

            if(!Graph.containsKey(start) || !Graph.containsKey(end)) {
                res[index++] = -1.0;
                continue;
            }

            if(start.equals(end)) {
                res[index++] = 1.0;
                continue;
            }

            ResultType ans = dfs(Graph, Weight, start, end, new ArrayList<String>(), 1.0);
            if(ans.connected) {
                res[index++] = ans.weight;
            }else {
                res[index++] = -1.0;
            }   
        }
        
        
        return res;
    }
    
    private ResultType dfs(HashMap<String, ArrayList<String>> Graph, HashMap<String, ArrayList<Double>> Weight, String start, String end, ArrayList<String> visited, double totalWeight) {
        if(start.equals(end)) {
            return new ResultType(true, totalWeight);
        }
        
        
        visited.add(start);
        ArrayList<String> neighbors = Graph.get(start);
        for(int i = 0; i < neighbors.size(); i++) {
            String neighbor = neighbors.get(i);
            if(!visited.contains(neighbor)) {
                double newWeight = totalWeight * Weight.get(start).get(i);
                ResultType nextRes = dfs(Graph, Weight, neighbor, end, visited, newWeight);
                if(nextRes.connected) {
                    return nextRes;
                }
                
            }
        }
        
        
        return new ResultType(false, 1.0);    
    }
}



</code></pre>
</div>
