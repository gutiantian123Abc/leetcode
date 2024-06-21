<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 365. Water and Jug Problem

https://leetcode.com/problems/water-and-jug-problem/description/

You are given two jugs with capacities jug1Capacity and jug2Capacity liters. 
There is an infinite amount of water supply available. Determine whether 
it is possible to measure exactly targetCapacity liters using these two jugs.

If targetCapacity liters of water are measurable, you must have targetCapacity 
liters of water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full, 
or the first jug itself is empty.
 

Example 1:
Input: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
Output: true
Explanation: The famous Die Hard example 


Example 2:
Input: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
Output: false
Example 3:

Input: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
Output: true
 

Constraints:

1 <= jug1Capacity, jug2Capacity, targetCapacity <= 106
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    class State {
        int jug1Vol;
        int jug2Vol;

        public State(int jug1Vol, int jug2Vol) {
            this.jug1Vol =  jug1Vol;
            this.jug2Vol =  jug2Vol;
        }

        public boolean equals(Object o) {
            State state = (State) o;
            return jug1Vol == state.jug1Vol && jug2Vol == state.jug2Vol;
        }

        public int hashCode() {
            return Objects.hash(jug1Vol, jug2Vol);
        }
    }
    
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Queue<State> queue = new LinkedList<>();
        Set<State> v = new HashSet<>();
        State initState = new State(0, 0); 
        queue.add(initState);
        v.add(initState);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                State state = queue.poll();
                if(state.jug1Vol == targetCapacity || state.jug2Vol == targetCapacity || state.jug1Vol + state.jug2Vol == targetCapacity) {
                    return true;
                } else {
                    // Fill J1
                    State state1 = new State(jug1Capacity, state.jug2Vol);
                    if(!v.contains(state1)) {
                        v.add(state1);
                        queue.add(state1);
                    }

                    // Fill J2
                    State state2 = new State(state.jug1Vol, jug2Capacity);
                    if(!v.contains(state2)) {
                        v.add(state2);
                        queue.add(state2);
                    }                   

                    // Empty J1
                    State state3 = new State(0, state.jug2Vol);
                    if(!v.contains(state3)) {
                        v.add(state3);
                        queue.add(state3);
                    }                    

                    // Empty J2
                    State state4 = new State(state.jug1Vol, 0);
                    if(!v.contains(state4)) {
                        v.add(state4);
                        queue.add(state4);
                    }    

                    // J1 -> J2
                    int J1Vol = 0, J2Vol = 0;
                    if(state.jug1Vol + state.jug2Vol >= jug2Capacity) {
                        J1Vol = state.jug1Vol + state.jug2Vol - jug2Capacity;
                        J2Vol = jug2Capacity;
                    } else {
                        J1Vol = 0;
                        J2Vol = state.jug1Vol + state.jug2Vol;
                    }

                    State state5 = new State(J1Vol, J2Vol);
                    if(!v.contains(state5)) {
                        v.add(state5);
                        queue.add(state5);
                    }                     

                    // J2 -> J1
                    J1Vol = 0; 
                    J2Vol = 0;
                    if(state.jug1Vol + state.jug2Vol >= jug2Capacity) {
                        J1Vol = jug1Capacity;
                        J2Vol = state.jug1Vol + state.jug2Vol - jug1Capacity;
                    } else {
                        J2Vol = 0;
                        J1Vol = state.jug1Vol + state.jug2Vol;
                    }

                    State state6 = new State(J1Vol, J2Vol);
                    if(!v.contains(state6)) {
                        v.add(state6);
                        queue.add(state6);
                    }
                }
            }
        }

        return false;
    }
}</code></pre>
</div>
</div>
