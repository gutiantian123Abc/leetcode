<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 744px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Top K Frequent Words
Given a list of words and an integer k, return the top k frequent words in the list.

Notice
You should order the words by the frequency of them in the return list, the most frequent one comes first. 
If two words has the same frequency, the one with lower alphabetical order come first.

Example
Given

[
    "yes", "lint", "code",
    "yes", "code", "baby",
    "you", "baby", "chrome",
    "safari", "lint", "code",
    "body", "lint", "code"
]
for k = 3, return ["code", "lint", "baby"].

for k = 4, return ["code", "lint", "baby", "yes"],


Challenge 
Do it in O(nlogk) time and O(n) extra space.
Extra points if you can do it in O(n) time with O(k) extra space approximation algorithms.
*/
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    private class Pair {
        public String word;
        public int freq;
        
        public Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
    
    private Comparator<Pair> pairComparator= new Comparator<Pair>() { //minheap, 记住， top ... largest //就用 minheap, smallest 就用maxheap
        public int compare(Pair a, Pair b) {
            if(a.freq > b.freq) {
                return 1;
            }else if(a.freq < b.freq) {
                return -1;
            }else {
                int diff = a.word.toLowerCase().compareTo(b.word.toLowerCase());
                return -1 * diff;

            }
        }
    };
    
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if(k < 1) {
            return new String[0];
        }
        String[] answer = new String[k];
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) {
            if(!map.containsKey(word)) {
                map.put(word, 1);
            }else {
                map.put(word, map.get(word) + 1);
            }
        }
        
        PriorityQueue<Pair> minheap = new PriorityQueue<>(k, pairComparator);
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int freq = entry.getValue();
            Pair pair = new Pair(word, freq);
            
            minheap.add(pair);
            if(minheap.size() > k) {
                minheap.poll();
            }
        }
        
        
        
        for(int i = k - 1; i >= 0; i--) {
            answer[i] = minheap.poll().word;
        }
        
        return answer;
    }
}</code></pre>
</div>
</div>
