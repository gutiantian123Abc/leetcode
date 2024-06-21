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
/*Palindrome Partitioning II 
Given a string s, cut s into some substrings such that every substring is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Have you met this question in a real interview? Yes
Example
Given s = "aab",

Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.



*/
/* 思路：
设f[i]为S前i个字符S[0..i-1]最少可以划分成几个回文串
• f[i] = min【j=0,…,i-1】{f[j] + 1| S[j..i-1]是回文串}
• 初始条件：空串可以被分成0个回文串
– f[0] = 0
*/
    /**
     * @param s a string
     * @return an integer
     */
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>


public class Solution {
     
    private boolean[][] generatePalindrome(String s) { //回文动态记忆表格
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        char[] word = s.toCharArray();
        for(int i = 0; i < word.length; i++) {
            isPalindrome[i][i] = true;
        }
        
        for(int i = 0; i < word.length - 1; i++) {
            if(word[i] == word[i + 1]) {
                isPalindrome[i][i + 1] = true;
            }else {
                isPalindrome[i][i + 1] = false;
            }
        }
        
        
        for(int length = 2; length < word.length; length++) {
            for(int start = 0; start + length < word.length; start++) {
                if(isPalindrome[start + 1][start + length - 1] == true && word[start] == word[start + length]) {
                    isPalindrome[start][start + length] = true;
                }
            }
        }
        
        return isPalindrome;
        
        
        
    }
    
    public int minCut(String s) {
        // write your code here
        
        if(s == null || s.length() < 2) {
            return 0;
        }
        
        boolean[][] isPalindrome = generatePalindrome(s);
        
        int[] f = new int[s.length() + 1];//起始状态最好从0开始！！！！！切记切记！
        f[0] = 0;
        
        // main
        for (int i = 1; i < s.length() + 1; i++) {
            f[i] = Integer.MAX_VALUE; // or f[i] = i
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }

        return f[s.length()] - 1;

        
    }
};</code></pre>
</div>
</div>
