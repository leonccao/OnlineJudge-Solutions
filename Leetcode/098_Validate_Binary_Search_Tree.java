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
    class MaxMin {
        public int max;
        public int min;
        public boolean error = false;
        public MaxMin(int min, int max) {
            this.min = min;
            this.max = max;
        }
        public MaxMin(boolean error) {
            this.error = error;
        }
    }
    
    MaxMin ERROR = new MaxMin(true);
    
    public MaxMin isValid(TreeNode root) {
        MaxMin result = new MaxMin(root.val, root.val);
        if (root.left != null) {
            MaxMin tmp = isValid(root.left);
            if (tmp.error) return ERROR;
            if (tmp.max >= root.val) return ERROR;
            result.min = Math.min(tmp.min, result.min);
        }
        if (root.right != null) {
            MaxMin tmp = isValid(root.right);
            if (tmp.error) return ERROR;
            if (tmp.min <= root.val) return ERROR;
            result.max = Math.max(tmp.max, result.max);
        }
        return result;
    }
    
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        MaxMin tmp = isValid(root);
        if (tmp.error) return false;
        return true;
    }
}

class Solution {
    
    public boolean isValidBST(TreeNode root) {
        return check(root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
    }
    
    private boolean check(TreeNode root, long floor, long ceil) {
        if (root == null) return true;
        if (root.val <= floor || root.val >= ceil) return false;
        if (!check(root.left, floor, Math.min(ceil, root.val)))
            return false;
        return check(root.right, Math.max(floor, root.val), ceil);
    }
}

// new inorder
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
    
    TreeNode prev = null;
    
    private boolean helper(TreeNode root) {
        if (root == null) return true;
        if (!helper(root.left)) return false;
        if (prev != null && prev.val >= root.val) return false;
        prev = root;
        return helper(root.right);
    }
}

// new preorder
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) & helper(root.right, root.val, max);
    }
}