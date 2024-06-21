## Problem Description
```
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
## Solution
```java

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
}