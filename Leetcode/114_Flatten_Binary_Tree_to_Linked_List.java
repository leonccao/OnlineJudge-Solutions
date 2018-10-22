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
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            TreeNode tmp = root.left;
            while (tmp.right != null)
                tmp = tmp.right;
            tmp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }
}