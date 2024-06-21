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
/*  Simplify Path
Given an absolute path for a file (Unix-style), simplify it.

Example
"/home/", => "/home"
"/a/./b/../../c/", => "/c"
Challenge 
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/
/* BackGround Knowledge:
/a/./ -> still in /a
/a/./b -> in /a/b
.. -> go "up" one level
/a/./b/.. -> /a/b/.. -> /a
/a/./b/../.. -> /a/.. -> /
/a/./b/../../c -> /c
*/
    /**
     * @param path the original path
     * @return the simplified path
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


public class Solution {
    public String simplifyPath(String path) {
        // Write your code here
        String result = "/";
        String[] arr = path.split("/+");// path.split("/+") 注意，String.split("/+") 一个或多个"/"
        ArrayList<String> list = new ArrayList<String>();
        for(String str : arr) {
            if(str.equals("..")) {
                if(list.size() > 0) {
                    list.remove(list.size() - 1);
                }
            }else if(!str.equals(".") && !str.equals("")){ //注意可能发生str.equals("")的情况
                list.add(str);
            }
        }
        
        for(String str : list) {
            result = result + str + "/";
        }
        
        if(result.length() > 1) {
            return result.substring(0, result.length() - 1);
        }
        return "/";
    }
}</code></pre>
</div>
</div>
