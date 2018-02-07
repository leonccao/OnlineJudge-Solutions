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
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    
    public void invert(TreeNode r) {
        if (r == null) return;
        invert(r.left);
        invert(r.right);
        TreeNode tmp = r.right;
        r.right = r.left;
        r.left = tmp;
    }
}