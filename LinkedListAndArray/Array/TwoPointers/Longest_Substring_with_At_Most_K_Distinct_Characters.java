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

//详解参见 Fruit Basket
//O(n), Space(K)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] S = s.toCharArray();
        int i = 0, j = 0;
        int max = 0;
        while(j < S.length) {
            map.put(S[j], map.getOrDefault(S[j], 0) + 1);
            while(map.size() > k) {
                map.put(S[i], map.get(S[i]) - 1);
                if(map.get(S[i]) == 0) {
                    map.remove(S[i]);
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        
        return max;
    }
}