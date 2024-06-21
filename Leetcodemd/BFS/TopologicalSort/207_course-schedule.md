<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container {{ max-width: 100%; margin: 0 auto; padding: 10px; }}
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 207 course-schedule/
https://leetcode.com/problems/course-schedule/

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Build graph
        Map<Integer, List<Integer>> childrenMap = new HashMap<>();
        Map<Integer, List<Integer>> parentsMap = new HashMap<>();

        for(int[] p : prerequisites) {
            int parent = p[1];
            int child = p[0];
            //childrenMap : input parent | output : children
            if(!childrenMap.containsKey(parent)) {
                childrenMap.put(parent, new ArrayList<>());
            }

            if(!childrenMap.get(parent).contains(child)) {
                childrenMap.get(parent).add(child);
            }

            //parentsMap : input child | output : parents
            if(!parentsMap.containsKey(child)) {
                parentsMap.put(child, new ArrayList<>());
            }

            if(!parentsMap.get(child).contains(parent)) {
                parentsMap.get(child).add(parent);
            }
        }

        // Queue
        // Any course without parent, add to queue
        Queue<Integer> queue = new LinkedList<>();
        for(int course = 0; course < numCourses; course++) {
            if(!parentsMap.containsKey(course)) {
                queue.add(course);
            }
        }

        // Process
        int ret = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            ret++;
            List<Integer> children = childrenMap.get(course);
            if(children != null) {
                for(int child : childrenMap.get(course)) {
                    int parentIndex = parentsMap.get(child).indexOf(course);
                    parentsMap.get(child).remove(parentIndex);
                    if(parentsMap.get(child).size() == 0) {
                        queue.add(child);
                    }
                }
            }
        }

        return ret == numCourses;  
    }
}









</code></pre>
</div>
</div>
