<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Insert Delete GetRandom O(1)

Description
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Have you met this question in a real interview?  
Example
// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();

*/
    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    /*
     * @return: Get a random element from the set
     */
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class RandomizedSet {
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> num2index;
    private Random rand;
    public RandomizedSet() {
        // do intialization if necessary
        this.list = new ArrayList<Integer>();
        this.num2index = new HashMap<Integer, Integer>();
        this.rand = new Random();
    }

    public boolean insert(int val) {
        // write your code here
        if(num2index.containsKey(val)) {
            return false;
        }
        
        list.add(val);
        num2index.put(val, list.size() - 1);
        return true;
    }


    //记住   ArrayList .contains() 是 O(n)
    //      ArrayList .get(index) O(1)
    //      ArrayList .set(index, newval) O(1)
   //       ArrayList .remove(index) O(1) if last, O(n) else
    //      HashMap or HashSet .containsKey(val) .contains(val) , put(a, b) O(1)

    public boolean remove(int val) {
        // write your code here
        if(!num2index.containsKey(val)) {
            return false;
        }
        
        int index = num2index.get(val);
        if(index == list.size() - 1) {
            list.remove(index);
        }else {
            int lastIndex = list.size() - 1;
            int lastValue = list.get(lastIndex);
            
            list.set(index, lastValue);
            list.remove(lastIndex);
            
            num2index.remove(val);
            num2index.put(lastValue, index);
        }
        
        return true;
    }

    public int getRandom() {
        // write your code here
        return list.get(rand.nextInt(list.size()));
    }
}

</code></pre>
</div>
</div>
