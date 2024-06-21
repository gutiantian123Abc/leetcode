<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 80%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Longest Substring Without Repeating Characters 
Given a string, find the length of the longest substring without repeating characters.

Example
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.

Challenge 
O(n) time
*/
    /**
     * @param s: a string
     * @return: an integer 
     */
/* Longest Substring with At Most K Distinct Characters 
Given a string s, find the length of the longest substring T that contains at most k distinct characters.

Example
For example, Given s = "eceba", k = 3,

T is "eceb" which its length is 4.

Challenge 
O(n), n is the size of the string s.
*/
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        HashSet<Character> set = new HashSet<>();

        int maxLen = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            while(j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            maxLen = Math.max(maxLen, j - i);
            if(set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
            }
            
        }
        
        return maxLen;
    }
}



public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int j = 0;
        int maxLen = 0;
        
        for(int i = 0; i < s.length(); i++) {
            while(j < s.length()) {
                char c = s.charAt(j);
                if(map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                }else {
                    if(map.size() == k) {
                        break;
                    }else {
                        map.put(c, 1);
                    }
                }
                j++;
            }
            
            maxLen = Math.max(maxLen, j - i);
            char e = s.charAt(i);
            if(map.containsKey(e)) {
                if(map.get(e) > 1) {
                    map.put(e, map.get(e) - 1);
                }else {
                    map.remove(e);
                }
            }
        }
        
        return maxLen;
    
    }
}</code></pre>
</div>
</div>
