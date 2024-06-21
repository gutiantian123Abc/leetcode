<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 600px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Intersection of Two Arrays I
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/
/* Intersection of Two Arrays II
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you 
cannot load all elements into the memory at once?
*/
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

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



//Method1:
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new int[0];
        }
        
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for(int num : nums1) {
            if(!map1.containsKey(num)) {
                map1.put(num, 1);
            }else {
                map1.put(num, map1.get(num) + 1);
            }
        }
        
        
        for(int num : nums2) {
            if(map1.containsKey(num)) {
                if(map2.containsKey(num)) {
                    map2.put(num, map2.get(num) + 1);
                }else {
                    map2.put(num, 1);
                }
            }
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Integer key : map2.keySet()) {
            int times = Math.min(map1.get(key), map2.get(key));
            for(int i = 0; i < times; i++) {
                list.add(key);
            }
        }

        int[] ans = new int[list.size()];
        int index = 0;
        for(Integer num : list) {
            ans[index] = num;
            index++;
        }
        
        return ans;
 
    }
}

//Method2:
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; ++i) {
            if (map.containsKey(nums1[i]))
                map.put(nums1[i], map.get(nums1[i]) + 1); 
            else
                map.put(nums1[i], 1);
        }

        List<Integer> results = new ArrayList<Integer>();

        for (int i = 0; i < nums2.length; ++i)
            if (map.containsKey(nums2[i]) &&
                map.get(nums2[i]) > 0) {
                results.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1); 
            }

        int result[] = new int[results.size()];
        for(int i = 0; i < results.size(); ++i)
            result[i] = results.get(i);

        return result;
    }
}
</code></pre>
</div>
</div>
