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
/* 849. Maximize Distance to Closest Person

https://leetcode.com/problems/maximize-distance-to-closest-person

You are given an array representing a row of seats where seats[i] = 1 represents 
a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat 
is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest 
person to him is maximized. 

Return that maximum distance to the closest person.

 

Example 1:

Input: seats = [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (i.e. seats[2]), then the closest person 
has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.


Example 2:

Input: seats = [1,0,0,0]
Output: 3
Explanation: 
If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.


Example 3:

Input: seats = [0,1]
Output: 1
 

Constraints:

2 <= seats.length <= 2 * 104
seats[i] is 0 or 1.
At least one seat is empty.
At least one seat is occupied.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int lastFullSeatIndex = -1;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 0; i < n; i++) {
            if(seats[i] == 0) {
                if(lastFullSeatIndex == -1) {
                    left[i] = Integer.MAX_VALUE;
                } else {
                    left[i] = i - lastFullSeatIndex;
                } 
            } else {
                lastFullSeatIndex = i;
            }
        }

        lastFullSeatIndex = -1;

        for(int i = n - 1; i >= 0; i--) {
            if(seats[i] == 0) {
                if(lastFullSeatIndex == -1) {
                    right[i] = Integer.MAX_VALUE;
                } else {
                    right[i] = lastFullSeatIndex - i;
                }
            } else {
                lastFullSeatIndex = i;
            }
        }

        int maxDis = 0;

        for(int i = 0; i < n; i++) {
            if(seats[i] == 0) {
                maxDis = Math.max(Math.min(left[i], right[i]), maxDis);
            }
        }

        return maxDis;
        
    }
}</code></pre>
</div>
</div>
