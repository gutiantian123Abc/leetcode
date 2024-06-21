<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 200px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Merge k Sorted Arrays 
Given k sorted integer arrays, merge them into one sorted array.
Example
Given 3 sorted arrays:

[
  [1, 3, 5, 7],
  [2, 4, 6],
  [0, 8, 9, 10, 11]
]
return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

Challenge 
Do it in O(N log k).

N is the total number of integers.
k is the number of arrays.
*/
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    public class Element {
        public int row, col, val;
        public Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    
    public Comparator<Element> comparator = new Comparator<Element>(){//从小到大出来就是minheap
        public int compare(Element a, Element b) {
            if(a.val > b.val) {
                return 1;
            }else if(a.val < b.val) {
                return -1;
            }else {
                return 0;
            }
        }
    };
    

    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> answer = new ArrayList<Integer>();
        if(arrays == null) {
            return answer;
        } 
        
        
        PriorityQueue<Element> minheap = new PriorityQueue<Element>(arrays.length, comparator);
  
        for(int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                Element ele = new Element(i, 0, arrays[i][0]);
                minheap.add(ele);
            }
        }
        
        //二维array短板排序合并法:
        while(minheap.size() != 0) {
            Element ele = minheap.poll();
            answer.add(ele.val);
            if(ele.col + 1 < arrays[ele.row].length) {
                ele.col += 1;
                ele.val = arrays[ele.row][ele.col];
                minheap.add(ele);
            }
        }
        
        return answer;

    }
}</code></pre>
</div>
</div>
