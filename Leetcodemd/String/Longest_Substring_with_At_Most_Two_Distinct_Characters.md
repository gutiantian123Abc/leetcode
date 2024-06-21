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
/* 159. Longest Substring with At Most Two Distinct Characters
Given a string s , find the length of the longest substring t  
that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
*/
/* Solution: 
The main idea is to maintain a sliding window with 2 unique characters. 
The key is to store the last occurrence of each character as the value in the hashmap. 
This way, whenever the size of the hashmap exceeds 2, 
we can traverse through the map to find the character with the left most index, 
and remove 1 character from our map. 
Since the range of characters is constrained, we should be able to find the left most index in constant time.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int lo = 0;
        int hi = 0;
        int res = 0;
        
        HashMap<Character, Integer> index = new HashMap<>();
        
        while(hi < s.length()) {
            if(index.size() <= 2) {
                index.put(s.charAt(hi), hi);
                hi++;
            }
            
            if(index.size() > 2) {
                int minIndex = s.length() - 1;
                for(int value : index.values()) {
                    minIndex = Math.min(minIndex, value);
                }
                
                index.remove(s.charAt(minIndex));
                lo = minIndex + 1;
            }
            
            res = Math.max(res, hi - lo);
            
        }
        
        return res;
    
    }
}
</code></pre>
</div>
</div>
