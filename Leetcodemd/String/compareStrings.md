<style>
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Compare Strings
Compare two strings A and B, determine whether A contains all of the characters in B.
The characters in string A and B are all Upper Case letters.

Example
For A = "ABCD", B = "ACD", return true.
For A = "ABCD", B = "AABC", return false.
*/
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public boolean compareStrings(String A, String B) {
        // write your code here
        int[] arr = new int[26]; // 注意这bucket countCompare Strings用法
        
        for(int i = 0; i < A.length(); i++) {
            arr[A.charAt(i) - 'A']++;
        }
        for(int i = 0; i < B.length(); i++) {
            arr[B.charAt(i) - 'A']--;
        }
        
        for(int i = 0; i < 26; i++) {
            if(arr[i] < 0) {
                return false;
            }
        }
        return true;
    }
}</code></pre>
</div>