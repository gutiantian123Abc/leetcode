<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 400px; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 681. Next Closest Time

https://leetcode.com/problems/next-closest-time/description/


Given a time represented in the format "HH:MM", form the next closest time 
by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" 
are all valid. "1:34", "12:9" are all invalid.

 

Example 1:

Input: time = "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, 
which occurs 5 minutes later.
It is not 19:33, because this occurs 23 hours and 59 minutes later.
Example 2:

Input: time = "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
It may be assumed that the returned time is next day's time since it is smaller 
than the input time numerically.
 

Constraints:

time.length == 5
time is a valid time in the form "HH:MM".
0 <= HH < 24
0 <= MM < 60
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    int curTimeInMin = 0;
    int minDiff = 24 * 60 + 1;
    String res = "";
    Set<Character> charSet = new HashSet<>();
    public String nextClosestTime(String time) {
        String curTime = time.substring(0, 2) + time.substring(3, 5);
        for(int i = 0; i < 4; i++) {
            if(!charSet.contains(curTime.charAt(i))) {
                charSet.add(curTime.charAt(i));
            }
        }
        curTimeInMin = convert(curTime);
        perm(new StringBuilder());
        return res;
    }

    private void perm(StringBuilder sb) {
        String pendingStr = sb.toString();
        if(pendingStr.length() == 4) {
            if(validTime(pendingStr)) {
                int pendingStrInMin = convert(pendingStr);
                if(pendingStrInMin > curTimeInMin) {
                    if((pendingStrInMin - curTimeInMin) < minDiff) {
                        minDiff = pendingStrInMin - curTimeInMin;
                        res = pendingStr.substring(0, 2) + ':' + pendingStr.substring(2, 4);
                    }
                } else if (pendingStrInMin < curTimeInMin){
                    if(24 * 60 - curTimeInMin + pendingStrInMin < minDiff) {
                        minDiff = 24 * 60 - curTimeInMin + pendingStrInMin;
                        res = pendingStr.substring(0, 2) + ':' + pendingStr.substring(2, 4);
                    }
                } else { // Equal
                    if(24 * 60 < minDiff) {
                        minDiff = 24 * 60;
                        res = pendingStr.substring(0, 2) + ':' + pendingStr.substring(2, 4);
                    }   
                }
            }
        } else {
            for(char c : charSet) {
                sb.append(c);
                perm(sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private int convert(String time) {
        // Important: Integer.parseInt(String str) would get the int value of a str without leading 0s
        // Ex: "0087" => "87" 
        int H = Integer.parseInt(time.substring(0, 2));
        int M = Integer.parseInt(time.substring(2, 4));

        return H * 60 + M;
    }

    private boolean validTime(String time) {
        int H = Integer.parseInt(time.substring(0, 2));
        int M = Integer.parseInt(time.substring(2, 4));

        return H >= 0 && H <= 23 && M >= 0 && M <= 59;
    }
}

</code></pre>
</div>
</div>
