## Problem Description
```
/* Kth Smallest Number in Sorted Matrix 解题思路： 寻找下面所有最可能
Find the kth smallest number in at row and column sorted matrix.

Example
Given k = 4 and a matrix:

[
  [1 ,5 ,7],
  [3 ,7 ,8],
  [4 ,8 ,9],
]
return 5

Challenge 
Solve it in O(k log n) time where n is the bigger one between row size and column size.
*/
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
/* Kth Smallest Sum In Two Sorted Arrays 解题思路： 寻找下面所有最可能
Given two integer arrays sorted in ascending order and an integer k. Define sum = a + b, where a is an element from the first array and b is an element from the second one. Find the kth smallest sum out of all possible sums.

Have you met this question in a real interview? Yes
Example
Given [1, 7, 11] and [2, 4, 6].

For k = 3, return 7.

For k = 4, return 9.

For k = 8, return 15.

Challenge 
Do it in either of the following time complexity:

O(k log min(n, m, k)). where n is the size of A, and m is the size of B.
O( (m + n) log maxValue). where maxValue is the max number in A and B.
*/
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
## Solution
```java

//题型规律: 遇见求Top K ... in a matrix 或者是 arrays ..., 一般用这类 Priority Queue BFS Method
public class Solution {
    public class Element {
        int row;
        int col;
        int val;
            
        public Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
        
        
    public Comparator<Element> comparator = new Comparator<Element>() {
        public int compare(Element a, Element b) { //minheap
            if(a.val > b.val) {
                return 1;
            }else if(a.val < b.val) {
                return -1;
            }else {
                return 0;
            }
        }
    };
        
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int rowlen = matrix.length;
        int collen = matrix[0].length;
        PriorityQueue<Element> minheap = new PriorityQueue<Element>(Math.max(rowlen, collen), comparator);
        boolean[][] hash = new boolean[rowlen][collen]; //default to be false
        minheap.add(new Element(0, 0, matrix[0][0]));
        
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        
        for(int i = 0; i < k - 1; i++) {
            Element cur = minheap.poll();
            for(int j = 0; j < 2; j++) {
                int next_X = cur.row + dx[j];
                int next_Y = cur.col + dy[j];
                if(next_X < rowlen && next_Y < collen && hash[next_X][next_Y] == false) {
                    Element nextPair = new Element(next_X, next_Y, matrix[next_X][next_Y]);
                    hash[next_X][next_Y] = true;
                    minheap.add(nextPair);
                }
            }
        }
        
        return minheap.peek().val;
    }
}






public class Solution {
    public class Element {
        int row;
        int col;
        int sum;
        
        public Element(int row, int col, int sum) {
            this.row = row;
            this.col = col;
            this.sum = sum;
        }
    }
    
    public Comparator<Element> comparator = new Comparator<Element>(){
        public int compare(Element a, Element b) { //minheap
            if(a.sum > b.sum) {
                return 1;
            }else if(a.sum < b.sum) {
                return -1;
            }else {
                return 0;
            }
        }
    };
    
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        
        int aLen = A.length;
        int bLen = B.length;
        
        boolean[][] hash = new boolean[aLen][bLen];
        
        PriorityQueue<Element> minheap = new PriorityQueue<Element>(k, comparator);
        minheap.add(new Element(0, 0, A[0] + B[0]));
        
        for(int i = 0; i < k - 1; i++) {
            Element cur = minheap.poll();
            int x = cur.row;
            int y = cur.col;
            
            for(int j = 0; j < 2; j++) {
                int nextX = x + dx[j];
                int nextY = y + dy[j];
                if(nextX < aLen && nextY < bLen && hash[nextX][nextY] == false) {
                    hash[nextX][nextY] = true;
                    minheap.add(new Element(nextX, nextY, A[nextX] + B[nextY]));   
                }

            }
        }
        
        return minheap.peek().sum;
    }
}
