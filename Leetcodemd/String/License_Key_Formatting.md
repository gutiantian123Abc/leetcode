<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 482. License Key Formatting
You are given a license key represented as a string S which consists only alphanumeric character and dashes. 
The string is separated into N+1 groups by N dashes.

Given a number K, we would want to reformat the strings such that each group contains exactly K characters, 
except for the first group which could be shorter than K, but still must contain at least one character. 
Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.

Given a non-empty string S and a number K, format the string according to the rules described above.

Example 1:
Input: S = "5F3Z-2e-9-w", K = 4

Output: "5F3Z-2E9W"

Explanation: The string S has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.
Example 2:
Input: S = "2-5g-3-J", K = 2

Output: "2-5G-3J"

Explanation: The string S has been split into three parts, each part has 2 characters 
except the first part as it could be shorter as mentioned above.
Note:
The length of string S will not exceed 12,000, and K is a positive integer.
String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
String S is non-empty.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        String tmp = S.replace("-", ""); //注意
        tmp = tmp.toUpperCase();//注意
        
        int firstPartLength = tmp.length() % K;
        int repeatTimes = tmp.length() / K;
        int startReaptingIndex = 0;
        
        StringBuilder sb = new StringBuilder();
        
        if(firstPartLength != 0) { 
            sb.append(tmp.substring(0, firstPartLength));
            startReaptingIndex = firstPartLength;
        }
        
        while(repeatTimes > 0) {
            if(startReaptingIndex == 0) {
                sb.append(tmp.substring(startReaptingIndex, startReaptingIndex + K)); //注意， String.substring(startIndex, startIndex + length())
            }else {
                sb.append("-" + tmp.substring(startReaptingIndex, startReaptingIndex + K));
            }
           
            startReaptingIndex += K;
            repeatTimes--;
        }
        
        return sb.toString();
        
    }
}</code></pre>
</div>
</div>
