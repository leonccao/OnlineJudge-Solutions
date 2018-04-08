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
    public TreeNode DFS(TreeNode root) {
        if (root == null) return null;
        root.left  = DFS(root.left);
        root.right = DFS(root.right);
        if (root.left != null || root.right != null) return root;
        if (root.val > 0) return root;
        return null;
    }
    
    public TreeNode pruneTree(TreeNode root) {
        return DFS(root);
    }
}