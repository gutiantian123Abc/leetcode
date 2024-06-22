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
/* 643. Longest Absolute File Path
https://www.lintcode.com/problem/longest-absolute-
file-path
Suppose we abstract our file system by a string in
the following manner:
The string
"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
represents:
dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory
subdir1 and a sub-directory subdir2 containing a
file file.ext.
The string
"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\t
subdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
represents:
dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories
subdir1 and subdir2. subdir1 contains a file
file1.ext
and an empty second-level sub-directory
subsubdir1. subdir2 contains a second-level sub-
directory subsubdir2
containing a file file2.ext.
We are interested in finding the longest (number
of characters) absolute path to a file within our
file system.
For example, in the second example above, the
longest absolute path is
"dir/subdir2/subsubdir2/file2.ext",
and its length is 32 (not including the double
quotes).
Given a string representing the file system in the
above format, return the length of the longest
absolute
path to file in the abstracted file system. If
there is no file in the system, return 0.
Example
Give input =
"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" return
20
Notice
The name of a file contains at least a . and an
extension.
The name of a directory or sub-directory will not
contain a ..
Time complexity required: O(n) where n is the size
of the input string.
Notice that a/aa/aaa/file1.txt is not the longest
file path, if there is another path
aaaaaaaaaaaaaaaaaaaaa/sth.png.
*/
    /**
     * @param input: an abstract file system
     * @return: return the length of the longest
absolute path to file
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public int lengthLongestPath(String input) {
        // write your code here
        if(input.length() == 0) {
            return 0;
        }
        int[] sum = new int[input.length() + 1];
        
        String[] parts = input.split("\n");
        int ans = 0;
        
        for(String part : parts) {
            int level = part.lastIndexOf("\t") + 2;
            int len = part.length() - (level - 1);
            if(part.contains(".")) {
                ans = Math.max(ans, sum[level - 1] + len);
            }else {
                sum[level] = sum[level - 1] + len + 1;
            }
        }
        
        return ans;
    }
}</code></pre>
</div>
</div>
