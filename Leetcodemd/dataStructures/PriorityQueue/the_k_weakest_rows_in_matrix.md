<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 600px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 1337. The K Weakest Rows in a Matrix
https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

 

Example 1:

Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]
Explanation: 
The number of soldiers in each row is: 
- Row 0: 2 
- Row 1: 4 
- Row 2: 1 
- Row 3: 2 
- Row 4: 5 
The rows ordered from weakest to strongest are [2,0,3,1,4].
Example 2:

Input: mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
Output: [0,2]
Explanation: 
The number of soldiers in each row is: 
- Row 0: 1 
- Row 1: 4 
- Row 2: 1 
- Row 3: 1 
The rows ordered from weakest to strongest are [0,2,3,1].
 

Constraints:

m == mat.length
n == mat[i].length
2 <= n, m <= 100
1 <= k <= m
matrix[i][j] is either 0 or 1.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public class Tuple {
        public int row;
        public int soldiers;
        
        public Tuple(int row, int soldiers) {
            this.row = row;
            this.soldiers = soldiers;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>(k, new Comparator<Tuple>(){
            public int compare(Tuple a, Tuple b) {
                if(a.soldiers > b.soldiers) {
                    return -1;
                }else if(a.soldiers < b.soldiers) {
                    return 1;
                }else {
                    if(a.row > b.row) {
                        return -1;
                    }else if(a.row < b.row) {
                        return 1;
                    }else {
                        return 0;
                    }
                }
            }
        });
        
        
        for(int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for(int j = 0; j < mat[0].length; j++) {
                soldiers += mat[i][j];
            }
            Tuple t = new Tuple(i, soldiers);
            
            pq.add(t);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] ans = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll().row;
        }
        
        return ans;
        
    }
}</code></pre>
</div>
</div>
