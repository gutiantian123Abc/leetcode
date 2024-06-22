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
/*
Design and implement a data structure for Least
Recently Used (LRU) cache.
It should support the following operations: get
and set.
get(key) - Get the value of the key if the key
exists in the cache,
otherwise return -1.
set(key, value) - Set or insert the value if the
key is not already present.
When the cache reached its capacity, it should
invalidate
the least recently used item before inserting a
new item.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Solution {
    
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private int capacity;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if(!map.containsKey(key)) {
            return -1;
        }
        
        Node returnNode = map.get(key);
       
        removeNode(returnNode);
        insertToTail(returnNode);
        
        return map.get(key).value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if(map.containsKey(key)) {
            map.get(key).value = value;//直接改value, 不需要重新put
            return;
        }
        
        if(map.size() == capacity) {
            map.remove(head.next.key);
            removeNode(head.next);
        }
        
        Node insert = new Node(key, value);
        insertToTail(insert);
        map.put(key, insert); //put必须放在inerst后
    }
    
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insertToTail(Node node){
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node; 
    }
}
</code></pre>
</div>
</div>
