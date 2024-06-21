<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 50%; margin: auto;}
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Find the Celebrity
Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, 
there may exist one celebrity. 
The definition of a celebrity is that all the other n - 1 people know him/her but 
he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. 
The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" 
to get information of whether A knows B. You need to find out the celebrity (or verify 
there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. 
Implement a function int findCelebrity(n), your function should minimize the number 
of calls to knows.

Note: There will be exactly one celebrity if he/she is in the party. Return the 
celebrity's label if there is a celebrity in the party. If there is no celebrity, 
return -1.
*/
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }
        
        return candidate;
    }
}</code></pre>
</div>
</div>
