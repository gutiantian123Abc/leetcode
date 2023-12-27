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


/* String Permutation II
Given a string, find all permutations of it without duplicates.

Example
Given "abb", return ["abb", "bab", "bba"].

Given "aabb", return ["aabb", "abab", "baba", "bbaa", "abba", "baab"].
这道题就是permutaions II
*/
public class Solution {
    /*
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if(str == null) {
            return result;
        }
        
        char[] word = str.toCharArray();
        Arrays.sort(word);
        
        int[] visited = new int[word.length];
        
        dfs(word, visited, new StringBuilder(), result);
        
        return result;
    }
    
    private void dfs(char[] word, int[] visited, StringBuilder sb, List<String> result) {
        if(sb.length() == word.length) {
            result.add(sb.toString());
            return;
        }
        
        for(int i = 0; i < word.length; i++) {
            if ( visited[i] == 1 || ( i != 0 && word[i] == word[i - 1] && visited[i-1] == 0)){
                continue;
            }
             /*
            上面的判断主要是为了去除重复元素影响。
            比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
            我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
            当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
            不应该让后面的2使用。
            */           
            sb.append(word[i]);
            visited[i] = 1;
            dfs(word, visited, sb, result);
            visited[i] = 0;
            sb.deleteCharAt(sb.length() - 1); //sb.deletaCharAt();
        }
    }
}











