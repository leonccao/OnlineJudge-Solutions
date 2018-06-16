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
    private int[] robDFS(TreeNode root) {
        int[] val = {0, 0};
        if (root == null) return val;
        int[] leftVal = robDFS(root.left);
        int[] rightVal = robDFS(root.right);
        val[0] = Math.max(leftVal[0], leftVal[1]);
        val[0] += Math.max(rightVal[0], rightVal[1]);
        val[1] = leftVal[0] + rightVal[0] + root.val;
        return val;
    }
    
    public int rob(TreeNode root) {
        int[] rootVal = robDFS(root);
        return Math.max(rootVal[0], rootVal[1]);
    }
}