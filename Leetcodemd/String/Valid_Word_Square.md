<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*888. Valid Word Square
Given a sequence of words, check whether it forms a valid word square.
A sequence of words forms a valid word square if the k^th row and column read
the exact same string, where 0 ≤ k < max(numRows, numColumns).
Example
Given
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]
return true
Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crmy".
The fourth row and fourth column both read "dtye".
Therefore, it is a valid word square.
Given
[
  "abcd",
  "bnrt",
  "crm",
  "dt"
]
return true
Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crm".
The fourth row and fourth column both read "dt".
Therefore, it is a valid word square.
Given
[
  "ball",
  "area",
  "read",
  "lady"
]
return false
Explanation:
The third row reads "read" while the third column reads "lead".
Therefore, it is NOT a valid word square.
Notice
The number of words given is at least 1 and does not exceed 500.
Word length will be at least 1 and does not exceed 500.
Each word contains only lowercase English alphabet a-z.*/
    /**
     * @param words: a list of string
     * @return: a boolean
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public boolean validWordSquare(String[] words) {
        // Write your code here
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                if(j >= words.length || i >= words[j].length() || words[i].charAt(j) != words[j].charAt(i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
</code></pre>
</div>
</div>
