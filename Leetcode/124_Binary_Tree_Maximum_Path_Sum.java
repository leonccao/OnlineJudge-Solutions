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

// new 
class Solution {
    
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int l = Math.max(helper(root.left),  0);
        int r = Math.max(helper(root.right), 0);
        max = Math.max(max, l + r + root.val);
        return Math.max(l + root.val, r + root.val);
    }
}