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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int result = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                result += root.left.val;
            else result += sumOfLeftLeaves(root.left);
        }
        result += sumOfLeftLeaves(root.right);
        return result;
    }
}