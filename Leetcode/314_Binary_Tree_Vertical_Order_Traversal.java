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

//new BFS+Map
class Solution {
    
    private class QueueNode {
        public TreeNode node;
        public int depth;
        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        
        Queue<QueueNode> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.add(new QueueNode(root, 0));
        
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.peek().node;
            int depth = queue.poll().depth;
            if (!map.containsKey(depth)) 
                map.put(depth, new ArrayList<>());
            map.get(depth).add(cur.val);
            min = Math.min(min, depth);
            max = Math.max(max, depth);
            
            if (cur.left  != null)
                queue.add(new QueueNode(cur.left,  depth - 1));
            if (cur.right != null)
                queue.add(new QueueNode(cur.right, depth + 1));
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = min; i <= max; i ++)
            ans.add(map.get(i));
        return ans;
    }
}