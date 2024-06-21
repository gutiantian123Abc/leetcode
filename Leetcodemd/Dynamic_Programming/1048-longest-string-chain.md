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
/* 1048. Longest String Chain

https://leetcode.com/problems/longest-string-chain/

You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere 
in wordA without changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is 
a predecessor of word2, word2 is a predecessor of word3, and so on. 
A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.

 

Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
Example 2:

Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
Example 3:

Input: words = ["abcd","dbqca"]
Output: 1
Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of lowercase English letters.

*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b) -> {
            return a.length() - b.length();
        });
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            dp.put(word, 1);
        }

        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if(word.length() > 1) {
                List<String> shortWords = removeOneChar(word);
                int maxSubLen = 0;
                for(String shortWord : shortWords) {
                    if(dp.keySet().contains(shortWord) && dp.get(shortWord) + 1 > dp.get(word)) {
                        dp.put(word, dp.get(shortWord) + 1);
                    }
                }
            }
        }

        int maxLen = 0;

        for(String word : dp.keySet()) {
            maxLen = Math.max(maxLen, dp.get(word));
        }

        return maxLen;
    }

    private List<String> removeOneChar(String word) {
        List<String> words = new ArrayList<>();
        for(int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            sb.deleteCharAt(i);
            if(!words.contains(sb.toString())) {
                words.add(sb.toString());
            }
        }

        return words;
    }
}</code></pre>
</div>
</div>
