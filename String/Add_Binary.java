/* Add Binary
Given two binary strings, 
return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

class Solution {
    public String addBinary(String a, String b) {
        String shorter = a.length() <= b.length() ? a : b;
        String longer = a.length() > b.length() ? a : b;

        int sIndex = shorter.length() - 1;
        int lIndex = longer.length() - 1;
        
        String res = "";
        int carry = 0;
        
        while(sIndex >= 0) {
            int currSum = (shorter.charAt(sIndex) - '0') + (longer.charAt(lIndex) - '0') + carry;
            if(currSum == 3) {
                currSum = 1;
                carry = 1;
            }else if(currSum == 2) {
                carry = 1;
                currSum = 0;
            }else {
                carry = 0;
            }      
            res = currSum + res;
            sIndex--;
            lIndex--;
        }
        
        while(lIndex >= 0) {
            int currSum = (longer.charAt(lIndex) - '0') + carry;
            if(currSum == 2) {
                carry = 1;
                currSum = 0;
            }else {
                carry = 0;
            }      
            res = currSum + res;            
            lIndex--;
        }
        
        if(carry == 1) {
            res = "1" + res;
        }
        
        return res;
    }
}