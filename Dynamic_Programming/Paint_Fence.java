/* 514. Paint Fence
There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence.

Example
Given n=3, k=2 return 6

      post 1,   post 2, post 3
way1    0         0       1 
way2    0         1       0
way3    0         1       1
way4    1         0       0
way5    1         0       1
way6    1         1       0
*/

public class Solution {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // write your code here
        if(n == 0 || k == 0) {
            return 0;
        }
        if(n == 1) {
            return k;
        }
// same[i] means the ith post has the same color with the (i-1)th post.
// diff[i] means the ith post has a different color with the (i-1)th post.
        int[] same = new int[n];
        int[] diff = new int[n];
        //前两个要initialize完全是试出来的
        same[0] = k;//出于n==2时的需要
        same[1] = k;//出于n==2时的需要
        diff[0] = k;//出于n==2时的需要
        diff[1] = (k - 1) * k;//出于n==2时的需要
        
        for(int i = 2; i < same.length; i++) {
            same[i] = diff[i - 1];
            diff[i] = (k - 1) * diff[i - 1] + (k - 1) * same[i - 1];
        }
        
        return diff[n - 1] + same[n - 1];
    }
}