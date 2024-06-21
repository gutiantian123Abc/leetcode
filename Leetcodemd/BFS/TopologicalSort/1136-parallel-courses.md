<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 1136. Parallel Courses

https://leetcode.com/problems/parallel-courses/

You are given an integer n, which indicates that there are n courses 
labeled from 1 to n. You are also given an array relations where 
relations[i] = [prevCoursei, nextCoursei], representing a prerequisite 
relationship between course prevCoursei and course nextCoursei: course 
prevCoursei has to be taken before course nextCoursei.

In one semester, you can take any number of courses as long as you have 
taken all the prerequisites in the previous semester for the courses you are taking.

Return the minimum number of semesters needed to take all courses. 
If there is no way to take all the courses, return -1.

 

Example 1:


Input: n = 3, relations = [[1,3],[2,3]]
Output: 2
Explanation: The figure above represents the given graph.
In the first semester, you can take courses 1 and 2.
In the second semester, you can take course 3.
Example 2:


Input: n = 3, relations = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: No course can be studied because they are prerequisites of each other.
 

Constraints:

1 <= n <= 5000
1 <= relations.length <= 5000
relations[i].length == 2
1 <= prevCoursei, nextCoursei <= n
prevCoursei != nextCoursei
All the pairs [prevCoursei, nextCoursei] are unique.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        //1. map<Integer, Integer> parentsMap
        Map<Integer, List<Integer>> parentsMap = new HashMap<>();
        //2. map<Integer, Integer> childrenMap
        Map<Integer, List<Integer>> childrenMap = new HashMap<>();

        for(int i = 0; i < relations.length; i++) {
            int parent = relations[i][0];
            int child = relations[i][1];

            if(!parentsMap.containsKey(child)) {
                parentsMap.put(child, new ArrayList<>());
            }
            parentsMap.get(child).add(parent);

            if(!childrenMap.containsKey(parent)) {
                childrenMap.put(parent, new ArrayList<>());
            }
            childrenMap.get(parent).add(child);
        }

        // BFS
        int S = 0;
        int couurseNum = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 1; i <= n; i++) {
            if(!parentsMap.containsKey(i)) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int parent = queue.poll();
                couurseNum++;
                List<Integer> children = childrenMap.get(parent);
                if(children != null) {
                    for(int child : childrenMap.get(parent)) {
                    	// Important!!!! Indegree
                        int parentIndex = parentsMap.get(child).indexOf(parent);
                        parentsMap.get(child).remove(parentIndex);
                        if(parentsMap.get(child).size() == 0) {
                            queue.add(child);
                        }
                    }
                }
            }
            S++;
        }

        if(couurseNum != n) {
            return -1;
        }

        return S;
    }
}</code></pre>
</div>
</div>
