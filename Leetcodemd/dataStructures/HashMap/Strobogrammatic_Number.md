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
/* Strobogrammatic NumberA strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upsidedown).Write a function to determine if a number is strobogrammatic. The number is represented as a string.Example 1:Input:  "69"Output: trueExample 2:Input:  "88"Output: trueExample 3:Input:  "962"Output: false*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        
        int start = 0, end = num.length() - 1;
        
        while(start <= end) {
            if(!map.containsKey(num.charAt(start))) {
                return false;
            }
            
            if(map.get(num.charAt(start)) != num.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
        
    }
}</code></pre>
</div>
</div>
