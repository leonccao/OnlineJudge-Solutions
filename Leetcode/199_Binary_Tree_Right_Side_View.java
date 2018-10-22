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
    public void DFS(TreeNode root, int h, List<Integer> view) {
        if (root == null) return;
        if (view.size() < h + 1)
            view.add(root.val);
        else view.set(h, root.val);
        DFS(root.left,  h + 1, view);
        DFS(root.right, h + 1, view);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<Integer>();
        DFS(root, 0, view);
        return view;
    }
}