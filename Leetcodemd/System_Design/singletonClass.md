## Problem Description
```
/* 204. Singleton
Singleton is a most widely used design pattern. 
If a class has and only has one instance at every moment,
we call this design as singleton. For example, for class Mouse (not a animal mouse), 
we should design it in singleton.

You job is to implement a getInstance method for given class, return the same instance of this 
class every time you call this method.

Example
In Java:

A a = A.getInstance();
A b = A.getInstance();
a should equal to b.

Challenge
If we call getInstance concurrently, can you make sure your code could run correctly?
*/
    /**
     * @return: The same instance of this class every time
     */
## Solution
```java

class Solution {
    public static Solution instance = null;
    public static Solution getInstance() {
        // write your code here
        if(instance == null) {//Means it has not been used
            instance = new Solution();
        }
        //else, means it has been used
        return instance;
    }
};