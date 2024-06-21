<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 50%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
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
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

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
};</code></pre>
</div>
</div>
