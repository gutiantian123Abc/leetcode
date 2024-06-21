<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Implement Queue by Two Stacks
As the title described, you should only use two stacks to implement a queue's actions.
The queue should support push(element), pop() and top() 
where pop is pop the first(a.k.a front) element in the queue.
Both pop and top methods should return the value of first element.

Example
push(1)
pop()     // return 1
push(2)
push(3)
top()     // return 2
pop()     // return 2

*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // do initialization if necessary
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
        if(stack2.isEmpty()) {
            stack1.push(element);
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }else{
            while(!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(element);
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public int pop() {
        // write your code here
        return stack2.pop();
    }

    public int top() {
        // write your code here
        return stack2.peek();
    }
}</code></pre>
</div>
</div>
