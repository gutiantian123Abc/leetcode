/* https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/description/
1217. Minimum Cost to Move Chips to The Same Position

We have n chips, where the position of the ith chip is position[i].

We need to move all the chips to the same position. 
In one step, we can change the position of the ith chip from position[i] to:

position[i] + 2 or position[i] - 2 with cost = 0.
position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.

 

Example 1:


Input: position = [1,2,3]
Output: 1
Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
Second step: Move the chip at position 2 to position 1 with cost = 1.
Total cost is 1.
Example 2:


Input: position = [2,2,2,3,3]
Output: 2
Explanation: We can move the two chips at position  3 to position 2. 
Each move has cost = 1. The total cost = 2.
Example 3:

Input: position = [1,1000000000]
Output: 1
 

Constraints:

1 <= position.length <= 100
1 <= position[i] <= 10^9


*/

class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenNum = 0, oddNum = 0;

        for(int i = 0; i < position.length; i++) {
            if(position[i] % 2 == 0) {
                evenNum++;
            } else {
                oddNum++;
            }
        } 

        return Math.min(evenNum, oddNum);
        
    }
}

/* Explain: 
Notice that we have two types of costs:

Costs 0 when moving to position[i] + 2 or position[i] - 2.
Costs 1 when moving to position[i] + 1 or position[i] - 1.
Since move to position[i] + 2 or position[i] - 2 is free, 
it is natural to think that firstly moving chips as close as possible, with 0 cost.

In fact, we can move all chips at even positions to position 0, 
and move all chips at the odd positions to position 1.

Then, we only have many chips at position 0 and other chips at position 1. 
Next, we only need to move those two piles together.
*/