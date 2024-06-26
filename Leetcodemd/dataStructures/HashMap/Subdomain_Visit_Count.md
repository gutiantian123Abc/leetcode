<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*811. Subdomain Visit Count
A website domain like "discuss.leetcode.com"
consists of various subdomains.
At the top level, we have "com", at the next
level, we have "leetcode.com", and at the lowest
level, "discuss.leetcode.com".
When we visit a domain like
"discuss.leetcode.com", we will also visit the
parent domains "leetcode.com" and "com"
implicitly.
Now, call a "count-paired domain" to be a count
(representing the number of visits this domain
received), followed by a space,
 followed by the address. An example of a count-
paired domain might be "9001
discuss.leetcode.com".
We are given a list cpdomains of count-paired
domains. We would like a list of count-paired
domains,
 (in the same format as the input, and in any
order), that explicitly counts the number of
visits to each subdomain.
Example 1:
Input:
["9001 discuss.leetcode.com"]
Output:
["9001 discuss.leetcode.com", "9001 leetcode.com",
"9001 com"]
Explanation:
We only have one website domain:
"discuss.leetcode.com". As discussed above, the
subdomain "leetcode.com" and "com" will also be
visited.
 So they will all be visited 9001 times.
Example 2:
Input:
["900 google.mail.com", "50 yahoo.com", "1
intel.mail.com", "5 wiki.org"]
Output:
["901 mail.com","50 yahoo.com","900
google.mail.com","5 wiki.org","5 org","1
intel.mail.com","951 com"]
Explanation:
We will visit "google.mail.com" 900 times,
"yahoo.com" 50 times, "intel.mail.com" once and
"wiki.org" 5 times.
For the subdomains, we will visit "mail.com" 900 +
1 = 901 times, "com" 900 + 50 + 1 = 951 times, and
"org" 5 times.
Notes:
The length of cpdomains will not exceed 100.
The length of each domain name will not exceed
100.
Each address will have either 1 or 2 "."
characters.
The input count in any count-paired domain will
not exceed 10000.
The answer output can be returned in any order.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<String>();
        for(String domain : cpdomains) {
            Integer num = Integer.parseInt(domain.split(" ")[0]);
            String dom = domain.split(" ")[1];
            addToMap(map, dom, num);
    
            String[] parts =  dom.split("\\.");
                        
            if(parts.length == 3) { // 2.
                String midPart = parts[1] + "." + parts[2];
                addToMap(map, midPart, num);   
            }
            
            String lastPart = parts[parts.length - 1];
            addToMap(map, lastPart, num); 
        }
        
        for(String key : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(key));
            sb.append(" ");            
            sb.append(key);
            ans.add(sb.toString());
        }
        
        return ans;
    }
    
    private void addToMap(HashMap<String, Integer> map, String key, int num) {
        if(!map.containsKey(key)) {
            map.put(key, num);
        }else {
            map.put(key, map.get(key) + num);
        }
    }
}
</code></pre>
</div>
</div>
