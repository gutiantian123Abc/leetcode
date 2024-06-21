## Problem Description
```
/* Two Sum - Data structure design 
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example
add(1); add(3); add(5);
find(4) // return true
find(7) // return false
*/
/*
解题思路：本题重点在于快， 因为用传统的Two Pointers 的方式必须首先sort, 这样就使O 必须为 nlogn,
而本题不太可能每次find都sort, 所以必须用一些data structure 比如 HashMap 等等
*/
## Solution
```java



public class TwoSum {
    private HashMap<Integer, Integer> map;
    
    public TwoSum() {
        map = new HashMap<>();
    }

    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
        if(map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        }else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        for(Integer num : map.keySet()) {
            int num2 = value - num;
            if(num != num2 && map.containsKey(num2) || num == num2 && map.get(num) > 1) {
                return true;
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);