/* Minimum Window Substring
Given a string source and a string target, find the minimum window in source which will contain all the characters in target.

Notice

If there is no such window in source that covers all characters in target, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.

Clarification
Should the characters in minimum window has the same order in target?

Not necessary.
Example
For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"

Challenge 
Complexity O(n)
*/

public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */

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
    public String minWindow(String source, String target) {
        // write your code
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        int[] targetHeatingMap = new int[256];
        int[] sourceHeatingMap = new int[256];
        
        initiateTargetHeatingMap(targetHeatingMap, target);
        int j = 0;
        
        for(int i = 0; i < source.length(); i++) {
            while(j < source.length()) {
                if(!contains(sourceHeatingMap, targetHeatingMap)) {
                    sourceHeatingMap[source.charAt(j)]++;
                    j++;
                }else {
                    break;
                }
            }
            
            
            if(contains(sourceHeatingMap, targetHeatingMap)) { //记住， 这里check 是否可行
                if(minLen > j - i) {
                    minLen = j - i;
                    ans = source.substring(i, j);
                }
            }
            
            sourceHeatingMap[source.charAt(i)]--;//不管上面是否可行， 这里都要Update i status!!!
            
        }
        
        return ans;
    }
    
    private void initiateTargetHeatingMap(int[] targetHeatingMap, String target) {
        for(int i = 0; i < target.length(); i++) {
            targetHeatingMap[target.charAt(i)]++;
        }
    }
    
    private boolean contains(int[] sourceHeatingMap, int[] targetHeatingMap) {
        for(int i = 0; i < 256; i++) {
            if(sourceHeatingMap[i] < targetHeatingMap[i]) {
                return false;
            }
        }
        return true;
    }
}

/* 额外知识点: Heating Map int[256], 
用以查看source String 是否包含 target String, 这里不考虑顺序！！！
    private boolean contains(int[] sourceHeatingMap, int[] targetHeatingMap) {
        for(int i = 0; i < 256; i++) {
            if(sourceHeatingMap[i] < targetHeatingMap[i]) {
                return false;
            }
        }
        return true;
    }
*/