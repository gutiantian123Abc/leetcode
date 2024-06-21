<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 1000px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 165. Compare Version Numbers

https://leetcode.com/problems/compare-version-numbers/

Given two version numbers, version1 and version2, compare them.

Version numbers consist of one or more revisions joined by a dot '.'. 
Each revision consists of digits and may contain leading zeros. 
Every revision contains at least one character. 
Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, 
the next revision being revision 1, and so on. 
For example 2.5.33 and 0.1 are valid version numbers.


To compare version numbers, compare their revisions in left-to-right order. 
Revisions are compared using their integer value ignoring any leading zeros. 
This means that revisions 1 and 001 are considered equal. 
If a version number does not specify a revision at an index, 
then treat the revision as 0. 
For example, version 1.0 is less than version 1.1 because their revision 0s are the same, 
but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:

If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.
 

Example 1:
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".


Example 2:
Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: version1 does not specify revision 2, which means it is treated as "0".


Example 3:
Input: version1 = "0.1", version2 = "1.1"
Output: -1
Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, 
so version1 < version2.
 

Constraints:

1 <= version1.length, version2.length <= 500
version1 and version2 only contain digits and '.'.
version1 and version2 are valid version numbers.
All the given revisions in version1 and version2 can be stored in a 32-bit integer.
*/
        /*
        In Java, the split method takes a regular expression as its argument, 
        and the period (.) is a special character in regular expressions that 
        matches any character. To split the version strings by the literal period character, 
        you need to escape the period in your regular expression. 
        You can do this by using "\\." instead of just ".".
        */ 
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int compareVersion(String version1, String version2) {
        // Important!!! version1.split("\\.")
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n1 = v1.length, n2 = v2.length, i = 0;
        while(i < Math.min(n1, n2)) {
            //Integer.parseInt(str) will take int value of a string igoring any leading 0s
            int v1IntValue = Integer.parseInt(v1[i]);
            int v2IntValue = Integer.parseInt(v2[i]);
            if(v1IntValue > v2IntValue) {
                return 1;
            } else if(v1IntValue < v2IntValue) {
                return -1;
            } else {
                 i++;
            }
        }

        if(n1 == n2) {
            return 0;
        } else if(n1 > n2) {
            while(i < n1) {
                if(Integer.parseInt(v1[i]) > 0) {
                    return 1;
                }
                i++;
            }

        } else { // n1 < n2
            while(i < n2) {
                if(Integer.parseInt(v2[i]) > 0) {
                    return -1;
                }
                i++;
            }
        }

        return 0;
    }
}</code></pre>
</div>
</div>
