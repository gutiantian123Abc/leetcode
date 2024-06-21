<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Subarray Sum
Given an integer array, find a subarray where the sum of numbers is zero. 
Your code should return the index of the first number and the index of the last number.
Notice
There is at least one subarray that it's sum equals to zero.

Example
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
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
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
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
/* Better way (制式装备)
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
*/   
/* Minimum Size Subarray Sum
Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.

Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.
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
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
        /* 窗口类指针移动模板
        int j = 0;

        for(int i = 0; i < nums.length; i++) {

            while(j < nums.length) {
                if(满足条件) {
                    j++;
                    更行j状态
                }else{
                    break;
                }
            }

            更新i状态
        }
        */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>



public class Solution {
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return ans;
        }
        
        map.put(0, -1); // input[1, -1] 的情况！！！！！！
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            
            sum += nums[i];
            if (map.containsKey(sum)) {
                ans.add(map.get(sum) + 1);
                ans.add(i);
                return ans;
            }else {
                map.put(sum, i);
            }
        }
       
        return ans;
    }
}


    public class Pair {
        int sum;
        int index;
        
        public  Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return ans;
        }
        int len = nums.length;
        int sum = 0;
        Pair[] sums = new Pair[len + 1];
        sums[0] = new Pair(0, 0);
        int prevSum = 0;
        for(int i = 1; i < len + 1; i++) {
            sums[i] = new Pair(prevSum + nums[i - 1], i);
            prevSum = sums[i].sum;
        }
        
        Arrays.sort(sums, new Comparator<Pair>() { //Sort 只是针对于接近0的题目， 其他情况并不适用
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        
        for(int i = 1; i < len + 1; i++) {
            if(sums[i].sum - sums[i - 1].sum == 0) {
                int[] temp = new int[2];
                temp[0] = sums[i].index;
                temp[1] = sums[i - 1].index;
                Arrays.sort(temp);

                //PrefixSum[i] = A[0] + A[1] + … A[i - 1], PrefixSum[0] = 0
                //Sum(i~j) = PrefixSum[j + 1] - PrefixSum[i]
                ans.add(temp[0]);
                ans.add(temp[1] - 1);
                return ans;
            }
        } 
        
        return ans;
    }
}







public class Solution {
    public class Pair {
        int sum = 0;
        int index = 0;
        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
    
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        Pair[] sums = new Pair[nums.length + 1];
        
        sums[0] = new Pair(0, 0);
        int prevSum = 0;
        
        for(int i = 1; i < sums.length; i++) {
            sums[i] = new Pair(prevSum + nums[i - 1], i);
            prevSum = sums[i].sum;
        }
        
        int start = 0, end = sums.length - 1;
        int minLen = Integer.MAX_VALUE;
        
        for(int i = 0; i < sums.length - 1; i++) {
            for(int j = i + 1; j < sums.length; j++) {
                if(sums[j].sum - sums[i].sum >= s) {
                    minLen = Math.min(minLen, j - i);
                    break;
                }
            }
        }
        
        return minLen == Integer.MAX_VALUE ? - 1 : minLen;
    }
}

//解法2：
public class Solution {
    public int minimumSize(int[] nums, int s) {
        // write your code here

        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int j = 0;
        
        for(int i = 0; i < nums.length; i++) {
            while(j < nums.length) {
                if(sum < s) {
                    sum += nums[j];
                    j++;
                }else {
                    break;
                }
            }
            
            if(sum >= s) {
                ans = Math.min(ans, j - i);
            }
            
            sum -= nums[i];
        }
        
        if(ans == Integer.MAX_VALUE) {
            ans = -1;
        }
           
        return ans;
    }
}
</code></pre>
</div>
</div>
