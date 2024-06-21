<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 1000px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*
There are a total of n courses you have to take, 
labeled from 0 to n - 1.
Some courses may have prerequisites, 
for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, 
return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. 
If it is impossible to finish all courses, return an empty array.

Example
Given n = 2, prerequisites = [[1,0]]
Return [0,1]
Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
Return [0,1,2,3] or [0,2,1,3]
*/
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
//Course Schedule II

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) { //拓扑排序需要俩： 1。 深度  2. 向下的邻居们
        // Write your code here
        int degree[] = new int[numCourses];
        ArrayList[] edges = new ArrayList[numCourses]; // Array 不能 generic type
        
        for(int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>(); // ArrayList array 必须 initilize 一下
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i = 0; i < numCourses; i++) {
            if(degree[i] == 0) {
                queue.add(i);
            }
        }
        
        int[] order = new int[numCourses]; //拓扑排序
        int count = 0;
        while(queue.size() != 0) {
            int curr = queue.poll();
            order[count] = curr;
            count++;
            int size = edges[curr].size();
            for(int i = size - 1; i >= 0; i--) {
                int neighbor = (int)edges[curr].get(i); //跟不是直接的ArrayList<Integer>有关
                degree[neighbor]--;    //拓扑排序， 深度为 0 的 node 加到 queue 里面
                if(degree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        if(count == numCourses) {
            return order;
        }
        
        return new int[0];
    }
}</code></pre>
</div>
</div>
