/*
### Corner cases
1. Input maybe zero
2. The leftest child of root maybe not be leftest of the tree, same with right child

### Solution
1. Find the width of the tree, BFS and insert val to ans according to degree: left -> degree - 1, right -> degree + 1
    - Time complexity: O(n)
    - Space complexity: O(1)

### Bugs
1. DFS may confused the layer or depth
2. The leftest child of root maybe not be leftest of the tree, same with right child

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
    class QueueNode {
        TreeNode tn;
        int degree;
        QueueNode(TreeNode tn, int degree) {
            this.tn = tn;
            this.degree = degree;
        }
    }
    
    int min = 0, max = 0;
    
    private void traverse(TreeNode root, int degree) {
        if (root == null) return;
        min = Math.min(min, degree);
        max = Math.max(max, degree);
        traverse(root.left,  degree - 1);
        traverse(root.right, degree + 1);
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        
        traverse(root, 0);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = min; i <= max; i ++)
            ans.add(new ArrayList<Integer>());
        
        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        queue.add(new QueueNode(root, 0));
        while (!queue.isEmpty()) {
            QueueNode tmp = queue.poll();
            ans.get(tmp.degree - min).add(tmp.tn.val);
            if (tmp.tn.left != null)
                queue.add(new QueueNode(tmp.tn.left, tmp.degree - 1));
            if (tmp.tn.right != null)
                queue.add(new QueueNode(tmp.tn.right, tmp.degree + 1));
        }
        
        return ans;
    }
}