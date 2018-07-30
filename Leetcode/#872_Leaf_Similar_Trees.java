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
    private void leafSequence(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            list.add(root.val);
        if (root.left != null)
            leafSequence(root.left, list);
        if (root.right != null)
            leafSequence(root.right, list);
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSeq1 = new ArrayList<Integer>();
        List<Integer> leafSeq2 = new ArrayList<Integer>();
        leafSequence(root1, leafSeq1);
        leafSequence(root2, leafSeq2);
        if (leafSeq1.size() != leafSeq2.size())
            return false;
        for (int i = 0; i < leafSeq1.size(); i ++)
            if (leafSeq1.get(i) != leafSeq2.get(i))
                return false;
        return true;
    }
}