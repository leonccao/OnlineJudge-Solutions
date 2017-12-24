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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (sum == 0 && 
            root.left == null && 
            root.right == null)
                return true;
        if (hasPathSum(root.left,  sum)) return true;
        if (hasPathSum(root.right, sum)) return true;
        return false;
    }
}