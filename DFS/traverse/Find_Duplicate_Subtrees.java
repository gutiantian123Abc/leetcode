/* Find Duplicate Subtrees 
Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, 
you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return result;
    }
    
    private String dfs(TreeNode node) {
        if(node == null) {
            return "#";
        }
        
        String str = node.val + "," + dfs(node.left) + "," + dfs(node.right); //serilize tree 必须是这个order node.val + "," + node.left + "," + node.right
        int hashCode = str.hashCode();
        if(!map.containsKey(hashCode)) {
            map.put(hashCode, 0);
        }
        
        map.put(hashCode, map.get(hashCode) + 1);
        if(map.get(hashCode) == 2) {
            result.add(node);
        }
        return str;
    }
}