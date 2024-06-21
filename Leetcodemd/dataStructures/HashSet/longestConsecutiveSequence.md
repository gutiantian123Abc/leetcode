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
/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
Your algorithm should run in O(n) complexity.

Example
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
*/
    /**
     * @param nums: A list of integers
     * @return an integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n : num) {
            set.add(n);
        }
        int longest = 0;
        for(int i = 0; i < num.length; i++) {
            int up = num[i] + 1;
            while(set.contains(up)) {
                set.remove(up);
                up++;
            }
            
            int down = num[i] - 1;
            while(set.contains(down)) {
                set.remove(down);
                down--;
            }
            
            longest = Math.max(longest, up - down - 1);
        } 
        return longest;
    }
}</code></pre>
</div>
</div>
