## Problem Description
```
/* 914. Flip Game
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

Example
Given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].
*/
    /**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
## Solution
```java

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
        List<String> ans = new ArrayList<>();
        
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                String str = s.substring(0, i - 1) + "--";
                if(i < s.length() - 1) {
                    str += s.substring(i + 1, s.length());
                }
                ans.add(str);
            }
        }
        return ans;
    }
}