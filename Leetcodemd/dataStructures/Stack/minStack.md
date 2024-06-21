<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 700px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Min StackImplement a stack with min() function, which will return the smallestnumber in the stack.It should support push, pop and min operation all in O(1) cost.Noticemin operation will never be called if there is no number in the stack.Examplepush(1)pop()   // return 1push(2)push(3)min()   // return 2push(1)min()   // return 1*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

//非常重要的题目，如何测量一串数add, remove, min都是O(1), Space(n)

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if(minStack.empty() || minStack.peek() >= number) {
            minStack.push(number);
        }
    }

    public int pop() {
        // write your code here
        if(minStack.peek().equals(stack.peek()) ) {
            minStack.pop();
        }
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}

</code></pre>
</div>
</div>
