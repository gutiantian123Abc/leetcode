## Problem Description
```
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
## Solution
```java


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
}