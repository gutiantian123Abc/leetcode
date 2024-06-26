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
/* 277. Find the Celebrity
https://leetcode.com/problems/find-the-celebrity/
Suppose you are at a party with n people labeled
from 0 to n - 1 and among them,
there may exist one celebrity.
The definition of a celebrity is that all the
other n - 1 people know the celebrity,
but the celebrity does not know any of them.
Now you want to find out who the celebrity is or
verify that there is not one.
You are only allowed to ask questions like:
"Hi, A. Do you know B?" to get information about
whether A knows B.
You need to find out the celebrity (or verify
there is not one)
by asking as few questions as possible (in the
asymptotic sense).
You are given a helper function bool knows(a, b)
that tells you whether a knows b.
Implement a function int findCelebrity(n).
There will be exactly one celebrity if they are at
the party.
Return the celebrity's label if there is a
celebrity at the party. If there is no celebrity,
return -1.
Example 1:
Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
Output: 1
Explanation: There are three persons labeled with
0, 1 and 2.
graph[i][j] = 1 means person i knows person j,
otherwise graph[i][j] = 0
means person i does not know person j.
The celebrity is the person labeled as 1 because
both 0 and 2 know him but 1 does not know anybody.
Example 2:
Input: graph = [[1,0,1],[1,1,0],[0,1,1]]
Output: -1
Explanation: There is no celebrity.
Constraints:
n == graph.length == graph[i].length
2 <= n <= 100
graph[i][j] is 0 or 1.
graph[i][i] == 1
Follow up: If the maximum number of allowed calls
to the API knows is 3 * n,
could you find a solution without exceeding the
maximum number of calls?
*/
/* The knows API is defined in the parent class
Relation.
      boolean knows(int a, int b); */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>



public class Solution extends Relation {
    public int findCelebrity(int n) {
        int p1 = 0, p2 = 1;
        while(p1 < n && p2 < n) {
            boolean ab = knows(p1, p2);
            boolean ba = knows(p2, p1);

            if(ab && ba) {
                p1 = p2 + 1;
                p2 += 2;
            } else if(!ab && ba) {
                p2++;
            } else {
                p1 = p2;
                p2++;
            }
        }

        if(p1 >= n) {
            return -1;
        } else {
            for(int i = 0; i < n; i++) {
                if(i != p1) {
                    if(!knows(i, p1) || knows(p1, i)) {
                        return -1;
                    }
                }
            }

            return p1;
        }
        
    }
}
</code></pre>
</div>
</div>
