<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Friend Circles

There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. 
For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. 
And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, 
then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number 
of friend circles among all the students.

Example 1:
Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.

Example 2:
Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
*/
/* Solution 这个题主要考察Adjacent Matrix 的理解和应用
In this graph, the node numbers represent the indices in the matrix M and an edge exists between the nodes numbered ii and jj, 
if there is a 1 at the corresponding M[i][j]M[i][j].

In order to find the number of connected components in an undirected graph, one of the simplest methods is to make use of 
Depth First Search starting from every node. We make use of visitedvisited array of size NN(MM is of size NxNNxN). 
This visited[i]visited[i] element is used to indicate that the i^{th}i 
th
  node has already been visited while undergoing a Depth First Search from some node.

To undergo DFS, we pick up a node and visit all its directly connected nodes. But, as soon as we visit any of those nodes, 
we recursively apply the same process to them as well. Thus, we try to go as deeper into the levels of the graph as possible 
starting from a current node first, leaving the other direct neighbour nodes to be visited later on.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>



class Solution {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        boolean[] visited = new boolean[N];
        int count = 0;
        
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(int[][] M, boolean[] visited, int i) {
        if(visited[i]) {
            return;
        }
        
        visited[i] = true;
        for(int j = 0; j < M.length; j++) {
            if(j != i && M[i][j] == 1) {
                dfs(M, visited, j);
            }
        }
    }
}</code></pre>
</div>
</div>
