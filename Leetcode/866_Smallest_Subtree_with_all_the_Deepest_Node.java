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
    private int findDepth(TreeNode root, int depth) {
        if (root == null) return 0;
        int tmp = depth;
        tmp = Math.max(tmp, findDepth(root.left,  depth + 1));
        tmp = Math.max(tmp, findDepth(root.right, depth + 1));
        return tmp;
    }
    
    private TreeNode findSub(TreeNode root, int curDep, int maxDep) {
        if (curDep == maxDep) return root;
        if (root == null) return null;
        TreeNode rtnLeft  = findSub(root.left,  curDep + 1, maxDep);
        TreeNode rtnRight = findSub(root.right, curDep + 1, maxDep);
        if (rtnLeft == null && rtnRight == null) return null;
        if (rtnLeft != null && rtnRight != null) return root;
        if (rtnLeft == null) return rtnRight;
        return rtnLeft;
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDep = findDepth(root, 0);    
        return findSub(root, 0, maxDep);
    }
}