## Problem Description
```
/* Letter Case Permutation
Given a string S, we can transform every letter individually 
to be lowercase or uppercase to create another string.  
Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length at most 12.
S will consist only of letters or digits.
*/
## Solution
```java

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<String>();
        if(S == null) {
            return list;
        }
        
        if(S.length() == 0) {
            list.add("");
            return list;
        }
        
        helper(S, list, new StringBuilder(), 0);
        
        return list;
    }
    
    private void helper(String S, List<String> list, StringBuilder sb, int index) {
        if(sb.length() == S.length()) {
            list.add(sb.toString());
            return;
        }
        
        for(int i = index; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c >= 0 && c <= 9) {
                sb.append(c);
                helper(S, list, sb, i + 1);
            }else {
                sb.append(c);
                helper(S, list, sb, i + 1);
                sb.deleteCharAt(sb.length() - 1);
                
                if(c >= 'a' && c <= 'z') {
                    sb.append(Character.toUpperCase(c));
                    helper(S, list, sb, i + 1);
                    sb.deleteCharAt(sb.length() - 1);  
                }
                
                if(c >= 'A' && c <= 'Z') {
                    sb.append(Character.toLowerCase(c));
                    helper(S, list, sb, i + 1);
                    sb.deleteCharAt(sb.length() - 1);  
                }   
            }
        }
    }
    
}