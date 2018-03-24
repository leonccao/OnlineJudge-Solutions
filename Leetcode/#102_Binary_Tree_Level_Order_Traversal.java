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
    class Node {
        public TreeNode node;
        public int level;
        public Node(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    
    public void addAnswer(Node cur, List<List<Integer>> result) {
        if (result.size() <= cur.level)
            result.add(new LinkedList<Integer>());
        result.get(cur.level).add(cur.node.val);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(root, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            addAnswer(cur, result);
            if (cur.node.left != null)
                queue.offer(new Node(cur.node.left, cur.level + 1));
            if (cur.node.right != null)
                queue.offer(new Node(cur.node.right, cur.level + 1));
        }
        return result;
    }
}