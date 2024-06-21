<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 700px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Maximum Subarray I
Given an array of integers, 
find a contiguous subarray which has the largest sum.

The subarray should contain at least one number.

Example
Given the array [−2,2,−3,4,−1,2,1,−5,3], 
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

Challenge 
Can you do it in time complexity O(n)?
*/
/* 知识点总结： 
子数组 Subarray
令 
**********************************************************
PrefixSum[i] = A[0] + A[1] + … A[i - 1], PrefixSum[0] = 0   ！！！！！！！！！！
**********************************************************
易知构造 PrefixSum 耗费 O(n) 时间和 O(n) 空间
如需计算子数组从下标i到下标j之间的所有数之和
则有 :
**********************************************************
Sum(i~j) = PrefixSum[j + 1] - PrefixSum[i]  ！！！！！！！！！！
**********************************************************
一定要有顺序！！！ 除非Closest to zero 特殊情况
*/
/* 知识点：Subarray Problems
    PrefixSum[i] = A[0] + A[1] + … A[i - 1], PrefixSum[0] = 0
    Sum(i~j) = PrefixSum[j + 1] - PrefixSum[i]
*/
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
/* Maximum Subarray II
Given an array of integers, find two non-overlapping subarrays which have the largest sum.
The number in each subarray should be contiguous.
Return the largest sum.

Notice
The subarray should contain at least one number

Example
For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], 
they both have the largest sum 7.

Challenge 
Can you do it in time complexity O(n) ?
*/
/* 知识点：Subarray Problems
    PrefixSum[i] = A[0] + A[1] + … A[i - 1], PrefixSum[0] = 0
    Sum(i~j) = PrefixSum[j + 1] - PrefixSum[i]
*/
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
/* Subarray Sum Closest
Given an integer array, find a subarray with sum closest to zero. 
Return the indexes of the first number and last number.
Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
Challenge 
O(nlogn) time
*/
/* 知识点：Subarray Problems
    PrefixSum[i] = A[0] + A[1] + … A[i - 1], PrefixSum[0] = 0
    Sum(i~j) = PrefixSum[j + 1] - PrefixSum[i]
*/
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>




public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        int prevSum = 0;
        //PrefixSum[i] = A[0] + A[1] + … A[i - 1], PrefixSum[0] = 0
        for(int i = 1; i < nums.length + 1; i++) {
            sums[i] = prevSum + nums[i - 1];
            prevSum = sums[i];
        }
        
        int max = Integer.MIN_VALUE, minSum = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            max = Math.max(max, sums[i] - minSum);
            minSum = Math.min(minSum, sums[i]);
        }
        
        return max;
    }
}



//与第一题一样的应用， Max_Subarray
public class Solution {
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];
        
        //求leftMax
        int[] left_sums = new int[nums.size() + 1];
        left_sums[0] = 0;
        int left_prevSum = 0;
        //PrefixSum[i] = A[0] + A[1] + … A[i - 1], PrefixSum[0] = 0
        for(int i = 1; i < nums.size() + 1; i++) {
            left_sums[i] = left_prevSum + nums.get(i - 1);
            left_prevSum = left_sums[i];
        }
        
        int leftMax = Integer.MIN_VALUE;
        int left_minSum = 0;
        for(int i = 1; i < nums.size() + 1; i++) {
            leftMax = Math.max(leftMax, left_sums[i] - left_minSum);
            left_minSum = Math.min(left_minSum, left_sums[i]);
            left[i - 1] = leftMax;
        }
 
        //求rightMax
        int[] right_sums = new int[nums.size() + 1];
        right_sums[nums.size()] = 0;
        int  right_prevSum = 0;
        //PrefixSum[i] = A[0] + A[1] + … A[i - 1], PrefixSum[0] = 0
        for(int i = nums.size() - 1; i >= 0; i--) {
            right_sums[i] = right_prevSum + nums.get(i);
            right_prevSum = right_sums[i];
        }
        
        int rightMax = Integer.MIN_VALUE;
        int right_minSum = 0;
        for(int i = nums.size() - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, right_sums[i] - right_minSum);
            right_minSum = Math.min(right_minSum, right_sums[i]);
            right[i] = rightMax;
        }       
        
        
        int maxTotal = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size() - 1; i++) {
            maxTotal = Math.max(left[i] + right[i + 1], maxTotal);
        }
        
        return maxTotal;
    }
}



public class Solution {
    class Pair {
        int sum;
        int index;
        public Pair(int s, int i) {
            sum = s;
            index = i;
        }
    }
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        } 
        
        int len = nums.length;
        if(len == 1) {
            res[0] = res[1] = 0;
            return res;
        }
        Pair[] sums = new Pair[len + 1];
        int prev = 0;
        sums[0] = new Pair(0, 0);
        //PrefixSum[i] = A[0] + A[1] + … A[i - 1], PrefixSum[0] = 0
        for (int i = 1; i < len + 1; i++) {
            sums[i] = new Pair(prev + nums[i - 1], i);
            prev = sums[i].sum;
        }
        
        Arrays.sort(sums, new Comparator<Pair>() {
           public int compare(Pair a, Pair b) {
               return a.sum - b.sum;
           } 
        });
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < len + 1; i++) {
            if (ans > sums[i].sum - sums[i-1].sum) {
                ans = sums[i].sum - sums[i-1].sum;
                int[] temp = new int[]{sums[i].index, sums[i - 1].index};
                Arrays.sort(temp);

                res[0] = temp[0]; // i
                //PrefixSum[i] = A[0] + A[1] + … A[i - 1], PrefixSum[0] = 0
                //Sum(i~j) = PrefixSum[j + 1] - PrefixSum[i]
                res[1] = temp[1] - 1; // j
            }
        }
        
        return res;
    }
}








</code></pre>
</div>
</div>
