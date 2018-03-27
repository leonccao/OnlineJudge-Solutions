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
    
    int maxn = Integer.MIN_VALUE;
    
    public int findPath(TreeNode root) {
        if (root == null) return 0;
        
        int lenl = Math.max(findPath(root.left),  0);
        int lenr = Math.max(findPath(root.right), 0);
        
        maxn = Math.max(maxn, lenl + lenr + root.val);
        return Math.max(lenl, lenr) + root.val;
    } 
    
    public int maxPathSum(TreeNode root) {
        findPath(root);
        return maxn;
    }
}