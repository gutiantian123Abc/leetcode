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
/* 954. Insert Delete GetRandom O(1) - Duplicates allowedDesign a data structure that supports all following operations in average O(1) time.Example// Init an empty collection.RandomizedCollection collection = new RandomizedCollection();// Inserts 1 to the collection. Returns true as the collection did not contain 1.collection.insert(1);// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection nowcontains [1,1].collection.insert(1);// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].collection.insert(2);// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.collection.getRandom();// Removes 1 from the collection, returns true. Collection now contains [1,2].collection.remove(1);// getRandom should return 1 and 2 both equally likely.collection.getRandom();NoticeDuplicate elements are allowed.insert(val): Inserts an item val to the collection.remove(val): Removes an item val from the collection if present.getRandom: Returns a random element from current collection of elements. The probability of eachelement being returned islinearly related to the number of same value the collection contains.*//* 本题关键为： nums(list) 不能断开， 这样才能实现后面的 return nums.get(rand.nextInt(nums.size())).number;知识点： 1. HashMap<Integer, ArrayList<Integer>> map                   ArrayList<Integer> tmp = map.get(1);                   tmp.add(X);                   这时， map自动改变                   要想map 不改变如下：                   ArrayList<Integer> tmp = new ArrayList<Integer>(map.get(1));                   tmp.add(X);                例子：         HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();         ArrayList<Integer> A = new ArrayList<Integer>();         A.add(1);         A.add(2);         map.put(1, A);         ArrayList<Integer> B = new ArrayList<Integer>(map.get(1));         B.remove(1);        System.out.println(map.get(1).size());        HashMap<Integer, Integer> map2 = new HashMap<>();        map2.put(1, 1);        int num = map2.get(1);        num += 1;        System.out.println(map2.get(1));*************************************************************************$java -Xmx128M -Xms16M HelloWorld21知识点2：        ArrayList A 里，        A.get(index) O(1)        A.set(index, X) O(1)        A.remove(index) O(1)        A.get(Object) O(n)        A.remove(Object) O(n)*/    /** Initialize your data structure here. */    /** Inserts a value to the collection. Returns true if the collection did not already containthe specified element. */    /** Removes a value from the collection. Returns true if the collection contained the specifiedelement. */    /** Get a random element from the collection. *//** * Your RandomizedCollection object will be instantiated and called as such: * RandomizedCollection obj = new RandomizedCollection(); * boolean param_1 = obj.insert(val); * boolean param_2 = obj.remove(val); * int param_3 = obj.getRandom(); */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class RandomizedCollection {
    class NumberandRanking {
        int number = 0;
        int ranking = 0;
        
        public NumberandRanking(int number, int ranking) {
            this.number = number;
            this.ranking = ranking;
        }
    }
    Random rand;
    HashMap<Integer, ArrayList<Integer>> map;
    ArrayList<NumberandRanking> nums;

    public RandomizedCollection() {
        this.rand = new Random();
        this.map = new HashMap<Integer, ArrayList<Integer>>();
        this.nums = new ArrayList<NumberandRanking>();
    }
    
    public boolean insert(int val) {
        // write your code here
        boolean exsist = map.containsKey(val);

        if(!exsist) {
            map.put(val, new ArrayList<Integer>());
        }
        
        map.get(val).add(nums.size());
        nums.add(new NumberandRanking(val, map.get(val).size() - 1));
        return !exsist;
    }
    
    public boolean remove(int val) {
        // write your code here
        if(!map.containsKey(val)) {
            return false;
        }
        
        ArrayList<Integer> indices = map.get(val);
        int index = indices.get(indices.size() - 1);
    
        NumberandRanking lastEle = nums.get(nums.size() - 1);
        
        //Update nums
        nums.set(index, lastEle);
        nums.remove(nums.size() - 1);
        
        //Update map for LastEle
        map.get(lastEle.number).set(lastEle.ranking, index);
        
        //Update map for old val 的成分
        indices.remove(indices.size() - 1);
        
        if(indices.size() == 0) {
            map.remove(val);
        }
        
        return true;
    }
    
    public int getRandom() {
        // write your code here
        return nums.get(rand.nextInt(nums.size())).number;
    }
}

</code></pre>
</div>
</div>
