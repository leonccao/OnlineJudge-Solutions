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
    TreeNode first = null, second = null;
    
    public void check(TreeNode prev, TreeNode cur) {
        if (prev == null) return;
        if (prev.val > cur.val) {
            if (first == null) {
                first = prev;
                second = cur;
            } else second = cur;
        }
    }
    
    public void recoverTree(TreeNode root) {
        TreeNode cur = root, prev = null, tmp = null;
        while (cur != null) {
            if (cur.left == null) {
                check(prev, cur);
                prev = cur;
                cur = cur.right;
                continue;
            }
            tmp = cur.left;
            while (tmp.right != null && tmp.right != cur)
                tmp = tmp.right;
            System.out.println(tmp.val + " " + cur.val);
            if (tmp.right == null) {
                tmp.right = cur;
                cur = cur.left;
            } else {
                check(prev, cur);
                prev.right = null;
                prev = cur;
                cur = cur.right;
            }
            
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}