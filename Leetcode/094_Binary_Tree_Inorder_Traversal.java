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
        public boolean visited = false;
        public TreeNode node;
        public Node(TreeNode node, boolean visited) {
            this.visited = visited;
            this.node = node;
        }
        public Node(TreeNode node) {
            this.node = node;
        }
        
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        if (root == null) return result;
        Stack<Node> stack = new Stack<Node>();
        stack.push(new Node(root));
        while (!stack.isEmpty()) {
            if (stack.peek().visited) {
                result.add(stack.pop().node.val);
            } else {
                Node now = stack.pop();
                if (now.node.right != null)
                    stack.push(new Node(now.node.right));
                now.visited = true;
                stack.push(now);
                if (now.node.left != null)
                    stack.push(new Node(now.node.left));
            }
        }
        return result;
    }
}