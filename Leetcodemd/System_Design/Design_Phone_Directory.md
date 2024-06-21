<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 600px; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Design Phone Directory
Design a Phone Directory which supports the following operations:

get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.
Example:

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);
*/
/* 知识点: Random rd = new Random();
          rd.nextInt(n): return int 0 ~ n - 1
*/
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    /** Check if a number is available or not. */
    /** Recycle or release a number. */
/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class PhoneDirectory {
    private ArrayList<Integer> Yes;
    private ArrayList<Integer> No;
    
    public PhoneDirectory(int maxNumbers) {
        Yes = new ArrayList<>();
        No = new ArrayList<>();
        for(int i = 0; i < maxNumbers; i++) {
            Yes.add(i);
        }
    }
    
    public int get() {
        if(Yes.isEmpty()) {
            return -1;
        }else {
            Random rd = new Random();
            int index = rd.nextInt(Yes.size());
            int ans = Yes.get(index);
            Yes.remove(index);
            No.add(ans);
            return ans;
        }      
    }
    
    public boolean check(int number) {
        return Yes.contains(number);
    }
    
    public void release(int number) {
        if(No.contains(number)) {
            int index = No.indexOf(number);
            No.remove(index);
            Yes.add(number);
        }
        
    }
}

</code></pre>
</div>
</div>
