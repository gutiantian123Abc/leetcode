<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 683. K Empty Slots
There is a garden with N slots. In each slot, there is a flower. 
The N flowers will bloom one by one in N days. 
In each day, there will be exactly one flower blooming and it 
will be in the status of blooming since then.

Given an array flowers consists of number from 1 to N. Each number 
in the array represents the place where the flower will open in that day.

For example, flowers[i] = x means that the unique flower that blooms at 
day i will be at position x, where i and x will be in the range from 1 to N.

Also given an integer k, you need to output in which day there exists two 
flowers in the status of blooming, and also the number of flowers between 
them is k and these flowers are not blooming.

If there isn't such day, output -1.

Example 1:
Input: 
flowers: [1,3,2]
k: 1
Output: 2
Explanation: In the second day, the first and the third flower have become blooming.
Example 2:
Input: 
flowers: [1,2,3]
k: 1
Output: -1
Note:
The given array will be in the range [1, 20000].
*/
/* 注解： TreeSet 本质为Black Red Tree, 具体API 有:
https://docs.oracle.com/javase/7/docs/api/java/util/TreeSet.html

一般都是O(logn)
1. first()
2. last()
3. lower(E e)
4. higher(E e)
5. add(E e)
6. pollFirst()
7. pollLast()
8. remove(Object o)
9. size()
10. isEmpty()
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int day = 0; day < flowers.length; day++) {
            int pos = flowers[day];
            treeSet.add(pos);
            Integer lowerPos = treeSet.lower(pos);
            Integer higherPos = treeSet.higher(pos);
            if(lowerPos != null && pos - lowerPos == k + 1 || higherPos != null && higherPos - pos == k + 1) {
                return day + 1;
            }
        }
        
        return -1;
    }
}
</code></pre>
</div>
</div>
