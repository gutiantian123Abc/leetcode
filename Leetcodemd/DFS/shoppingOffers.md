<!--
<style>
  body { font-family: Arial, sans-serif; }
  .container { max-width: 100%; margin: auto; padding: 20px; }
  .comment-block { background-color: #f9f9f9; padding: 10px; border-left: 5px solid #ccc; max-width: 500px; margin: auto; word-wrap: break-word; white-space: pre-wrap; }
  .code-block { background-color: #f4f4f4; padding: 10px; border: 1px solid #ddd; }
</style>
-->

<div class='container'>
<h2>Problem Description</h2>
<div class='comment-block'>
<pre>
/* Shopping Offers
In LeetCode Store, there are some kinds of items to sell. Each item has a price.

However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

You are given the each item's price, a set of special offers, and the number we need to buy for each item. 
The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.

Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer, 
other numbers represents how many specific items you could get if you buy this offer.

You could use any of special offers as many times as you want.

Example 1:
Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
Output: 14
Explanation: 
There are two kinds of items, A and B. Their prices are $2 and $5 respectively. 
In special offer 1, you can pay $5 for 3A and 0B
In special offer 2, you can pay $10 for 1A and 2B. 
You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
Example 2:
Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
Output: 11
Explanation: 
The price of A is $2, and $3 for B, $4 for C. 
You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C. 
You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C. 
You cannot add more items, though only $9 for 2A ,2B and 1C.
Note:
There are at most 6 kinds of items, 100 special offers.
For each item, you need to buy at most 6 of them.
You are not allowed to buy more items than you want, even if that would lower the overall price.
*/
/* 
这道题很像combination sum, combine 不同的special offer 达到不同价位， 最差解是原价购买， 好好体会
*/
</pre>
</div>

<h2>Solution</h2>
<div class='code-block'>
<pre><code class='language-java'>





class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, 0);
    }
    
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int startIndex) { //记住， combination 必须有startIndex
        int minPrice = normalPrice(price, needs);

        for(int i = startIndex; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> newNeeds = new ArrayList<Integer>();
            for(int j = 0; j < needs.size(); j++) {
                if(needs.get(j) - offer.get(j) < 0) {
                    newNeeds = null;
                    break;
                }else {
                    newNeeds.add(needs.get(j) - offer.get(j));
                }
            }
            
            if(newNeeds != null) {
                minPrice = Math.min(minPrice, offer.get(offer.size() - 1) + dfs(price, special, newNeeds, i));
                //这里其实可以有重复， 这就是为什么不sort, 而且同一样special offer 可以买多次， 这就是为什么dfs(price, special, newNeeds, i) 而不是 dfs(price, special, newNeeds, i + 1)
            }
        }
        
        return minPrice;
    }
    
    private int normalPrice(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for(int i = 0; i < price.size(); i++) {
            sum += price.get(i) * needs.get(i);
        }
        
        return sum;
    }
    
}</code></pre>
</div>
</div>
