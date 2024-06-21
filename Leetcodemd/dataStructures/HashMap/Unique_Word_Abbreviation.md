<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Unique Word Abbreviation
An abbreviation of a word follows the form <first letter><number><last letter>.
 Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. 
A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true


Your ValidWordAbbr object will be instantiated and called as such:
ValidWordAbbr obj = new ValidWordAbbr(dictionary);
boolean param_1 = obj.isUnique(word); 
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class ValidWordAbbr {
    private HashMap<String, HashSet<String>> map = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for(String word : dictionary) {
            if(word.length() > 2) {
                StringBuilder sb = new StringBuilder();
                sb.append(word.charAt(0));
                sb.append(word.length() - 2);
                sb.append(word.charAt(word.length() - 1));
                String key = sb.toString();
                if(!map.containsKey(key)) {
                    map.put(key, new HashSet<String>());
                }
                
                map.get(key).add(word);
            }
        }
    }
    
    public boolean isUnique(String word) {
        if(word.length() <= 2) {
            return true;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(word.length() - 2);
        sb.append(word.charAt(word.length() - 1));
        String key = sb.toString();
        if(!map.containsKey(key)) {
            return true;
        }else {
            return map.get(key).contains(word) && map.get(key).size() == 1;
        }
    }
}

</code></pre>
</div>
</div>
