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
/* https://leetcode.com/problems/network-delay-
time/
You are given a network of n nodes, labeled from 1
to n. You are also given times, a list of travel
times as directed edges times[i] = (ui, vi, wi),
where ui is the source node,
vi is the target node, and wi is the time it takes
for a signal to travel from source to target.
We will send a signal from a given node k. Return
the minimum time it takes for all the n nodes to
receive the signal. If it is impossible for all
the n nodes to receive the signal, return -1.
Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k
= 2
Output: 2
Example 2:
Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:
Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
Constraints:
1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no
multiple edges.)
*/
/*
 Dijkstra's Algorithm Time complexity: O(N+Elog⁡N)
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
class Solution {
    public Map<Integer, List<Pair<Integer, Integer>>> neighborMap = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        neighborMap = buildNeighborMap(times);
        Map<Integer, Integer> signalArrivedTimeMap = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            signalArrivedTimeMap.put(i, Integer.MAX_VALUE);
        }
        signalArrivedTimeMap.put(k, 0);

        Map<Integer, List<Integer>> paths = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            paths.put(i, new ArrayList<>());
        }

        dijstra(signalArrivedTimeMap, paths, k);

        int minTime = 0;

        for(int i = 1; i <= n; i++) {
            int signalReceivedTime = signalArrivedTimeMap.get(i);
            if(signalReceivedTime == Integer.MAX_VALUE) {
                return -1;
            } else {
                minTime = Math.max(minTime, signalReceivedTime);
            }

        }

        return minTime;
    }

    private void dijstra(Map<Integer, Integer> signalArrivedTimeMap, Map<Integer, List<Integer>> paths, int k) {
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return a.getKey() - b.getKey();
        });

        pq.add(new Pair<>(k, 0));

        while(pq.size() != 0) {
            int size = pq.size();
            for(int i = 0; i < size; i++) {
                Pair<Integer, Integer> cur = pq.poll();
                int curNode = cur.getKey();
                int curNodeTime = cur.getValue();

                if(curNodeTime > signalArrivedTimeMap.get(curNode)) {
                    continue;
                }

                if(!neighborMap.containsKey(curNode)) {
                    continue;
                }

                for(Pair<Integer, Integer> neighborInfo : neighborMap.get(curNode)) {
                    int neighbor = neighborInfo.getKey();
                    int time = neighborInfo.getValue();
                    if(curNodeTime + time < signalArrivedTimeMap.get(neighbor)) {
                        signalArrivedTimeMap.put(neighbor, curNodeTime + time);
                        pq.add(new Pair<>(neighbor, signalArrivedTimeMap.get(neighbor)));
                        List<Integer> newPath = new ArrayList<>(paths.get(curNode));
                        newPath.add(curNode);
                        paths.put(neighbor, newPath);
                    }
                }
            }
        }
    }



    private Map<Integer, List<Pair<Integer, Integer>>> buildNeighborMap(int[][] times) {
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        for(int[] time : times) {
            int source = time[0];
            int target = time[1];
            int t = time[2];
            if(!map.containsKey(source)) {
                map.put(source, new ArrayList<>());
            }
            Pair<Integer, Integer> pair = new Pair<>(target, t);
            map.get(source).add(pair);
        }

        return map;
    }
}</code></pre>
</div>
</div>
