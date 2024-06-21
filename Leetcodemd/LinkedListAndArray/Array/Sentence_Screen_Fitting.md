<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Sentence Screen Fitting: https://www.lintcode.com/problem/sentence-screen-fitting/description
Given a rows x cols screen and a sentence represented by a list of non-empty words, 
find how many times the given sentence can be fitted on the screen.

Example
Given rows = 2, cols = 8, sentence = ["hello", "world"], retrun 1.

Explanation:
hello---
world---

The character '-' signifies an empty space on the screen.
Given rows = 3, cols = 6, sentence = ["a", "bcd", "e"], return 2.

Explanation:
a-bcd- 
e-a---
bcd-e-

The character '-' signifies an empty space on the screen.
Given rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"], return 1.

Explanation:
I-had
apple
pie-I
had--

The character '-' signifies an empty space on the screen.
Notice
A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word is greater than 0 and won't exceed 10.
1 ≤ rows, cols ≤ 20,000
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int times = 0;
        int index = 0;
        
        for(int r = 0; r < rows; r++) {
            int cx = 0;
            while(cx < cols) {
                int len = sentence[index].length();
                if(cx + len - 1 <= cols - 2) {
                    cx += len + 1;
                    index++;
                }else if(cx + len - 1 == cols - 1) {
                    cx = cols;
                    index++;
                }else {
                    cx = cols;
                }
                
                if(index == sentence.length) {
                    index = 0;
                    times++;
                }
            }
        }
        
        return times;
    }
}
</code></pre>
</div>
</div>
