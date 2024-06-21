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
/* 418. Sentence Screen Fitting

https://leetcode.com/problems/sentence-screen-fitting/

Given a rows x cols screen and a sentence represented as a list of strings, 
return the number of times the given sentence can be fitted on the screen.

The order of words in the sentence must remain unchanged, and a word cannot 
be split into two lines. A single space must separate two consecutive words in a line.

 

Example 1:

Input: sentence = ["hello","world"], rows = 2, cols = 8
Output: 1
Explanation:
hello---
world---
The character '-' signifies an empty space on the screen.


Example 2:

Input: sentence = ["a", "bcd", "e"], rows = 3, cols = 6
Output: 2
Explanation:
a-bcd- 
e-a---
bcd-e-
The character '-' signifies an empty space on the screen.


Example 3:

Input: sentence = ["i","had","apple","pie"], rows = 4, cols = 5
Output: 1
Explanation:
i-had
apple
pie-i
had--
The character '-' signifies an empty space on the screen.
 

Constraints:

1 <= sentence.length <= 100
1 <= sentence[i].length <= 10
sentence[i] consists of lowercase English letters.
1 <= rows, cols <= 2 * 104
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int sentenceIndex = 0, sentenceCount = 0;

        for(int i = 0; i < rows; i++) {
            int spaceRemaning = cols;
            while(spaceRemaning >= sentence[sentenceIndex].length()) {
                spaceRemaning -= sentence[sentenceIndex].length();
                sentenceIndex++;

                if(spaceRemaning > 0) {
                    spaceRemaning--;
                }

                if(sentenceIndex == sentence.length) {
                    sentenceIndex = 0;
                    sentenceCount++;
                }
            }
        }

        return sentenceCount;
        
    }
}
</code></pre>
</div>
</div>
