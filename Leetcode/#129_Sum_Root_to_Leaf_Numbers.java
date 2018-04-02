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
    public void calc(TreeNode root, int sp, int[] sum) {
        sp = sp * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum[0] += sp;
            return;
        }
        if (root.left != null)
            calc(root.left, sp, sum);
        if (root.right != null)
            calc(root.right, sp, sum);
    }
    
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int[] sum = new int[1];
        calc(root, 0, sum);
        return sum[0];
    }
}