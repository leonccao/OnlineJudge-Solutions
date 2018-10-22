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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return getDepth(root, 1);
    }
    
    public int getDepth(TreeNode p, int depth) {
        int depthNow = depth;
        if (p.left != null) 
            depthNow = Math.max(getDepth(p.left, depth + 1), depthNow);
        if (p.right != null) 
            depthNow = Math.max(getDepth(p.right, depth + 1), depthNow);
        return depthNow;
    }
}