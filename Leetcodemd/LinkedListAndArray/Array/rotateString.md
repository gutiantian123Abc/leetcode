## Problem Description
```
/*Rotate String
Given a string and an offset, rotate string by offset. (rotate from left to right)

Example
Given "abcdefg".

offset=0 => "abcdefg"
offset=1 => "gabcdef"
offset=2 => "fgabcde"
offset=3 => "efgabcd"
*/
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
## Solution
```java

public class Solution {
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(offset == 0 || str == null || str.length == 0) {
            return;
        }
        offset %= str.length;
        reverse(str, 0, str.length - 1);
        reverse(str, 0, offset - 1);
        reverse(str, offset, str.length - 1);
    }
    
    private void reverse(char[] str, int start, int end) {
        while(start < end) {
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
    }
}