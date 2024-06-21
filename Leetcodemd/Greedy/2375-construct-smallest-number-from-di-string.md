<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 600px; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 2375. Construct Smallest Number From DI String
https://leetcode.com/problems/construct-smallest-number-from-di-string/description/

You are given a 0-indexed string pattern of length n 
consisting of the characters 'I' meaning increasing 
and 'D' meaning decreasing.

A 0-indexed string num of length n + 1 is created using 
the following conditions:

num consists of the digits '1' to '9', where each digit 
is used at most once.

If pattern[i] == 'I', then num[i] < num[i + 1].
If pattern[i] == 'D', then num[i] > num[i + 1].
Return the lexicographically smallest possible string num 
that meets the conditions.


Example 1:

Input: pattern = "IIIDIDDD"
Output: "123549876"
Explanation:
At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
Some possible values of num are "245639871", "135749862", 
and "123849765".

It can be proven that "123549876" is the smallest possible 
num that meets the conditions.
Note that "123414321" is not possible because the digit '1' is 
used more than once.
Example 2:

Input: pattern = "DDD"
Output: "4321"
Explanation:
Some possible values of num are "9876", "7321", and "8742".
It can be proven that "4321" is the smallest possible num that 
meets the conditions.
 

Constraints:

1 <= pattern.length <= 8
pattern consists of only the letters 'I' and 'D'.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public String smallestNumber(String pattern) {
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int number = 1;

        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);

            if(c == 'I') {
                stack.push(number++);

                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            } else { // 'D'
                stack.push(number++);
            }
        }
        
        stack.push(number);

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
}</code></pre>
</div>
</div>
