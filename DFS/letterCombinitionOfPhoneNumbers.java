/* Letter Combinations of a Phone Number
Super important, this is Cataline Combination problem：
EX: 小明有5个不同编号的苹果， 小红有8个， 小兰有9个， 问他们每人出一个苹果
会有集中可能呀？


Given a digit string excluded 01, 
return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.

Example
Given "23"
Return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
*/

public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0) {
            return res;
        }
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        
        StringBuilder sb = new StringBuilder();
        helper(res, sb, map, digits);
        return res;
    }
    
    private void helper(ArrayList<String> res, StringBuilder sb, HashMap<Character, String> map, String digits) {
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        int digitPointer = sb.length(); // 注意这里是到下一个人的判断，根据sb.length()!!!!!!!
        String values = map.get(digits.charAt(digitPointer));
        for(int i = 0; i < values.length(); i++) {
            sb.append(values.charAt(i));
            helper(res, sb, map, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}