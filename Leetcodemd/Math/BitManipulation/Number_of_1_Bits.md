<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 744px; margin: 0 auto; padding: 10px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; max-width: 100%; margin: 20px auto; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Number of 1 Bits
Write a function that takes an unsigned integer and returns the number of ’1' bits it has 
(also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary 
representation 00000000000000000000000000001011, so the function should return 3.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/
/* 讲解：
Algorithm

The solution is straight-forward. We check each of the 3232 bits of the number. 
If the bit is 11, we add one to the number of 11-bits.

We can check the i^{th}ith bit of a number using a bit mask. 
We start with a mask m=1, because the binary representation of 1 is,

0000 0000 0000 0000 0000 0000 0000 0001

Clearly, a logical AND between any number and the mask 1 gives us the least significant bit of this number. 
To check the next bit, we shift the mask to the left by one.

0000 0000 0000 0000 0000 0000 0000 0010

And so on.
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n == 0) {
            return 0;
        }
        
        int bits = 0;
        int mask = 1;
        
        for(int i = 0; i < 32; i++) {
            if((n & mask) != 0) {
                bits++;
            }
            mask = mask << 1;
        }
        
        return bits;
    
    }
}</code></pre>
</div>
</div>
