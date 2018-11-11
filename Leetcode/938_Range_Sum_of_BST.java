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
    public int rangeSumBST(TreeNode root, int L, int R) {
        int ans = 0;
        if (root == null) return ans;
        if (root.left != null && root.val >= L)
            ans += rangeSumBST(root.left, L, R);
        if (root.right != null && root.val <= R)
            ans += rangeSumBST(root.right, L, R);
        if (root.val >= L && root.val <= R)
            ans += root.val;
        return ans;
    }
}