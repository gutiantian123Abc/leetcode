## Problem Description
```
/* Sentence Similarity II
Given two sentences words1, words2 (each represented as an array of strings), 
and a list of similar word pairs pairs, determine if two sentences are similar.

For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, 
if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is transitive. 
For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.

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
## Solution
```java

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
}