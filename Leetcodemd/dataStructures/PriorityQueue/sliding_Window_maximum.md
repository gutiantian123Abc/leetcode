<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 200px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; width: 200px; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Sliding Window Maximum
Given an array of n integer with duplicate number, 
and a moving window(size k), 
move the window at each iteration from the start of the array, 
find the maximum number inside the window at each moving.
Example
For array [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8]

At first the window is at the start of the array like this

[|1, 2, 7| ,7, 8] , return the maximum 7;

then the window move one step forward.

[1, |2, 7 ,7|, 8], return the maximum 7;

then the window move one step forward again.

[1, 2, |7, 7, 8|], return the maximum 8;
*/
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//nlog(n): TreeSet remove(), add() logn
public class Solution {
    
    public class Node { //一定注意， TreeSet 加 id 是为了去处重复
        public int val;
        public int id;
        public Node(int val, int id) {
            this.val = val;
            this.id = id;
        }
    }
    
    public Comparator<Node> comparator = new Comparator<Node>() {
        public int compare(Node a, Node b) { // small to large
            if(a.val == b.val) {
                return a.id - b.id;//一定注意， TreeSet 加 id 是为了去处重复
            }
            
            return a.val - b.val;
        }
    };
    
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
    	ArrayList<Integer> ans = new ArrayList<Integer>();
        TreeSet<Node> pq = new TreeSet<Node>(comparator);
        
        if (nums.length == 0) {
            return ans;
        }
        for (int i = 0; i < k - 1; i++) { //记住， TreeSet.first() 是最小值， 而非第一个值
            pq.add(new Node(nums[i], i)); //TreeSet.last() 是最小值， 而非最后一个一个值
        }//注意Sliding Window的做法
        
        for(int i = k - 1; i < nums.length; i++) {//注意Sliding Window的做法
            pq.add(new Node(nums[i], i));//注意Sliding Window的做法
            ans.add(pq.last().val);
            pq.remove(new Node(nums[i - k + 1], i - k + 1));//注意Sliding Window的做法
        }
        return ans;

    }
}</code></pre>
</div>
</div>
