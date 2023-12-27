/* Palindrome Partitioning
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

Example
Given s = "aab", return:

[
  ["aa","b"],
  ["a","a","b"]
]

*/

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null) {
            return result;
        }
        List<String> list = new ArrayList<String>();
        dfs(result, list, s, 0);
        return result;
    }
    
    private void dfs(List<List<String>> result, List<String> list, String s, int startIndex) {
        if(startIndex == s.length()) {
            result.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i = startIndex; i < s.length(); i++) {
            String prefix = s.substring(startIndex, i + 1);
            if(!isPalindrome(prefix)) {
                continue;
            }else {
                list.add(prefix);
                dfs(result, list, s, i + 1);
                list.remove(list.size() - 1);
            }
            
        }
    }
    
    private boolean isPalindrome(String s) {
        if(s.length() == 1) {
            return true;
        }
        
        int start = 0, end = s.length() - 1;
        
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}