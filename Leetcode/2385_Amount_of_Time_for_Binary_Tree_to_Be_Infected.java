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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        build(root, null, map);
        
        Map<Integer, Integer> time = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        time.put(start, 0);
        q.add(start);
        
        int result = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int curTime = time.get(cur);
            
            List<Integer> list = map.get(cur);
            for (int val : list) {
                if (time.containsKey(val)) {
                    continue;
                }
                time.put(val, curTime + 1);
                q.add(val);
                result = Math.max(result, curTime + 1);
            }
        }
        return result;
    }
    
    private void build(TreeNode node, TreeNode father, Map<Integer, List<Integer>> map) {
        List<Integer> list = new ArrayList<>();
        map.put(node.val, list);
        if (father != null) {
            list.add(father.val);
        }
        
        if (node.left != null) {
            list.add(node.left.val);
            build(node.left, node, map);
        }
        if (node.right != null) {
            list.add(node.right.val);
            build(node.right, node, map);
        }
    }
}