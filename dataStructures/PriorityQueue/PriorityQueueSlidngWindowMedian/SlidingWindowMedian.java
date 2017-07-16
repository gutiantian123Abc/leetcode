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

public class Solution {
	/**
	 * @param nums
	 *            : A list of integers.
	 * @return: The median of the element inside the window at each moving.
	 */


	public class Node implements Comparable<Node>{
		int id;
		int val;
		Node(int id, int val) {
			this.val = val;
		}
		public int compareTo(Node other) {//从小到大的TreeSet:(first())min ...... max(last())
			Node a = other;
			if(this.val == a.val) {
				return this.id - a.id;
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

			for(int i = 0; i < k - 1; i++) {
				add(minheap, maxheap, new Node(i, nums[i]));
			}
			for(int i = k - 1; i < n; i++) {
				add(minheap, maxheap, new Node(i, nums[i]));
				result.add(maxheap.last().val);
				remove(minheap,maxheap, new Node(i - k + 1, nums[i - k + 1]));
			}
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

