/*
s: 11:00 AM
e: 11:12 AM
*/
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
    public void search(TreeNode root, int left, List<List<Integer>> result, List<Integer> path) {
        if (root == null) return;
        
        path.add(root.val);
        
        if (root.left == null && root.right == null && left - root.val == 0) {
            List<Integer> tmp = new LinkedList<Integer>();
            tmp.addAll(path);
            result.add(tmp);
        } else {
            search(root.left,  left - root.val, result, path);
            search(root.right, left - root.val, result, path);   
        }
        
        path.remove(path.size() - 1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> path = new LinkedList<Integer>();
        search(root, sum, result, path);
        return result;
    }
}