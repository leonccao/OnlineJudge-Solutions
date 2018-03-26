/*
s: 9:20 AM
e: 9:38 AM
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
    public TreeNode DFS(int[] pre, int sp, int ep, int[] in, int si, int se) {
        if (sp == ep) return null;
        int i;
        for (i = si; i < se; i ++)
            if (in[i] == pre[sp])
                break;
        TreeNode root = new TreeNode(in[i]);
        root.left  = DFS(pre, sp + 1, sp + i - si + 1, in, si, i);
        root.right = DFS(pre, sp + i - si + 1, ep, in, i + 1, se);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return DFS(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
}