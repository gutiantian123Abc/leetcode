<style>
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>

<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* 1710. Maximum Units on a Truck
https://leetcode.com/problems/maximum-units-on-a-truck/description/

You are assigned to put some amount of boxes onto one truck. 
You are given a 2D array boxTypes, 
where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number 
of boxes that can be put on the truck. You can choose any boxes to put 
on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.

 

Example 1:

Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Explanation: There are:
- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
You can take all the boxes of the first and second types, 
and one box of the third type.
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
Example 2:

Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
Output: 91
 

Constraints:

1 <= boxTypes.length <= 1000
1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
1 <= truckSize <= 106
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> {return b[1] - a[1];});
        int boxNums = 0, totalUnits = 0;

        for(int i = 0; i < boxTypes.length; i++) {
            int boxNum = boxTypes[i][0];
            int unit = boxTypes[i][1];

            int boxDiff = truckSize - boxNums;

            if(boxDiff > boxNum) {
                boxNums += boxNum;
                totalUnits += unit * boxNum;
            } else {
                boxNums += boxDiff;
                totalUnits += unit * boxDiff;
            }

            if(boxNums >= truckSize) {
                break;
            }
        }

        return totalUnits;
        
    }
}</code></pre>
</div>