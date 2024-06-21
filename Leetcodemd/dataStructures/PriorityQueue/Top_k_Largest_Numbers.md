## Problem Description
```
/* Top k Largest Numbers
Given an integer array, find the top k largest numbers in it.

Have you met this question in a real interview? Yes
Example
Given [3,10,1000,-99,4,100] and k = 3.
Return [1000, 100, 10].这道题的另一种方法是QuickSort(nlogn), 但显然没有PQ好(O(n). S(k))
*/
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
## Solution
```java

class Solution {
    public int[] topk(int[] nums, int k) {
        // Write your code here
        //PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(k, new Comparator<Integer>(){ //注意如何写Comparator
            public int compare(Integer a1, Integer a2) {//minheap
                if(a1 > a2) {//minheap
                    return 1;
                }else if(a1 < a2) {//minheap
                    return -1;
                }else {//minheap
                    return 0;
                }
            }
        });
        
        for(int i = 0; i < nums.length; i++) { //注意这里的PQ如何处理的
            maxheap.add(nums[i]);
            if(maxheap.size() > k) {
                maxheap.poll();
            }
        }
        
        
        int[] result = new int[k];
        //注意， 一定是从后往前注入
        for(int i = k - 1; i >= 0; i--) {
            result[i] = maxheap.poll();
        }
        
        return result;
    }
};
