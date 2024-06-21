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
/* Decode StringGiven an encoded string, return it's decoded string.The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets isbeing repeated exactly k times.Note that k is guaranteed to be a positive integer.You may assume that the input string is always valid; No extra white spaces, square brackets arewell-formed, etc.Furthermore, you may assume that the original data does not contain any digits and that digits areonly for those repeat numbers,k. For example, there won't be input like 3a or 2[4].Examples:s = "3[a]2[bc]", return "aaabcbc".s = "3[a2[c]]", return "accaccacc".s = "2[abc]3[cd]ef", return "abcabccdcdcdef".*//* 这道题既可以用dfs(recursion), 也可以用stack*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


//DFS(Recursion)
class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                int times = 0;
                int j = i;
                while(s.charAt(j) != '[') {
                    times = times * 10 + (s.charAt(j) - '0');
                    j++;
                }
                j++;
                int startIndex = j;
                int count = 1;
                
                while(count != 0) {
                    if(s.charAt(j) == '[') {
                        count++;
                        if(count == 0) {
                            break;
                        }
                    }else if(s.charAt(j) == ']') {
                        count--;
                        if(count == 0) {
                            break;
                        }
                    }
                    j++;
                }
                
                String sub = decodeString(s.substring(startIndex, j));
                //s.substring(startIndex, j)   substring 是从startIndex 到 j - 1
                for(int num = 0; num < times; num++) {
                    sb.append(sub);
                }
                i = j;
                //千万注意， 只要是有for loop, 最后都有无形的i++, 不管你中途改没改i
            }else {
                sb.append(c);
            }   
        }
        return sb.toString();
    }
}






//Stack 解法
class Solution {
    private class StringItem {
        int times = 0;
        StringBuilder sb = new StringBuilder();
        
        public StringItem(int times) {
            this.times = times;
        }
    }
    
    public String decodeString(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        Stack<StringItem> stack = new Stack<StringItem>();
        stack.push(new StringItem(0));
        int times = 0;
        int index = 0;
        while(index < s.length()) {
            char c = s.charAt(index);
            if(c >= '0' && c <= '9') {
                while(s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    times = times * 10 + (s.charAt(index) - '0');
                    index++;
                }
                index--; //注意细节
            }else if(c == '[') {
                stack.push(new StringItem(times));
                times = 0;
            }else if(c == ']') {
                StringItem st = stack.pop();
                for(int i = 0; i < st.times; i++) {
                    stack.peek().sb.append(st.sb.toString());
                }
            }else {
                stack.peek().sb.append(c);
            }
            index++;
        }

        return stack.pop().sb.toString();
    }
}</code></pre>
</div>
</div>
