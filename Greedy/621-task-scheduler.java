/* 621. Task Scheduler
https://leetcode.com/problems/task-scheduler/description/

Given a characters array tasks, representing the tasks a CPU needs to do, 
where each letter represents a different task. Tasks could be done in any order. 
Each task is done in one unit of time. For each unit of time, 
the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period 
between two same tasks (the same letter in the array), that is that there 
must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 

Constraints:

1 <= task.length <= 104
tasks[i] is upper-case English letter.
The integer n is in the range [0, 100].
*/

class Solution {
    class Task {
        int freq;
        int t;

        public Task(int freq, int t) {
            this.freq = freq;
            this.t = t;
        }
    }
    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            int T1 = a.t, T2 = b.t, F1 = a.freq, F2 = b.freq;
            if(T1 == T2) {
                return F2 - F1;
            } else {
                return T1 - T2;
            }
        });

        HashMap<Character, Integer> fqMap = new HashMap<>();
        for(char c : tasks) {
            fqMap.put(c, fqMap.getOrDefault(c, 0) + 1);
        }


        boolean[] v = new boolean[26];
        for(char c : tasks) {
            if(!v[c - 'A']) {
                pq.offer(new Task(fqMap.get(c), 0));
                v[c - 'A'] = true;
            }
        }

        int curTime = 0;

        while(!pq.isEmpty()) {
            Task task = pq.poll();
            int freq = task.freq;
            int unlockTime = task.t;

            if(curTime < unlockTime) {
                pq.offer(task);
            } else {
                freq--;
                unlockTime += n + 1;
                if(freq > 0) {
                    pq.offer(new Task(freq, unlockTime));
                }
            }
            curTime++;
        }

        return curTime;
    }
}
