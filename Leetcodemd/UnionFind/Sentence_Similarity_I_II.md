<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 500px; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Sentence Similarity I
Given two sentences words1, words2 (each represented as an array of strings), 
and a list of similar word pairs pairs, determine if two sentences are similar.

For example, "great acting skills" and "fine drama talent" are similar, 
if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is not transitive. 
For example, 
if "great" and "fine" are similar, 
and "fine" and "good" are similar, 
"great" and "good" are not necessarily similar.

However, similarity is symmetric. 
For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

Also, a word is always similar with itself. 
For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, 
even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. 
So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

Note:

The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].
*/
/* Sentence Similarity II
Given two sentences words1, words2 (each represented as an array of strings), 
and a list of similar word pairs pairs, determine if two sentences are similar.

For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] 
are similar, if the similar word pairs are pairs = [["great", "good"], 
["fine", "good"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is transitive. 
For example, if "great" and "good" are similar, and "fine" and "good" are similar, 
then "great" and "fine" are similar.

Similarity is also symmetric. 
For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

Also, a word is always similar with itself. 
For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, 
even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. 
So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

Note:

The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1 == null || words2 == null || words1.length != words2.length) {
            return false;
        }
        
        if(words1.length == 0 && words2.length == 0) {
            return true;
        }
        
        HashSet<String> set = new HashSet<>();
        
        for(String[] pair : pairs) {
            set.add(pair[0] + "#" + pair[1]);
        }
        
        for(int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            if(word1.equals(word2)) {
                continue;
            }else {
                if(set.contains(word1 + "#" + word2) || set.contains(word2 + "#" + word1)) {
                    continue;
                }else {
                    return false;
                }
            }
        }
        
        return true;  
    }
}



class Solution {
    //Union Find HasshMap Method
     class UnionFind {
        public HashMap<String, String> father;
        public String[][] pairs;
        public UnionFind(String[][] pairs) {
            father = new HashMap<String, String>();
            this.pairs = pairs;
            for(String[] pair : pairs) {
                String A = pair[0];
                String B = pair[1];

                if(!father.containsKey(A)) {
                    father.put(A, A);
                }

                if(!father.containsKey(B)) {
                    father.put(B, B);
                }            
            }
        }
        
        public void constructDic() {
            for(String[] pair : pairs) {
                String A = pair[0];
                String B = pair[1];
                
                if(!sameUnion(A, B)) {
                    union(A, B);
                }
            }       
        }
        
        public String findRoot(String word) {
            if(father.get(word).equals(word)) {
                return word;
            }
            
            String parent = father.get(word);
            while(!parent.equals(father.get(parent))) {
                parent = father.get(parent);
            }
            
            //Compress
            String temp = " ";
            String fa = word;
            
            while(!fa.equals(father.get(fa))) {
                temp = father.get(fa);
                father.put(fa, parent);
                fa = temp;
            }
            
            
            return parent;  
        }
        
        public boolean contains(String word) {
            return father.containsKey(word);
        }
        
        
        public void union(String word1, String word2) {
            String rootA = findRoot(word1);
            String rootB = findRoot(word2);
            
            if(!rootA.equals(rootB)) {
                father.put(rootA, rootB);
            }
        }
        
        public boolean sameUnion(String word1, String word2) {
            return findRoot(word1).equals(findRoot(word2));
        }
     
    }
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        //Union Find HasshMap Method
        if(words1 == null || words2 == null) {
            return false;
        }
        
        if(words1.length != words2.length) {
            return false;
        }
        
        UnionFind uf = new UnionFind(pairs);
        uf.constructDic();
        int len = words1.length;
        for(int i = 0; i < len; i++) {
            String A = words1[i];
            String B = words2[i];
            if(A.equals(B)) {
                continue;
            }
            if(uf.contains(A) && uf.contains(B)) {
                if(uf.sameUnion(A, B)) {
                    continue;
                }else {
                    return false;
                }
            }else {
                return false;
            }   
        }
        
        return true;  
    }
}</code></pre>
</div>
</div>
