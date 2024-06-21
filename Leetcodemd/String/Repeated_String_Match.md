## Problem Description
```
/* 686. Repeated String Match
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. 
If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; 
and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.

*/
/* 
解法： 因为A是循环(period)的， 如果把StringBuilder 不断叠加A知道长度大于A + B 长度 && 长度是A的倍数时，
足以涵盖B中的所有循环节点， 若再不涵盖B, 就彻底没有B了
*/
## Solution
```java


class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        
        while(sb.indexOf(B) == -1) {
            if(sb.length() > A.length() + B.length()) {
                return -1;
            }
            sb.append(A);
            count++;
        }
        
        return count;
    }
}