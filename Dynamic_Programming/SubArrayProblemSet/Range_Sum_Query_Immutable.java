/* Range Sum Query - Immutable
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
*/

class NumArray {
    //Mutable 看 Segment Tree
    int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for(int i = 1; i < preSum.length; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        return preSum[j + 1] - preSum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */