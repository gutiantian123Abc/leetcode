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
/* https://leetcode.com/problems/evaluate-division/You are given an array of variable pairs equations and an array of real numbers values, whereequations[i] = [Ai, Bi] and values[i] represent theequation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you mustfind the answer for Cj / Dj = ?.Return the answers to all queries. If a single answer cannot be determined, return -1.0.Note: The input is always valid. You may assume that evaluating the queries will not result indivision by zero and that there is no contradiction.Note: The variables that do not occur in the list of equations are undefined, so the answer cannotbe determined for them.Example 1:Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries =[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]Explanation:Given: a / b = 2.0, b / c = 3.0queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?return: [6.0, 0.5, -1.0, 1.0, -1.0 ]note: x is undefined => -1.0Example 2:Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries =[["a","c"],["c","b"],["bc","cd"],["cd","bc"]]Output: [3.75000,0.40000,5.00000,0.20000]Example 3:Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]Output: [0.50000,2.00000,-1.00000,-1.00000]Constraints:1 <= equations.length <= 20equations[i].length == 21 <= Ai.length, Bi.length <= 5values.length == equations.length0.0 < values[i] <= 20.01 <= queries.length <= 20queries[i].length == 21 <= Cj.length, Dj.length <= 5Ai, Bi, Cj, Dj consist of lower case English letters and digits.*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> tree = buildTree(equations, values);
        double[] res = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String A = query.get(0);
            String B = query.get(1);
            res[i] = dfs(tree, A, B, new HashSet<>());
        }

        return res;
    }

    private Map<String, Map<String, Double>> buildTree(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<>();

        for(int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String A = equation.get(0);
            String B = equation.get(1);
            double value = values[i];
            double reverseValue = 1.0 / value;
            map.putIfAbsent(A, new HashMap<>());
            map.get(A).put(B, value);

            map.putIfAbsent(B, new HashMap<>());
            map.get(B).put(A, reverseValue);
        }

        return map;
    }


    private double dfs(Map<String, Map<String, Double>> tree, String A, String B, Set<String> visited) {
        if(!tree.containsKey(A)) {
            return -1.0;
        } else {
            visited.add(A);
            Map<String, Double> map = tree.get(A);
            if(map.containsKey(B)) {
                return map.get(B);
            }else if (A.equals(B)) {
                return 1.0;
            }else {
                for(String key : map.keySet()) {
                    if(!visited.contains(key)) {
                        double curLevelVal = map.get(key);
                        double nextLevelVal = dfs(tree, key, B, visited);
                        if(nextLevelVal != -1.0) {
                            return curLevelVal * nextLevelVal;
                        }
                    }
                }

                return -1.0;
            }
        }
    }
}






</code></pre>
</div>
</div>
