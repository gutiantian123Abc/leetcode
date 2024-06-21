<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: 0 auto; padding: 10px; }
  .comment-block { max-width: 30%; background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; overflow-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; overflow-wrap: break-word; white-space: pre-wrap; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/*1386. Cinema Seat Allocationhttps://leetcode.com/problems/cinema-seat-allocation/description/A cinema has n rows of seats, numbered from 1 to n and there areten seats in each row, labelled from 1 to 10 as shown in the figure above.Given the array reservedSeats containing the numbers of seats alreadyreserved, for example, reservedSeats[i] = [3,8] means the seat located inrow 3 and labelled with 8 is already reserved.Return the maximum number of four-person groups you can assign on thecinema seats. A four-person group occupies four adjacent seats in onesingle row. Seats across an aisle (such as [3,3] and [3,4]) are not consideredto be adjacent, but there is an exceptional case on which an aisle split afour-person group, in that case, the aisle split a four-person group in the middle, which means to have two people on each side.Example 1:Input: n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]Output: 4Explanation: The figure above shows the optimal allocation for four groups,where seats mark with blue are already reserved and contiguous seats mark with orange arefor one group.Example 2:Input: n = 2, reservedSeats = [[2,1],[1,8],[2,6]]Output: 2Example 3:Input: n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]Output: 4Constraints:1 <= n <= 10^91 <= reservedSeats.length <= min(10*n, 10^4)reservedSeats[i].length == 21 <= reservedSeats[i][0] <= n1 <= reservedSeats[i][1] <= 10All reservedSeats[i] are distinct.*/</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int col = reservedSeat[1];

            if(!map.containsKey(row)) {
                map.put(row, new ArrayList<>());
            }

            map.get(row).add(col);
        }

        int ret = 0;

        ret += (n - map.keySet().size()) * 2;
        

        for(int i : map.keySet()) {
            List<Integer> cols = map.get(i);
            boolean flag = false;

            if(!cols.contains(2) && !cols.contains(3) && !cols.contains(4) && !cols.contains(5)) {
                ret++;
                flag = true;
            }

            if(!cols.contains(6) && !cols.contains(7) && !cols.contains(8) && !cols.contains(9)) {
                ret++;
                flag = true;
            }

            if(!flag && 
               !cols.contains(4) && !cols.contains(5) && !cols.contains(6) && !cols.contains(7)) {
                ret++;
            }

        }

        return ret;

    }
}
</code></pre>
</div>
</div>
