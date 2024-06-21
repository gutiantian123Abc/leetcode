<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 1000px; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Sliding Window Median
Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, 
find the median of the element inside the window at each moving. 
(If there are even numbers in the array, return the N/2-th number after sorting the element in the window. )

Example
For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]

At first the window is at the start of the array like this

[ | 1,2,7 | ,8,5] , return the median 2;

then the window move one step forward.

[1, | 2,7,8 | ,5], return the median 7;

then the window move one step forward again.

[1,2, | 7,8,5 | ], return the median 7;

Challenge 
O(nlog(n)) time
*/
/* 解题要诀：
这里不用PriorityQueue的原因是因为它的remove(Node) 是 O(n),
所以这里用hashheap 来， remove(Node) 是 O(logn),
但是hashheap太过复杂， 就用TreeSet来代替，这里的TreeSet: (first())min ...... max(last())
其实TreeSet功能上完全可以代替PriorityQueue, 但是我们不太用
*/
	/**
	 * @param nums
	 *            : A list of integers.
	 * @return: The median of the element inside the window at each moving.
	 */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


public class Solution {


	public class Node implements Comparable<Node>{
		int id;
		int val;
		Node(int id, int val) {
			this.val = val;
		}
		public int compareTo(Node other) {//从小到大的TreeSet:(first())min ...... max(last())
			Node a = other;
			if(this.val == a.val) {
				return this.id - a.id;//一定注意， TreeSet 加 id 是为了去处重复
			}else {
				return this.val - a.val;
			}
		}
	}


	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		TreeSet<Node> minheap = new TreeSet<Node>();
		TreeSet<Node> maxheap = new TreeSet<Node>();
		ArrayList<Integer> result = new ArrayList<Integer> ();
		
		if (k == 0)
			return result;

		for(int i = 0; i < k - 1; i++) { //注意Sliding Window的做法
			add(minheap, maxheap, new Node(i, nums[i]));
		}
		for(int i = k - 1; i < n; i++) { //注意Sliding Window的做法
			add(minheap, maxheap, new Node(i, nums[i])); //记住， TreeSet.first() 是最小值， 而非第一个值
			result.add(maxheap.last().val);
			remove(minheap,maxheap, new Node(i - k + 1, nums[i - k + 1]));//TreeSet.last() 是最小值， 而非最后一个一个值
		}//注意Sliding Window的做法
		return result;
	}
	
	
	private void add(TreeSet<Node>minheap, TreeSet<Node> maxheap, Node node) {//经典模板！！！用于两个Heap维护Median
		if(maxheap.size() == minheap.size()) {
			maxheap.add(node);
			if(minheap.size() == 0) {
				return;
			}else {
				transit(maxheap, minheap);
			}
		}else if(maxheap.size() < minheap.size()) {
			maxheap.add(node);
			transit(maxheap, minheap);
		}
		else {
			minheap.add(node);
			transit(maxheap, minheap);
		}
	}
	
	private void transit(TreeSet<Node>maxheap, TreeSet<Node> minheap) {  
		if (minheap.first().val < maxheap.last().val) {
			Node s = minheap.first();
			Node b = maxheap.last();
			minheap.remove(s);
			maxheap.remove(b);
			minheap.add(b);
			maxheap.add(s);
		}
	}
	
	private void remove(TreeSet<Node>minheap, TreeSet<Node> maxheap, Node node) {
		if (maxheap.contains(node)) {
			maxheap.remove(node);
		}else {
			minheap.remove(node);
		}
	}
}

</code></pre>
</div>
</div>
