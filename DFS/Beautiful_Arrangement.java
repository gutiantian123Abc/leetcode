/* 990. Beautiful Arrangement
Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array 
that is constructed by these N numbers successfully if one of the following is true for
the ith position (1 <= i <= N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?
Example
Input: 2
Output: 2
Explanation: 

The first beautiful arrangement is [1, 2]:
Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:
Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.

Notice
N is a positive integer and will not exceed 15.
*/

public class Solution {
    /**
     * @param N: The number of integers
     * @return: The number of beautiful arrangements you can construct
     */
    public int countArrangement(int N) {
        // Write your code here
        HashSet<Integer> visited = new HashSet<>();
        int[] res = new int[1];
        int currentIndex = 1;
        permutation(N, visited, currentIndex, res);
        return res[0];
    }
    
    
    public void permutation(int N, HashSet<Integer> visited, int currentIndex, int[] res) {
        if(currentIndex == N + 1) {
            res[0]++;
            return;
        }
        
        for(int number = 1; number <= N; number++) {
            if(visited.contains(number) || number % currentIndex != 0 && currentIndex % number != 0) {
                continue;
            }
            visited.add(number);
            permutation(N, visited, currentIndex + 1, res);
            visited.remove(number);
        }
    }
    
}