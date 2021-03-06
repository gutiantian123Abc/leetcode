/* Longest Substring with At Most K Distinct Characters

Given a string s, find the length of the longest substring T that contains at most k distinct characters.
Example
For example, Given s = "eceba", k = 3,

T is "eceb" which its length is 4.

Challenge 
O(n), n is the size of the string s.
*/

public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here     
        /* 窗口类指针移动模板
        int j = 0;

        for(int i = 0; i < nums.length; i++) {

            while(j < nums.length) {
                if(满足条件) {
                    j++;
                    更行j状态
                }else{
                    break;
                }
            }

            更新i状态
        }
      */

        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int j = 0;
        
        for(int i = 0; i < s.length(); i++) {
            while(j < s.length()) { //注意这里j, 始终是j比合格的多出一位
                if(map.size() < k) {
                    if(map.containsKey(s.charAt(j))) {
                        map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                    }else {
                        map.put(s.charAt(j), 1);
                    }
                    j++;
                }else if(map.size() == k) {
                     if(map.containsKey(s.charAt(j))) {//注意这里j, 始终是j比合格的多出一位
                        map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                        j++;
                    }else {//注意这里j, 始终是j比合格的多出一位
                         break;
                    }                   
                }
                else {
                    break;
                }
            }
        
            ans = Math.max(ans, j - i);
            
            if(map.containsKey(s.charAt(i))) { //最好加上条件， 不行再不加
                int count = map.get(s.charAt(i));
                if(count > 1) {
                    map.put(s.charAt(i), count - 1);
                }else {
                    map.remove(s.charAt(i));
                }
            }
        }
        return ans;
    }
}