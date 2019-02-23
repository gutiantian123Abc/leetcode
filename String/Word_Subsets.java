/* Word Subsets
https://leetcode.com/problems/word-subsets/

We are given two arrays A and B of words.  
Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, 
including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a. 
Return a list of all universal words in A.  You can return the words in any order.

 

Example 1:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]
Example 3:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
Output: ["facebook","google"]
Example 4:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
Output: ["google","leetcode"]
Example 5:

Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
Output: ["facebook","leetcode"]
 

Note:

1 <= A.length, B.length <= 10000
1 <= A[i].length, B[i].length <= 10
A[i] and B[i] consist only of lowercase letters.
All words in A[i] are unique: there isn't i != j with A[i] == A[j].

*/

//Approach 1: Reduce to Single Word in B
/*If b is a subset of a, then say a is a superset of b. */

class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        int[] max = new int[26];
        for(String b : B) {
            int[] loc_max = new int[26];
            for(int i = 0; i < b.length(); i++) {
                loc_max[b.charAt(i) - 'a']++;
            }
            
            for(int i = 0; i < 26; i++) {
                max[i] = Math.max(max[i], loc_max[i]);
            }
        }
        
        for(String a : A) {
            int[] loc_max = new int[26];
            for(int i = 0; i < a.length(); i++) {
                loc_max[a.charAt(i) - 'a']++;
            }
            
            boolean flag = true;
            
            for(int i = 0; i < 26; i++) {
                if(loc_max[i] < max[i]) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                res.add(a);
            }
        }
        
        return res;
    }
    
}