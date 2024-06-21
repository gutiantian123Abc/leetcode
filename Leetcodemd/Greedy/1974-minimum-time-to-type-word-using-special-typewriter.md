<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 700px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 1974. Minimum Time to Type Word Using Special Typewriterhttps://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/description/There is a special typewriter with lowercase English letters 'a' to 'z'arranged in a circle with a pointer. A character can only be typed ifthe pointer is pointing to that character. The pointer is initiallypointingto the character 'a'.Each second, you may perform one of the following operations:Move the pointer one character counterclockwise or clockwise.Type the character the pointer is currently on.Given a string word, return the minimum number of seconds to type outthe characters in word.Example 1:Input: word = "abc"Output: 5Explanation:The characters are printed as follows:- Type the character 'a' in 1 second since the pointer is initially on 'a'.- Move the pointer clockwise to 'b' in 1 second.- Type the character 'b' in 1 second.- Move the pointer clockwise to 'c' in 1 second.- Type the character 'c' in 1 second.Example 2:Input: word = "bza"Output: 7Explanation:The characters are printed as follows:- Move the pointer clockwise to 'b' in 1 second.- Type the character 'b' in 1 second.- Move the pointer counterclockwise to 'z' in 2 seconds.- Type the character 'z' in 1 second.- Move the pointer clockwise to 'a' in 1 second.- Type the character 'a' in 1 second.Example 3:Input: word = "zjpc"Output: 34Explanation:The characters are printed as follows:- Move the pointer counterclockwise to 'z' in 1 second.- Type the character 'z' in 1 second.- Move the pointer clockwise to 'j' in 10 seconds.- Type the character 'j' in 1 second.- Move the pointer clockwise to 'p' in 6 seconds.- Type the character 'p' in 1 second.- Move the pointer counterclockwise to 'c' in 13 seconds.- Type the character 'c' in 1 second.Constraints:1 <= word.length <= 100word consists of lowercase English letters.*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int minTimeToType(String word) {
        int curIndex = 0, steps = 0;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            int left = Math.abs(curIndex - index);
            int right = Math.min(index, curIndex) + (26 - Math.max(index, curIndex));
            int move = Math.min(left, right);
            steps += move + 1;

            curIndex = index;
        }

        return steps;
        
    }
}</code></pre>
</div>
</div>
