/* Decode String
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers,
k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

*/

/* 这道题既可以用dfs(recursion), 也可以用stack
*/

//DFS(Recursion)
class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                int times = 0;
                int j = i;
                while(s.charAt(j) != '[') {
                    times = times * 10 + (s.charAt(j) - '0');
                    j++;
                }
                j++;
                int startIndex = j;
                int count = 1;
                
                while(count != 0) {
                    if(s.charAt(j) == '[') {
                        count++;
                        if(count == 0) {
                            break;
                        }
                    }else if(s.charAt(j) == ']') {
                        count--;
                        if(count == 0) {
                            break;
                        }
                    }
                    j++;
                }
                
                String sub = decodeString(s.substring(startIndex, j));
                //s.substring(startIndex, j)   substring 是从startIndex 到 j - 1
                for(int num = 0; num < times; num++) {
                    sb.append(sub);
                }
                i = j;
                //千万注意， 只要是有for loop, 最后都有无形的i++, 不管你中途改没改i
            }else {
                sb.append(c);
            }   
        }
        return sb.toString();
    }
}