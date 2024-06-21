## Problem Description
```
/* Longest Substring with At Most K Distinct Characters
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
*/
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
## Solution
```java

//详解参见 Fruit Basket
//O(n), Space(K)
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] S = s.toCharArray();
        int i = 0, j = 0;
        while(j < S.length) {
            while(map.size() <= k && j < S.length) {
                map.put(S[j], map.getOrDefault(S[j], 0) + 1);
                j++;
            }
            
            if(map.size() == k + 1) {
                ans = Math.max(ans, j - 1 - i);
            }else {
                ans = Math.max(ans, j - i);
            }
            
            map.put(S[i], map.get(S[i]) - 1);
            if(map.get(S[i]) == 0) {
                map.remove(S[i]);
            }
            i++;
        }
        
        return ans;
    }
}