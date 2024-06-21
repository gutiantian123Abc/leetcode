<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* First Unique Character in a String
Find the first unique character in a given string. 
You can assume that there is at least one unique character in the string.

Example
For "abaccdeff", return 'b'.
*/
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//这道题更好的方法是 First_Unique_Number_In_Stream， HashMap + LinkedList 

public class Solution {
    public char firstUniqChar(String str) {
        // Write your code here
        HashSet<Character> dups = new HashSet<>();
        HashMap<Character, Integer> singles = new HashMap<>();
        
        char[] words = str.toCharArray();
        
        for(int i = 0; i < words.length; i++) {
            char c = words[i];
            
            if(dups.contains(c)) {
                continue;
            }else {
                if(singles.containsKey(c)) {
                    singles.remove(c);
                    dups.add(c);
                }else {
                    singles.put(c, i);
                }
            }
        }
        
        int minIndex = words.length - 1;
        char ans = words[minIndex];
        
        for(char key : singles.keySet()) {
            if(singles.get(key) < minIndex) {
                minIndex = singles.get(key);
                ans = key;
            }
        }
        
        return ans;
        
    }
}</code></pre>
</div>
</div>
