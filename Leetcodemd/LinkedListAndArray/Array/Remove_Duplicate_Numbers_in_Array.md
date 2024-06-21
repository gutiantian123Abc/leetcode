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
/* Remove Duplicate Numbers in ArrayGiven an array of integers, remove the duplicate numbers in it.You should:1. Do it in place in the array.2. Move the unique numbers to the front of the array.3. Return the total number of the unique numbers. NoticeYou don't need to keep the original order of the integers.ExampleGiven nums = [1,3,1,4,4,2], you should:Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?].Return the number of unique integers in nums => 4.Actually we don't care about what you place in ?, we only care about the part which has no duplicateintegers.ChallengeDo it in O(n) time complexity.Do it in O(nlogn) time without extra space.*//*注意一定要看清complexity 以制定策略!!!*/    /**     * @param nums an array of integers     * @return the number of unique integers     */    /**     * @param nums an array of integers     * @return the number of unique integers     */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


//1. O(n) time complexity
public class Solution {
    public int deduplication(int[] nums) {
        // Write your code here
        int index = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                continue;
            }else {  
                set.add(nums[i]);   //注意这里index 先加 或 后加的原因， 这里使用set 所以index后加, 下一种方法不用set, 所以index 先加
                nums[index] = nums[i];
                index++;
            }
        }
        
        return index; //想清楚为什么不是index + 1
    }
}

//2. O(nlogn) time without extra space.
public class Solution {
    public int deduplication(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // Write your code here
        Arrays.sort(nums);
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}</code></pre>
</div>
</div>
