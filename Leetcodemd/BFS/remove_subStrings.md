<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Remove Substrings
Given a string s and a set of n substrings. 
You are supposed to remove every instance of those n substrings from s so that s is of 
the minimum length and output this minimum length.

Example
Given s = ccdaabcdbb, substrs = ["ab", "cd"]
Return 2

Explanation: 
ccdaabcdbb -> ccdacdbb -> cabb -> cb (length = 2)
*/
    /**
     * @param s a string
     * @param dict a set of n substrings
     * @return the minimum length
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int minLength(String s, Set<String> dict) {
        // Write your code here
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        
        int length = s.length();
        queue.offer(s);
        visited.add(s);
        
        while(queue.size() != 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                length = Math.min(word.length(), length);
                
                for(String minus : dict) {
                    int index = word.indexOf(minus);
                    while(index != -1) {
                        String new_word = after_remove(word, index, minus);
                        if(!visited.contains(new_word)) {
                            queue.offer(new_word);
                            visited.add(new_word);
                        }
                        index = word.indexOf(minus, index + 1);//注意indexOf()用法， 另外， 在本题中， 必须对于所有index 进行处理
                    }
                }
            }
        }
        
        return length;
    }
    
    private String after_remove(String word, int index, String minus) {
        String new_word = word.substring(0, index) + word.substring(index + minus.length(), word.length());//注意substring用法
        return new_word;
    }
}
</code></pre>
</div>
</div>
