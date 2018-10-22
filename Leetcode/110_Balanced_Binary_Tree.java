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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (getDepth(root) == -1)
            return false;
        return true;
    }
    
    public int getDepth(TreeNode root) {
        int ld = 0, rd = 0;
        if (root.left != null)
            if ((ld = getDepth(root.left)) < 0)
                return -1;
        if (root.right != null)
            if ((rd = getDepth(root.right)) < 0)
                return -1;
        if (Math.abs(ld - rd) > 1)
            return -1;
        return Math.max(ld, rd) + 1;
    }
}