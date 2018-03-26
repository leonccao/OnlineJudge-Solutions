/*
s: 9:51 AM
e: 9:57 AM
*/
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
    public TreeNode DFS(int[] post, int sp, int ep, int[] in, int si, int se) {
        if (sp == ep) return null;
        int i;
        for (i = si; i < se; i ++)
            if (in[i] == post[ep - 1])
                break;
        TreeNode root = new TreeNode(in[i]);
        root.left  = DFS(post, si + ep - se, ep + i - se, in, si, i);
        root.right = DFS(post, ep + i - se, ep - 1, in, i + 1, se);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return DFS(postorder, 0, postorder.length, inorder, 0, inorder.length);
    }
}