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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        goThrough(result, root, 0);
        return result;
    }
    
    public void goThrough(List<List<Integer>> result, TreeNode p, int level) {
        if (p == null) return;
        if (level == result.size())
            result.add(0, new LinkedList<Integer>());
        goThrough(result, p.left,  level + 1);
        goThrough(result, p.right, level + 1);
        result.get(result.size() - level - 1).add(p.val);
    }
}