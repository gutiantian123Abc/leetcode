<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container {{ max-width: 100%; margin: 0 auto; padding: 10px; }}
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Next Closest Time
Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. 
There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. 
For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example 1:

Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  
It is not 19:33, because this occurs 23 hours and 59 minutes later.
Example 2:

Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. 
It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>
class Solution {
    public String nextClosestTime(String time) {
        String Hr = time.substring(0, 2);
        String Min = time.substring(3, 5);
        int current_Time = timeToMinute(Hr, Min);
        ArrayList<String> list = new ArrayList<>();
        dfs(list, "", time);
        int min_time_diff = 23 * 60 + 59;
        String res = "";
        String min_time_tomorrow = "";
        int min_time_tomorrow_min = 23 * 60 + 59;
        for(String str : list) {
            String hr = str.substring(0, 2);
            String min = str.substring(2, 4);
            int tmp_Time = timeToMinute(hr, min);
            if(tmp_Time < min_time_tomorrow_min) {
                min_time_tomorrow_min = tmp_Time;
                min_time_tomorrow = hr + ":" + min;
            }
            
            if(tmp_Time > current_Time && (tmp_Time - current_Time) < min_time_diff) {
                min_time_diff = tmp_Time - current_Time;
                res = hr + ":" + min;
            }
        }
        
        if(res.equals("")) {
            return min_time_tomorrow;
        }
        
        return res;  
    }
    
    private int timeToMinute(String hr, String min) {
        return Integer.parseInt(hr) * 60 + Integer.parseInt(min);
    }
    
    private void dfs(ArrayList<String> list, String str, String time) {
        if(str.length() == 4) {
            int hr = Integer.parseInt(str.substring(0, 2));
            int min = Integer.parseInt(str.substring(2, 4));
            if(hr >= 0 && hr <= 23 && min >= 0 && min <= 59) {
                list.add(str);
            }
            return;
        }
        
        for(int i = 0; i < 5; i++) {
            if(i != 2) {
                char c = time.charAt(i);
                str += c;
                dfs(list, str, time);
                str = str.substring(0, str.length() - 1);
            }
        }
    }
}</code></pre>
</div>
</div>
