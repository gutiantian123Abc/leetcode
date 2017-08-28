/* String Permutation
Given two strings, write a method to decide if one is a permutation of the other.

Example
abcd is a permutation of bcad, but abbe is not a permutation of abe
*/

public class Solution {
    /*
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // write your code here
        int[] count = new int[256]; //ASCII 总共256个
        if(A.length() != B.length()) {
            return false;
        }
        for(int i = 0; i < A.length(); i++) {
            count[(int)A.charAt(i)]++;
            count[(int)B.charAt(i)]--;
        }
        
        for(int i = 0; i < 256; i++) {
            if(count[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}