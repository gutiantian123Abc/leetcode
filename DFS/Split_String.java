/*  Split String
Give a string, you can choose to split the string after one character or two adjacent characters,
and make the string to be composed of only one character or two characters. Output all possible results.

Example
Given the string "123"
return [["1","2","3"],["12","3"],["1","23"]]
*/

public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        dfs(res, 0, s, new ArrayList<String>());
        return res;
    }
    
    private void dfs(List<List<String>> res, int index, String s, List<String> list) {
        if(index >= s.length()) {
            res.add(new ArrayList<String>(list));
            return;
        }
        
        //这里不需要for loop, 画好图， 区分于 combination, subset , permutation
        //cut one 
        if(index + 1 <= s.length()) {
            String oneStr = s.substring(index, index + 1);
            list.add(oneStr);
            dfs(res, index + 1, s, list);
            list.remove(list.size() - 1);
        }
            
        //cut two 
        if(index + 2 <= s.length()) {
            String twoStr = s.substring(index, index + 2);
            list.add(twoStr);
            dfs(res, index + 2, s, list);
            list.remove(list.size() - 1);                
        }
        
    }
}