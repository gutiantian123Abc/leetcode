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
/* Count and SayThe count-and-say sequence is the sequence of integers with thefirst five terms as following:1.     12.     113.     214.     12115.     1112211 is read off as "one 1" or 11.11 is read off as "two 1s" or 21.21 is read off as "one 2, then one 1" or 1211.Given an integer n, generate the nth term of the count-and-say sequence.Note: Each term of the sequence of integers will be represented as a string.Example 1:Input: 1Output: "1"Example 2:Input: 4Output: "1211"*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        
        String ans = "1";
        for(int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int start = 0, end = 0;
            int j = 0;
          
            while(j < ans.length()) { //记住， j = end 时， 一定用while, 不用 for, 因为for 每次自动j++
                start = j;
                end = j;
                while(end < ans.length() && ans.charAt(start) == ans.charAt(end)) {
                    end++;
                }
                int times = end - start;
                char c = ans.charAt(start);
                sb.append(times);
                sb.append(c);
                j = end; 
            } 
            ans = sb.toString();
          
        }
        return ans;
    }
}</code></pre>
</div>
</div>
