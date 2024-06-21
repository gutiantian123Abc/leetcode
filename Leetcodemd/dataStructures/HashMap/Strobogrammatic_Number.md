## Problem Description
```
/* Strobogrammatic Number
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

Example 1:

Input:  "69"
Output: true
Example 2:

Input:  "88"
Output: true
Example 3:

Input:  "962"
Output: false
*/
## Solution
```java

class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        
        int start = 0, end = num.length() - 1;
        
        while(start <= end) {
            if(!map.containsKey(num.charAt(start))) {
                return false;
            }
            
            if(map.get(num.charAt(start)) != num.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
        
    }
}