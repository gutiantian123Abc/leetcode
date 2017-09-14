/* Intersection of Two Arrays I
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new int[0];
        }
        
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        
        for(int i = 0; i < nums1.length; i++) {
            if(!set1.contains(nums1[i])) {
                set1.add(nums1[i]);
            }
        }
        
        for(int i = 0; i < nums2.length; i++) {
            if(!set2.contains(nums2[i]) && set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        
        int[] ans = new int[set2.size()];
        int index = 0;
        for(Integer num : set2) {
            ans[index] = num;
            index++;
        }
        
        return ans;
    }
}