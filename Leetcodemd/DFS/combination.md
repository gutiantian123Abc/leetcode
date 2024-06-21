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
/* 题目描述Given an array A and k, return all possible combinations of k numbers outof the array A.For example, If A = [1,2,3,4] and k = 2, a solution is:[ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public List<List<Integer>> combine(int[] A, int k) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        
        helper(rst, solution, 0, A, k);
        return rst;
    }
    
    private void helper(List<List<Integer>> rst, List<Integer> solution, 
        int index, int[] A, int k) {
        if (solution.size() == k){
            rst.add(new ArrayList(solution));
            return;
        }
        
        for(int i = index; i< A.length; i++){

            solution.add(A[i]);
            // the new start index should be after the next number after i
            helper(rst, solution, i + 1, A, k); 
            solution.remove(solution.size() - 1);
            
        }
    }
}</code></pre>
</div>
</div>
