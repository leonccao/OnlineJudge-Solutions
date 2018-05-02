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
    public int depLeft(TreeNode root) {
        int dep = 0;
        for (TreeNode tmp = root; tmp != null; tmp = tmp.left)
            dep ++;
        return dep;
    }
    
    public int depRight(TreeNode root) {
        int dep = 0;
        for (TreeNode tmp = root; tmp != null; tmp = tmp.right)
            dep ++;
        return dep;
    }
    
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int depL = depLeft(root);
        int depR = depRight(root);
        if (depL == depR)
            return (1 << depL) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}