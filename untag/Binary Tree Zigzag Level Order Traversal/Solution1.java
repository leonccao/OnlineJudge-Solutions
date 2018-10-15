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
        
        Stack<TreeNode> left  = new Stack<TreeNode>();
        Stack<TreeNode> right = new Stack<TreeNode>();
        int depth = 1;
        left.push(root);
        while (!left.isEmpty() || !right.isEmpty()) {
            List<Integer> rec = new LinkedList<Integer>();
            if (depth % 2 == 1) {
                while (!left.isEmpty()) {
                    TreeNode tmp = left.pop();
                    rec.add(tmp.val);
                    if (tmp.left != null)
                        right.push(tmp.left);
                    if (tmp.right != null)
                        right.push(tmp.right);
                }
            } else {
                while (!right.isEmpty()) {
                    TreeNode tmp = right.pop();
                    rec.add(tmp.val);
                    if(tmp.right != null)
                        left.push(tmp.right);
                    if (tmp.left != null)
                        left.push(tmp.left);
                }
            }
            depth ++;
            ans.add(rec);
        }
        return ans;
    }
}