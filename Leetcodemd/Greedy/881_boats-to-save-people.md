<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 400px; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*
https://leetcode.com/problems/boats-to-save-people

https://leetcode.com/problems/boats-to-save-people/editorial/

You are given an array people where people[i] is the weight 
of the ith person, and an infinite number of boats where each 
boat can carry a maximum weight of limit. Each boat carries at 
most two people at the same time, provided the sum of the weight 
of those people is at most limit.

Return the minimum number of boats to carry every given person.


Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
 

Constraints:

1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        boolean[] v = new boolean[n];
        
        Arrays.sort(people);
        int savedPeople = 0;
        int boat = 0;

        int start = 0;
        int end = n - 1;

        while(start < end) {
            int total = people[start] + people[end];
            if(total > limit) {
                end--;
                boat++;
                savedPeople++;
            }else { // total <= limit
                start++;
                end--;
                boat++;
                savedPeople += 2;
            }
        }

        if(savedPeople == n) {
            return boat;
        }else {
            return boat + 1;
        }

    }
}</code></pre>
</div>
</div>
