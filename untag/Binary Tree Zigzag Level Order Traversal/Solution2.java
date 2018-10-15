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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) return ans;
        
        List<TreeNode> next = new LinkedList<TreeNode>();
        next.add(root);
        boolean reverse = false;
        while (!next.isEmpty()) {
            List<TreeNode> tmp = next;
            next = new LinkedList<TreeNode>();
            List<Integer> rec = new LinkedList<Integer>();
            
            for (TreeNode node : tmp) {
                rec.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            
            if (reverse)
                Collections.reverse(rec);
            ans.add(rec);
            
            reverse = !reverse;
        }
        return ans;
    }
}