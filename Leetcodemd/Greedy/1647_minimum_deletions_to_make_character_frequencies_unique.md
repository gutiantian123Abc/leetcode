<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 600px; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 1647. Minimum Deletions to Make Character Frequencies Unique

A string s is called good if there are no two different characters 
in s that have the same frequency.

Given a string s, return the minimum number of characters you need 
to delete to make s good.

The frequency of a character in a string is the number of times it 
appears in the string. For example, in the string "aab", the frequency 
of 'a' is 2, while the frequency of 'b' is 1.

 

Example 1:

Input: s = "aab"
Output: 0
Explanation: s is already good.
Example 2:

Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
Example 3:

Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end
 (i.e. frequency of 0 is ignored).
 

Constraints:

1 <= s.length <= 105
s contains only lowercase English letters.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
class Solution {
    public int minDeletions(String s) {
        int deletions = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!freqMap.containsKey(c)) {
                freqMap.put(c, 0);
            }
            freqMap.put(c, freqMap.get(c) + 1);

        }

        HashSet<Integer> v = new HashSet<>();


        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        pq.addAll(freqMap.values());

        while(!pq.isEmpty()) {
            int freq = pq.poll(); // Highest freq
            while(freq > 0 && v.contains(freq)) {
                freq--;
                deletions++;
            }

            if(freq > 0) {
                v.add(freq);
            }
        }

        return deletions;
        
    }
}
</code></pre>
</div>
</div>
