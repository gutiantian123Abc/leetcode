/* 767. Reorganize String

Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

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
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }

            map.put(c, map.get(c) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return b.getValue() - a.getValue(); 
        });

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size() >= 2) {
            Map.Entry<Character, Integer> first = pq.poll();
            Map.Entry<Character, Integer> second = pq.poll();
            sb.append(first.getKey());
            sb.append(second.getKey());
            first.setValue(first.getValue() - 1);
            second.setValue(second.getValue() - 1);
            if(first.getValue() > 0) {
                pq.add(first);
            }

            if(second.getValue() > 0) {
                pq.add(second);
            }
        }

        if(pq.size() != 0) {
            Map.Entry<Character, Integer> last = pq.poll();
            if (last.getValue() > 1) {
                return "";
            } else {
                sb.append(last.getKey());
            }
        }

        return sb.toString();    
    }
}