<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* First Bad Version
The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case, 
so it caused this version and the following versions are all failed in the unit tests. Find the first bad version.
You can call isBadVersion to help you determine which version is the first bad one. 
The details interface can be found in the code's annotation part.

Notice
Please read the annotation in code area to get the correct way to call isBadVersion in different language. 
For example, Java is SVNRepo.isBadVersion(v)

Example
Given n = 5:

isBadVersion(3) -> false
isBadVersion(5) -> true
isBadVersion(4) -> true
*/
/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int findFirstBadVersion(int n) {
        // write your code here
        if(n == 1) {
            return 1;
        }
        
        if(n == 2) {
            if(SVNRepo.isBadVersion(1)) {
                return 1;
            }else {
                return 2;
            }
        }
        int start = 1;
        int end = n;
        while(start + 1 < end) {
            int mid = start +(end - start) / 2;
            if (SVNRepo.isBadVersion(mid) == true) {
                end = mid;
            }else {
                start = mid;
            }
        }
        
        if(SVNRepo.isBadVersion(start) == true) {
            return start;
        }
        return end;
    }
}
</code></pre>
</div>
</div>
