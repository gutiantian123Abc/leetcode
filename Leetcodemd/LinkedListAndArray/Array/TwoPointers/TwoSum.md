<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 题型总结：
遇到TwoSum题型， 凡是遇到unsorted array, 一般用HashMap；
遇到sorted array, 一般用Two Pointers
*/
/* Two Sum (unsorted)
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 must be less than index2. Please note that your returned answers (both index1 and
index2) are NOT zero-based.
Notice
You may assume that each input would have exactly one solution
Example
numbers=[2, 7, 11, 15], target=9
return [1, 2]
*/
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
/* Two Sum - Data structure design
Design and implement a TwoSum class. It should support the following operations: add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
Example
add(1); add(3); add(5);
find(4) // return true
find(7) // return false
*/
/*
解题思路：本题重点在于快， 因为用传统的Two Pointers 的方式必须首先sort, 这样就使O 必须为 nlogn,
而本题不太可能每次find都sort, 所以必须用一些data structure 比如 HashMap 等等
*/
/*
Given an array of integers that is already sorted in ascending order,
find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 must be less than index2.
lease note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Example
Given nums = [2, 7, 11, 15], target = 9
return [1, 2]
*/
/*
思路解析： 这道题跟上一道题的不同在与sorted 和 unsorted array.
对于sorted array, 可以用start, end , target 三定式来解决
对于unsorted array, 就得用 HashMap, for loop 来解决
解法如下：经典的start, end , sum 三段暴击式， 依然是小了start++, 大了 end--, 正好等等具体情况具体分析
*/
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
/*
Given an array of integers,
find how many pairs in the array such that their sum is less than or equal to a specific target
number.
Please return the number of pairs.
Example
Given nums = [2, 7, 11, 15], target = 24.
Return 5.
2 + 7 < 24
2 + 11 < 24
2 + 15 < 24
7 + 11 < 24
7 + 15 < 25
解题思路： 依然是经典的start, end , sum 三段暴击式， 依然是小了start++, 大了 end--, 正好等等具体情况具体分析
*/
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
/*
Given an array of integers, find how many unique pairs in the array such that their sum is equal to
a specific target number.
Please return the number of pairs.
Have you met this question in a real interview? Yes
Example
Given nums = [1,1,2,45,46,46], target = 47
return 2
1 + 46 = 47
2 + 45 = 47
*/
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
/* Two Sum - Closest to target
Given an array nums of n integers, find two integers in nums such that the sum is closest to a given
number, target.
Return the difference between the sum of the two integers and the target.
Example
Given array nums = [-1, 2, 1, -4], and target = 4.
The minimum difference is 1. (4 - (2 + 1) = 1).
*/
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>





//这种情况下， unsorted array, return index of two numbers, 就用for loop 和 HashMap, complecity is n.
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            int remain = target - numbers[i];
            if(map.containsKey(remain)) {
                ans[0] = map.get(remain);
                ans[1] = i + 1;
                return ans;
            }else {
                map.put(numbers[i], i + 1);
            }
        }
        
        return ans;
    }
}





public class TwoSum {
    private HashMap<Integer, Integer> map;
    
    public TwoSum() {
        map = new HashMap<>();
    }

    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
        if(map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        }else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        for(Integer num : map.keySet()) {
            int num2 = value - num;
            if(num != num2 && map.containsKey(num2) || num == num2 && map.get(num) > 1) {
                return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);


//记住， 凡是sorted two sum, complecity 一定是 nlog(n)
//变形：Two Sum - Input array is sorted, 

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int start = 0, end = nums.length - 1;
        int[] ans = new int[2];
        
        while(start < end) {
            if(nums[start] + nums[end] == target) {
                ans[0] = start + 1;
                ans[1] = end + 1;
                return ans;
            }else if(nums[start] + nums[end] < target) {
                start++;
            }else {
                end--;
            }
        }
        
        return ans;
    }
}


//变形：Two Sum - Less than or equal to target 
public class Solution {
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int count = 0;
        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum == target) {
                count += end - start;
                start++;               
            }
            else if(sum < target) {
                count += end - start;
                start++;
            }else {
                end--;
            }
        }
       
        return count;
    }
}

//变形： Two Sum - Unique pair
public class Solution {
    public int twoSum6(int[] nums, int target) {
        // Write your code here
        int start = 0, end = nums.length - 1;
        int count = 0;
        Arrays.sort(nums);
        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum == target) {
                count++;
                start++;
                end--;
                while(start < end && nums[start] == nums[start-1]) {
                    start++;
                }
                
                while(start < end && nums[end] == nums[end+1]) {
                    end--;
                }
            }else if(sum < target) {
                start++;
                
            }else {
                end--;
            }
        }
        
        return count;
    }
}



public class Solution {
    public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        int min_diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                return 0;
            }else if(sum < target) {
                min_diff = Math.min(min_diff, Math.abs(target - sum));
                left++;
            }else {
                min_diff = Math.min(min_diff, Math.abs(target - sum));
                right--;                
            }
        }
        
        return min_diff;
    }
}














</code></pre>
</div>
</div>
