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
/* Longest Substring with At Most K Distinct Characters
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
*/
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//详解参见 Fruit Basket
//O(n), Space(K)
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] S = s.toCharArray();
        int i = 0, j = 0;
        while(j < S.length) {
            while(map.size() <= k && j < S.length) {
                map.put(S[j], map.getOrDefault(S[j], 0) + 1);
                j++;
            }
            
            if(map.size() == k + 1) {
                ans = Math.max(ans, j - 1 - i);
            }else {
                ans = Math.max(ans, j - i);
            }
            
            map.put(S[i], map.get(S[i]) - 1);
            if(map.get(S[i]) == 0) {
                map.remove(S[i]);
            }
            i++;
        }
        
        return ans;
    }
}</code></pre>
</div>
</div>
