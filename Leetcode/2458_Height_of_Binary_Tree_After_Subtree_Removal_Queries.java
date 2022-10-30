/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Integer> depthMap = new HashMap<>();
        Map<Integer, Integer> calcMap = new HashMap<>();
        dfs(root, depthMap);
        calc(root, 0, depthMap, calcMap);
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            ans[i] = calcMap.get(query);
        }
        return ans;
    }
    
    private int dfs(TreeNode root, Map<Integer, Integer> depthMap) {
        if (root == null) {
            return -1;
        }
        int depth = Math.max(dfs(root.left, depthMap), dfs(root.right, depthMap)) + 1;
        depthMap.put(root.val, depth);
        return depth;
    }
    
    private void calc(TreeNode root, int depthRoot, Map<Integer, Integer> depthMap, Map<Integer, Integer> calcMap) {
        if (root == null) {
            return;
        }
        
        int depthCur = calcMap.getOrDefault(root.val, 0);
        int depthLeft = root.left != null ? depthMap.get(root.left.val) + 1 : 0;
        int depthRight = root.right != null ? depthMap.get(root.right.val) + 1 : 0;
        if (root.left != null) {
            calcMap.put(root.left.val, Math.max(depthRoot + depthRight, depthCur));
        }
        if (root.right != null) {
            calcMap.put(root.right.val, Math.max(depthRoot + depthLeft, depthCur));
        }
        
        calc(root.left, depthRoot + 1, depthMap, calcMap);
        calc(root.right, depthRoot + 1, depthMap, calcMap);
    }
    
}