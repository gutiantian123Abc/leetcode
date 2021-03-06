/* Expression Expand
Given an expression s includes numbers, letters and brackets.
Number represents the number of repetitions inside the brackets(can be a string or another expression)．
Please expand expression to be a string.
Example
s = abc3[a] return abcaaa
s = 3[abc] return abcabcabc
s = 4[ac]dy, return acacacacdy
s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz
*/

//这道题可以用Stack做， 详见Stack

public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        char[] word = s.toCharArray();
        int number = 0;
        int parent = 0;
        String subString = "";
        StringBuilder sb = new StringBuilder();
        
        for(int index = 0; index < word.length; index++) {
            
            char c = word[index];
            if(c == '[') {
                
                if(parent > 0) {
                    subString = subString + c;
                }
                parent++;
                
            }else if(c == ']') {
                
                if(parent > 0) {
                    parent--;
                }
                
                if(parent == 0) {
                    String expandSubString = expressionExpand(subString);
                    for(int i = 0; i < number; i++) {
                        sb.append(expandSubString);
                    }
                    number = 0;
                    subString = "";
                }else {
                    subString = subString + c;
                }
                
            }else if(c >= '0' && c <= '9') {
                if(parent == 0) {
                    number = 10 * number + c - '0';
                    while(index + 1 < word.length && word[index + 1] >= '0' && word[index + 1] <= '9') {
                        number = 10 * number + word[index + 1] - '0';
                        index++;
                    }
                }else {
                    subString = subString + c;
                }
                
            }else {
                
                if(parent == 0) {
                    sb.append(c);
                }else {
                    subString = subString + c;
                }
                
            }
        }
        
        return sb.toString();
    }
}