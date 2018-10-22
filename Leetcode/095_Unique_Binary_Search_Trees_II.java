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
    class Case {
        public TreeNode root;
        public int nodes;
        public Case(TreeNode root, int nodes) {
            this.root = root;
            this.nodes = nodes;
        }
    }
    
    public TreeNode TreeCopy(TreeNode root) {
        if (root == null)
            return null;
        TreeNode result = new TreeNode(root.val);
        result.left = TreeCopy(root.left);
        result.right = TreeCopy(root.right);
        return result;
    }
    
    public List<TreeNode> generateTrees(int n) {
        LinkedList<TreeNode> result = new LinkedList<TreeNode>();
        if (n < 1) return result;
        
        Queue<Case> queue = new LinkedList<Case>();
        queue.offer(new Case(new TreeNode(1), 1));
        
        for (int nodes = 2; nodes <= n; nodes ++) {
            while (!queue.isEmpty() && queue.peek().nodes < nodes) {
                TreeNode root = queue.poll().root;
                
                TreeNode tmp = new TreeNode(nodes);
                tmp.left = root;
                queue.offer(new Case(TreeCopy(tmp), nodes));
                
                TreeNode base = root;
                while (base != null) {
                    tmp.left = base.right;
                    base.right = tmp;
                    queue.offer(new Case(TreeCopy(root), nodes));
                    base.right = tmp.left;
                    base = base.right;
                }
            }
        }
        
        while (!queue.isEmpty())
            result.add(queue.poll().root);
        return result;
    }
}