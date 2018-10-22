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
    private void firstScan(TreeNode root, Map<Integer, TreeNode> father) {
        if (root.left != null) {
            father.put(root.left.val, root);
            firstScan(root.left, father);
        }
        if (root.right != null) {
            father.put(root.right.val, root);
            firstScan(root.right, father);
        }
    }
    
    private void secondScan(TreeNode root, int curDist, Map<Integer, Integer> dist, Map<Integer, TreeNode> father) {
        if (dist.containsKey(root.val)) return;
        dist.put(root.val, curDist);
        if (root.left != null) {
            secondScan(root.left, curDist + 1, dist, father);
        } 
        if (root.right != null) {
            secondScan(root.right, curDist + 1, dist, father);
        }
        if (father.containsKey(root.val)) {
            secondScan(father.get(root.val), curDist + 1, dist, father);
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, TreeNode> father = new HashMap<Integer, TreeNode>();
        firstScan(root, father);
        Map<Integer, Integer> dist = new HashMap<Integer, Integer>();
        secondScan(target, 0, dist, father);
        
        List<Integer> ans = new LinkedList<Integer>();
        for (int val : dist.keySet()) {
            if (dist.get(val) == K)
                ans.add(val);
        }
        return ans;
    }
}