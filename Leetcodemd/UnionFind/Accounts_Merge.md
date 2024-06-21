<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Accounts Merge
Given a list accounts, each element accounts[i] is a list of strings, 
where the first element accounts[i][0] is a name, and the rest of the 
elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely 
belong to the same person if there is some email that is common to both accounts.
 Note that even if two accounts have the same name, they may belong to 
 different people as people could have the same name. 
 A person can have any number of accounts initially, but all of their accounts 
 definitely have the same name.

After merging the accounts, return the accounts in the following format: 
the first element of each account is the name, and the rest of the elements 
are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], 
["John", "johnnybravo@mail.com"], 
["John", "johnsmith@mail.com", "john_newyork@mail.com"], 
["Mary", "mary@mail.com"]]

Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
["John", "johnnybravo@mail.com"], 
["Mary", "mary@mail.com"]]

Explanation: 
The first and third John's are the same person as they have 
the common email "johnsmith@mail.com".
The second John and Mary are different people as none of 
their email addresses are used by other accounts.
We could return these lists in any order, for example the answer 
[['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] 
would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


//Unions Find 经典好题！ 记住，就算Path Compress 了之后，也不一定只有两层
//想要彻底retrieve 所有Unions, 必须创建: HashMap<String, HashSet<String>> Unions,
//遍历所有点， 根据每一个点的Root填充Unions: Unions.put(Root, HashSet<String>);
//记住List.get(int index);
//List.add(int index, String a) : list.add(0, "abc")


class Solution {
    class UnionFind {
        public HashMap<String, String> father;
        public HashMap<String, String> owner;
        public List<List<String>> accounts;
        
        
        public UnionFind() {
            father = new HashMap<String, String>();
            owner = new HashMap<String, String>();
        }
        
        
        public void initialize(List<List<String>> accounts) {
            this.accounts = accounts;
            for(List<String> act : accounts) {
                int index = 0;
                String name = act.get(0);
                for(int i = 1; i < act.size(); i++) {
                    
                    String email = act.get(i);
                    if(!owner.containsKey(email)) {
                        owner.put(email, name);
                    }

                    if(!father.containsKey(email)) {
                        father.put(email, email);
                    }
                }
            }
        }
        
        
        public List<List<String>> accountsMerge() {
            List<List<String>> ans = new ArrayList<>();
            for(List<String> entry : accounts) {
                int index = 0;
                String rootEmail = "";    
                for(String email : entry) {
                    if(index == 0) {
                        index = 1;
                    }else {
                        if(index == 1) {
                            rootEmail = email;
                        }else {
                            if(!atSameGroup(rootEmail, email)) {
                                union(email, rootEmail);
                            }
                        }
                        index++;
                    }    
                }
            }

            HashMap<String, HashSet<String>> Unions = new  HashMap<String, HashSet<String>>();
            
            for(List<String> act : accounts) {
                String p = getRoot(act.get(1));
                if(!Unions.containsKey(p)) {
                    Unions.put(p, new HashSet<String>());
                }
                
                for(int i = 1; i < act.size(); i++) {
                    Unions.get(p).add(act.get(i));
                }
            }
            
            for(String p : Unions.keySet()) {
                String name = owner.get(p);
                List<String> list = new ArrayList<String>();
                list.add(name);
                List<String> emails = new ArrayList<String>(Unions.get(p));
                Collections.sort(emails);
                emails.add(0, name);
                ans.add(emails); 
            }
            return ans; 
        }
        
        
        public String getRoot(String email) {
            if(father.get(email).equals(email)) {
                return email;
            }
            
            String parent = father.get(email);
            
            while(!parent.equals(father.get(parent))) {
                parent = father.get(parent);
            }
            
            //Compress
            String temp = "";
            String fa = email;
            
            while(!father.get(fa).equals(fa)) {
                temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
            }
            
            return parent;
        }
        
        
        public boolean atSameGroup(String email1, String email2) {
            return getRoot(email1).equals(getRoot(email2));
        }
        
        
        public void union(String email1, String email2) {
            String root1 = getRoot(email1);
            String root2 = getRoot(email2);
            father.put(root1, root2);
        }
    }
    

    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind un = new UnionFind();
        un.initialize(accounts);
        return un.accountsMerge(); 
    }
}</code></pre>
</div>
</div>
