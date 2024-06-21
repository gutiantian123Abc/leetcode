<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 500px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 1017. Similar RGB Color
In the following, every capital letter represents some hexadecimal digit from 0 to f.

The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand. For example, "#15c" is 
shorthand for the color "#1155cc".

Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.

Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand 
(that is, it can be represented as some "#XYZ")

Example
Input: color = "#09f166"
Output: "#11ee66"
Explanation:  
The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
This is the highest among any shorthand color.
Notice
color is a string of length 7.
color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f
Any answer which has the same (highest) similarity as the best answer will be accepted.
All inputs and outputs should use lowercase letters, and the output is 7 characters.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public String similarRGB(String color) {
        HashMap<Integer, String> map = buildMap();
        
        String part1 = color.substring(1, 3);
        String part2 = color.substring(3, 5);
        String part3 = color.substring(5, 7);
        
        return "#" + helper(part1, map) + helper(part2, map) + helper(part3, map);
    }
    
    private String helper(String part, HashMap<Integer, String> map) {
        String res = "";
        if(part.charAt(0) == part.charAt(1)) {
            res = part;
        }else {
            int resValue = 0;
            int part_dec_value = Integer.parseInt(part, 16);
            int minDiff = Integer.MAX_VALUE;
            for(Integer key : map.keySet()) {
                if(Math.abs(key - part_dec_value) < minDiff) {
                    minDiff = Math.abs(key - part_dec_value);
                    resValue = key;
                }
            }
            
            res = map.get(resValue);
        }
        
        return res;
    }
    
    private HashMap<Integer, String> buildMap() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(Integer.parseInt("00", 16), "00");
        map.put(Integer.parseInt("11", 16), "11");
        map.put(Integer.parseInt("22", 16), "22");
        map.put(Integer.parseInt("33", 16), "33");
        map.put(Integer.parseInt("44", 16), "44");
        map.put(Integer.parseInt("55", 16), "55");
        map.put(Integer.parseInt("66", 16), "66");
        map.put(Integer.parseInt("77", 16), "77");
        map.put(Integer.parseInt("88", 16), "88");
        map.put(Integer.parseInt("99", 16), "99");
        map.put(Integer.parseInt("aa", 16), "aa");
        map.put(Integer.parseInt("bb", 16), "bb");
        map.put(Integer.parseInt("cc", 16), "cc");
        map.put(Integer.parseInt("dd", 16), "dd");
        map.put(Integer.parseInt("ee", 16), "ee");
        map.put(Integer.parseInt("ff", 16), "ff");
        return map;
    }
}</code></pre>
</div>
</div>
