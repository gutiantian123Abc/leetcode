## Problem Description
```
/* 942. DI String Match
https://leetcode.com/problems/di-string-match/description/

A permutation perm of n + 1 integers of all the integers in 
the range [0, n] can be represented as a string s of length n where:

s[i] == 'I' if perm[i] < perm[i + 1], and
s[i] == 'D' if perm[i] > perm[i + 1].
Given a string s, reconstruct the permutation perm and return it. 
If there are multiple valid permutations perm, return any of them.

 

Example 1:

Input: s = "IDID"
Output: [0,4,1,3,2]
Example 2:

Input: s = "III"
Output: [0,1,2,3]
Example 3:

Input: s = "DDI"
Output: [3,2,0,1]
 

Constraints:

1 <= s.length <= 105
s[i] is either 'I' or 'D'.
*/
/* Explanations:
Conceptual Understanding
Basic Idea:

The problem asks us to construct a permutation of 0 to n based on the 'I' 
(increase) and 'D' (decrease) pattern.

The key observation is that whenever we see an 'I', 
we should choose the smallest available number to ensure there's room 
for an increase. Similarly, for 'D', we should choose the largest 
available number to ensure a decrease.

Why Choose Smallest/Largest Number?:

This is to maximize the chances that future characters in the string 
can be satisfied. Choosing extreme values (smallest or largest) keeps
 the middle range open for subsequent characters.

Example:
Let's work through the first 10 characters of the string "IIDDDDDDDI" assuming n = 100.
We'll follow the logic of the algorithm, incrementing low for 'I' and decrementing high 
for 'D'.

Initially, low = 0 and high = 100 (since n = 100).

First Character ('I'):

Place low (which is 0), then increment low. Now, low = 1.
Permutation: [0, _, _, _, _, _, _, _, _, _, ...]
Second Character ('I'):

Place low (now 1), then increment low. Now, low = 2.
Permutation: [0, 1, _, _, _, _, _, _, _, _, ...]
Next Seven Characters ('D'):

For each 'D', place high and decrement high.
After the first 'D': high = 100. Place 100, then high = 99.
Continue this for each subsequent 'D', decrementing high each time.
Permutation evolves as: [0, 1, 100, 99, 98, 97, 96, 95, 94, _, ...]
Tenth Character ('I'):

Place low (which is now 2), then increment low.
Permutation: [0, 1, 100, 99, 98, 97, 96, 95, 94, 2, ...]
So, the first 10 digits of the permutation for "IIDDDDDDDI" with n = 100
are [0, 1, 100, 99, 98, 97, 96, 95, 94, 2].
*/## Solution
```java

class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] A = new int[n + 1];
        int low = 0, high = n;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'I') {
                A[i] = low;
                low++;
            }else{
                A[i] = high;
                high--;
            }
        }

        A[n] = low;
        return A;
        
    }
}

