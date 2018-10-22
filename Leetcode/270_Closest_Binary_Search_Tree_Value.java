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
    public int closestValue(TreeNode root, double target) {
        int tmp = root.val;
        if (target < root.val && root.left != null)
            tmp = closestValue(root.left, target);
        else if (target > root.val && root.right != null)
            tmp = closestValue(root.right, target);
        if (Math.abs(tmp - target) < Math.abs(root.val - target))
            return tmp;
        return root.val;
    }
}