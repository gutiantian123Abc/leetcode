## Problem Description
```
/* First Unique Number In Stream
Given a continuous stream of numbers, write a function that returns 
the first unique number whenever terminating number is reached(include terminating number). 
If there no unique number before terminating number or you can't find this terminating number, return -1.

Example
Given a stream [1, 2, 2, 1, 3, 4, 4, 5, 6] and a number 5
return 3

Given a stream [1, 2, 2, 1, 3, 4, 4, 5, 6] and a number 7
return -1
*/
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
## Solution
```java

public class Solution {
    class ListNode {
        int num = 0;
        ListNode prev = null;
        ListNode next = null;
        
        public ListNode(int num) {
            this.num = num;
            prev = null;
            next = null;
        }
    }
    class DataStream {
        HashSet<Integer> dups;
        ListNode head;
        ListNode tail;
        HashMap<Integer, ListNode>numToPrev;
        
        public DataStream () {
            dups = new HashSet<>();
            head = new ListNode(0);
            tail = head;
            numToPrev = new HashMap<>();
        }
        
        public void remove(int num) {
            ListNode prev = numToPrev.get(num);
            prev.next = prev.next.next;
            numToPrev.remove(num);
            
            if(prev.next != null) {
                numToPrev.put(prev.next.num, prev);
            }else {
                tail = prev;
            }
        }
        
        public void add(int num) {
            if(dups.contains(num)) {
                return;
            }
            
            if(numToPrev.containsKey(num)) {
                remove(num);
                
                dups.add(num);
            }else {
                ListNode node = new ListNode(num);
                numToPrev.put(num, tail);
                tail.next = node;
                tail = node;
            }
        }
        
        public int getFirstUnique() {
            if(head.next != null) {
                return head.next.num;
            }
            
            return -1;
        }
      
    }
    
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        DataStream ds = new DataStream();
        for(int i = 0; i < nums.length; i++) {
            ds.add(nums[i]);
            if(nums[i] == number) {
                return ds.getFirstUnique();
            }
        }
        
        return -1;
        
    }
}