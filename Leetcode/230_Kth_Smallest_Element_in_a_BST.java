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
    public void DFS(TreeNode root, List<Integer> inorder) {
        if (root == null) return;
        DFS(root.left,  inorder);
        inorder.add(root.val);
        DFS(root.right, inorder);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<Integer>();
        DFS(root, inorder);
        return inorder.get(k - 1);
    }
}