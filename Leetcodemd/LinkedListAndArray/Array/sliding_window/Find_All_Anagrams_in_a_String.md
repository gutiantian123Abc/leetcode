<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Find All Anagrams in a String
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will 
not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if(s == null || p == null || p.length() > s.length() || p.length() < 1) {
            return result;
        }
        
        int k = p.length();
        if(k == 1) {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == p.charAt(0)) {
                    result.add(i);
                }
            }
            return result;
        }
        
        int[] freq = new int[26];
        for(int i = 0; i < k; i++) {
            freq[p.charAt(i) - 'a']--;
        }
        
        for(int i = 0; i < k - 1; i++) {  //注意， sliding window
            freq[s.charAt(i) - 'a']++;
        }
        
        int index = 0;
        for(int i = k - 1; i < s.length(); i++) { //注意， sliding window
            freq[s.charAt(i) - 'a']++;
            if(check(freq)) {
                result.add(index);
            }
            freq[s.charAt(index) - 'a']--;
            index++;
        }
        
        return result;
    
    }
    
    
    private boolean check(int[] freq) {
        for(int i = 0; i < 26; i++) {
            if(freq[i] != 0) {
                return false;
            }
        }
        
        return true;
    }

}</code></pre>
</div>
</div>
