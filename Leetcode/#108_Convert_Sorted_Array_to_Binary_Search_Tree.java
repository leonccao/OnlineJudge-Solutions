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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1) return null;
        return buildTree(nums, 0, nums.length - 1);
    }
    
    TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        int tmp = (start + end) / 2;
        TreeNode node = new TreeNode(nums[tmp]);
        node.left  = buildTree(nums, start, tmp - 1);
        node.right = buildTree(nums, tmp + 1, end);
        return node;
    }
}