## Problem Description
```
/* Generalized Abbreviation
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", 
"1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
*/
/*
思路： 1. When keeping char,append num(>0) and add char to solution, keep backtracking
      2. When abbreviating char, increase num and keep backtracking
*/
## Solution
```java


class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        int pos = 0;
        int count = 0;
        String cur = "";
        dfs(word, res, pos, cur, count);
        return res;
    }
    
    private void dfs(String word, List<String> res, int pos, String cur, int count) {
        if(pos == word.length()) {
            if(count != 0) {
                cur += Integer.toString(count);
            }
            res.add(cur);
        }else {
            //abb word[pos]
            dfs(word, res, pos + 1, cur, count + 1);
            
            //not abb word[pos]
            if(count != 0) {
                cur += Integer.toString(count);
            }
            
            dfs(word, res, pos + 1, cur + word.charAt(pos), 0);
        }     
    }
}








