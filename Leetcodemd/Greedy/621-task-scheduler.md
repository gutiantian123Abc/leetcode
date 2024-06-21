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
/* 2365. Task Scheduler II

https://leetcode.com/problems/task-scheduler-ii/

You are given a 0-indexed array of positive integers tasks, 
representing tasks that need to be completed in order, 
where tasks[i] represents the type of the ith task.

You are also given a positive integer space, which represents 
the minimum number of days that must pass after the completion 
of a task before another task of the same type can be performed.

Each day, until all tasks have been completed, you must either:

Complete the next task from tasks, or
Take a break.
Return the minimum number of days needed to complete all tasks.

 

Example 1:

Input: tasks = [1,2,1,2,3,1], space = 3
Output: 9
Explanation:
One way to complete all tasks in 9 days is as follows:
Day 1: Complete the 0th task.
Day 2: Complete the 1st task.
Day 3: Take a break.
Day 4: Take a break.
Day 5: Complete the 2nd task.
Day 6: Complete the 3rd task.
Day 7: Take a break.
Day 8: Complete the 4th task.
Day 9: Complete the 5th task.
It can be shown that the tasks cannot be completed in less than 9 days.



Example 2:

Input: tasks = [5,8,8,5], space = 2
Output: 6
Explanation:
One way to complete all tasks in 6 days is as follows:
Day 1: Complete the 0th task.
Day 2: Complete the 1st task.
Day 3: Take a break.
Day 4: Take a break.
Day 5: Complete the 2nd task.
Day 6: Complete the 3rd task.
It can be shown that the tasks cannot be completed in less than 6 days.
 

Constraints:

1 <= tasks.length <= 105
1 <= tasks[i] <= 109
1 <= space <= tasks.length

*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

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



class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> freeDayMap = new HashMap<>();
        for(int i = 0; i < tasks.length; i++) {
            int taskId = tasks[i];
            if(!freeDayMap.containsKey(taskId)) {
                freeDayMap.put(taskId, (long)1);
            }
        }

        long curDay = 1;
        int i = 0;
        while(i < tasks.length) {
            int taskId = tasks[i];
            long avaliabileDay = freeDayMap.get(taskId);

            if(curDay >= avaliabileDay) {
                freeDayMap.put(taskId, curDay + space + 1);
                curDay++;
                i++;
            } else {
                curDay = avaliabileDay;
            }
        }
        
        return curDay - 1;
    }
}
</code></pre>
</div>
</div>
