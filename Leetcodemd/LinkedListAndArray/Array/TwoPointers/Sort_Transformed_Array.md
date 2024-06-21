<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 400px; margin: auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 400px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*   Sort Transformed Array
Given a sorted array of integers nums and integer values a, b and c. 
Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example:
nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

Result: [-23, -5, 1, 7]
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        if(a == 0) {
            if(b == 0) {
                for(int i = 0; i < nums.length; i++) {
                    res[i] = c;
                }
            }else if(b > 0) {
                for(int i = 0; i < nums.length; i++) {
                    res[i] = b * nums[i] + c;
                }
            }else {
                for(int i = 0; i < nums.length; i++) {
                    res[nums.length - 1 - i] = b * nums[i] + c;
                }
            }
        }else if(a > 0) {
            double mid = b / (-2.0 * a);
            double cloestDis = Double.MAX_VALUE;
            int midIndex = -1;
            for(int i = 0; i < nums.length; i++) {
                if(Math.abs(nums[i] - mid) < cloestDis) {
                    cloestDis = Math.abs(nums[i] - mid);
                    midIndex = i;
                }
            }
            
            if(midIndex == 0) {
                for(int i = 0; i < nums.length; i++) {
                    res[i] = a * nums[i] * nums[i] + b * nums[i] + c;
                }
            }else if(midIndex == nums.length - 1) {
                for(int i = 0; i < nums.length; i++) {
                    res[nums.length - 1 - i] = a * nums[i] * nums[i] + b * nums[i] + c;
                }
            }else {
                int left = midIndex - 1;
                int right = midIndex + 1;
                res[0] = a * nums[midIndex] * nums[midIndex] + b * nums[midIndex] + c;
                int index = 1;
                int x = 0;
                while(left >= 0 && right < nums.length && index >= 0 && index < nums.length) {
                  
                    double leftDis = Math.abs(nums[left] - mid);
                    double rightDis = Math.abs(nums[right] - mid);
                    
                    if(leftDis == rightDis) {
                        x = nums[left];
                        res[index++] = getNum(a, b, c, x);
                        x = nums[right];
                        res[index++] = getNum(a, b, c, x);
                        left--;
                        right++;
                    }else if(leftDis < rightDis) {
                        x = nums[left];
                        res[index++] = getNum(a, b, c, x);
                        left--;
                    }else {
                        x = nums[right];
                        res[index++] = getNum(a, b, c, x);
                        right++;
                    }
                }      
                                
                while(left >= 0 && index >= 0 && index < nums.length) {
                    x = nums[left];
                    res[index++] = getNum(a, b, c, x);
                    left--;
                }
                
                while(right < nums.length && index >= 0 && index < nums.length) {
                    x = nums[right];
                    res[index++] = getNum(a, b, c, x);
                    right++;                   
                }
                  
            }   
        }else {
            double mid = b / (-2.0 * a);
            double cloestDis = Double.MAX_VALUE;
            int midIndex = -1;
            for(int i = 0; i < nums.length; i++) {
                if(Math.abs(nums[i] - mid) < cloestDis) {
                    cloestDis = Math.abs(nums[i] - mid);
                    midIndex = i;
                }
            }
            
            if(midIndex == 0) {
                for(int i = 0; i < nums.length; i++) {
                    res[nums.length - 1 - i] = a * nums[i] * nums[i] + b * nums[i] + c;

                }
            }else if(midIndex == nums.length - 1) {
                for(int i = 0; i < nums.length; i++) {
                    res[i] = a * nums[i] * nums[i] + b * nums[i] + c;
                }
            }else {
                int left = midIndex - 1;
                int right = midIndex + 1;
                res[nums.length - 1] = a * nums[midIndex] * nums[midIndex] + b * nums[midIndex] + c;
                int index = nums.length - 2;
                int x = 0;
                while(left >= 0 && right < nums.length && index >= 0 && index < nums.length) {
                  
                    double leftDis = Math.abs(nums[left] - mid);
                    double rightDis = Math.abs(nums[right] - mid);
                    
                    if(leftDis == rightDis) {
                        x = nums[left];
                        res[index--] = getNum(a, b, c, x);
                        res[index--] = getNum(a, b, c, x);
                        left--;
                        right++;
                    }else if(leftDis < rightDis) {
                        x = nums[left];
                        res[index--] = getNum(a, b, c, x);
                        left--;
                    }else {
                        x = nums[right];
                        res[index--] = getNum(a, b, c, x);
                        right++;
                    }
                }  
                  
                while(left >= 0 && index >= 0 && index < nums.length) {
                    x = nums[left];
                    res[index--] = getNum(a, b, c, x);
                    left--;                   
                }
                
                while(right < nums.length && index >= 0 && index < nums.length) {
                    x = nums[right];
                    res[index--] = getNum(a, b, c, x);
                    right++;                    
                }
            }  
            
        }
        
        return res;
    }
    
    private int getNum(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
}</code></pre>
</div>
</div>
