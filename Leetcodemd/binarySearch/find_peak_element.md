<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Find Peak Element
There is an integer array which has the following features:

The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peek if:

A[P] > A[P-1] && A[P] > A[P+1]
Find a peak element in this array. Return the index of the peak.

Notice
The array may contains multiple peeks, find any of them.
Example
Given [1, 2, 1, 3, 4, 5, 7, 6]

Return index 1 (which is number 2) or 6 (which is number 7)

Challenge 
Time complexity O(logN)
*/
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
/*Find Peak Element II
There is an integer matrix which has the following features:

The numbers in adjacent positions are different.
The matrix has n rows and m columns.
For all i < m, A[0][i] < A[1][i] && A[n - 2][i] > A[n - 1][i].
For all j < n, A[j][0] < A[j][1] && A[j][m - 2] > A[j][m - 1].
We define a position P is a peek if:

A[j][i] > A[j+1][i] && A[j][i] > A[j-1][i] && A[j][i] > A[j][i+1] && A[j][i] > A[j][i-1]
Find a peak element in this matrix. Return the index of the peak.
Notice
The matrix may contains multiple peeks, find any of them.

Example
Given a matrix:

[
  [1 ,2 ,3 ,6 ,5],
  [16,41,23,22,6],
  [15,17,24,21,7],
  [14,18,19,20,10],
  [13,14,11,10,9]
]
return index of 41 (which is [1,1]) or index of 24 (which is [2,2])

Challenge 
Solve it in O(n+m) time.

If you come up with an algorithm that you thought it is O(n log m) or O(m log n), 
can you prove it is actually O(n+m) or propose a similar but O(n+m) algorithm?
*/
/*
Let T(m,n) as time complexity of finding peak element in an m*n array.
T(m,n) = T(m/2,n/2)+c(m+n)
              = T(m/4,n/4)+c(m+n)+c(m/2+n/2)
              = ...
              = T(1,1) + c(m+n)(1+1/2+1/4+...+1/(m+n))
              = c(2(m+n)) 
              = O(m+n)
*/
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int findPeak(int[] A) {
        // write your code here
        int start = 1, end = A.length - 2; //注意， binary search start end 有可能最后是0 A.length - 1, 在不适用的地方要注意
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            }else if(A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) { //下坡
                end = mid;
            }else if(A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) { //上坡
                start = mid;
            }else {//低谷
                end = mid;
            }
        }
    
        return A[start] > A[end] ? start : end; //不是start, 就是end
    }
}




class Solution {
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        return find(1, A.length - 2, 1, A[0].length - 2, A, true);
    }
    
    private List<Integer> find(int x1, int x2, int y1, int y2, int[][] A, boolean flag) {
        List<Integer> ans = new ArrayList<Integer>();
        if(flag) {
            int midRow = x1 + (x2 - x1) / 2;
            //int max_col = find_max_col(A, y1, y2, midRow);
            int max_col = y1;
            for (int i = y1; i <= y2; ++i)
                if (A[midRow][i] > A[midRow][max_col])
                    max_col = i;
                    
            if(A[midRow - 1][max_col] < A[midRow][max_col] && A[midRow][max_col] < A[midRow + 1][max_col]) { //上小下大, peak一定在下面
                return find(midRow + 1, x2, y1, y2, A, !flag);
            }else if(A[midRow - 1][max_col] > A[midRow][max_col] && A[midRow][max_col] > A[midRow + 1][max_col]) {//上大下小， peak一定在上面
                return find(x1, midRow - 1, y1, y2, A, !flag);
            }else if(A[midRow - 1][max_col] > A[midRow][max_col] && A[midRow][max_col] < A[midRow + 1][max_col]) {//凹， 两边都行
                return find(midRow + 1, x2, y1, y2, A, !flag);
            }else {//凸， 这就是
                ans.add(midRow);
                ans.add(max_col);
                return ans;
            }
        }else {
            int midCol = y1 + (y2 - y1) / 2;
            //int maxRow = find_max_row(A, x1, x2, midCol);
            int maxRow = x1;
            for (int i = x1; i <= x2; ++i)
                if (A[i][midCol] > A[maxRow][midCol])
                    maxRow = i;
                    
            if(A[maxRow][midCol - 1] < A[maxRow][midCol] && A[maxRow][midCol] < A[maxRow][midCol + 1]) {//左小右大， peak一定在右面
                return find(x1, x2, midCol + 1, y2, A, !flag);
            }else if(A[maxRow][midCol - 1] > A[maxRow][midCol] && A[maxRow][midCol] > A[maxRow][midCol + 1]) {//左大右小， peak一定在左面
                return find(x1, x2, y1, midCol - 1, A, !flag);
            }else if(A[maxRow][midCol - 1] > A[maxRow][midCol] && A[maxRow][midCol] < A[maxRow][midCol + 1]) {//凹， 两边都行
                return find(x1, x2, y1, midCol - 1, A, !flag);
            }else {//凸， 就在这里
                ans.add(maxRow);
                ans.add(midCol);
                return ans;
            }
        }
    }
}
</code></pre>
</div>
</div>
