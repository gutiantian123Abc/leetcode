/* 767. Reorganize String
https://leetcode.com/problems/reorganize-string/description/

Given a string s, rearrange the characters of s so that any two adjacent 
characters are not the same.

Return any possible rearrangement of s or return "" if not possible.
 

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
*/

class Solution {
    class Node {
        char c;
        int freq;

        public Node(char c, int freq) {
            this.freq = freq;
            this.c = c;
        }
    }

    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return b.freq - a.freq;
        });

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Character key : map.keySet()) {
            pq.offer(new Node(key, map.get(key)));
        }

        Node firstNode = pq.poll();
        char prevC = firstNode.c;
        sb.append(prevC);
        firstNode.freq--;
        if(firstNode.freq > 0) {
            pq.offer(firstNode);
        }

        while(!pq.isEmpty()) {
            Node topNode = pq.poll();
            if(topNode.c != prevC) {
                sb.append(topNode.c);
                prevC = topNode.c;
                topNode.freq--;
                if(topNode.freq > 0) {
                    pq.offer(topNode);
                }
            } else {
                if(!pq.isEmpty()) {
                    Node secondTopNode = pq.poll();
                    sb.append(secondTopNode.c);
                    prevC = secondTopNode.c;
                    secondTopNode.freq--;
                    if(secondTopNode.freq > 0) {
                        pq.offer(secondTopNode);
                    }
                    pq.offer(topNode);
                } else {
                    return "";
                }
            }
        }

        return sb.toString();
    }
}