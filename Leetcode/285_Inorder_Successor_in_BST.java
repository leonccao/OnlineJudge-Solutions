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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (p.val >= root.val) 
            return inorderSuccessor(root.right, p);
        TreeNode tmp = inorderSuccessor(root.left, p);
        return tmp != null ? tmp : root;
    }
}