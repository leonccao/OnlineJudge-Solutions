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
    public void findFather(TreeNode root, Map<TreeNode, TreeNode> father) {
        if (root.left != null) {
            father.put(root.left, root);
            findFather(root.left, father);
        }
        if (root.right != null) {
            father.put(root.right, root);
            findFather(root.right, father);
        }
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p    == null) return null;
        if (q    == null) return null;
        
        Map<TreeNode, TreeNode> father = new HashMap<TreeNode, TreeNode>();
        findFather(root, father);
        
        int pdep = 0, qdep = 0;
        for (TreeNode tmp = p; tmp != root; tmp = father.get(tmp)) pdep ++;
        for (TreeNode tmp = q; tmp != root; tmp = father.get(tmp)) qdep ++;
        while (pdep > qdep) {
            p = father.get(p);
            pdep --;
        }
        while (pdep < qdep) {
            q = father.get(q);
            qdep --;
        }
        while (p != q) {
            p = father.get(p);
            q = father.get(q);
        }
        return p;
    }
}

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left  = lowestCommonAncestor(root.left,  p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode tl = lowestCommonAncestor(root.left,  p, q);
        TreeNode tr = lowestCommonAncestor(root.right, p, q);
        return tl == null ? tr : (tr == null ? tl : root);
    }
}

// One TreeNode maybe not in the tree
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
    
    TreeNode single = new TreeNode(Integer.MAX_VALUE);
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode rtn = lca(root, p, q);
        if (rtn == null || rtn == single) return null;
        return rtn;
    }
    
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode tl = lca(root.left,  p, q);
        TreeNode tr = lca(root.right, p, q);
        if (root == p || root == q) {
            if (tl != null || tr != null) return root;
            return single;
        }
        return tl == null ? tr : (tr == null ? tl : root);
    }
}

// Add a parent pointer
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
    
    Map<TreeNode, TreeNode> father = new HashMap<TreeNode, TreeNode>();
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        traverse(root);
        Set<TreeNode> visited = new HashSet<TreeNode>();
        for (TreeNode tmp = p; tmp != null; tmp = father.getOrDefault(tmp, null)) 
            visited.add(tmp);
        for (TreeNode tmp = q; tmp != null; tmp = father.getOrDefault(tmp, null)) 
            if (visited.contains(tmp)) return tmp;
        return null;
    }
    
    private void traverse(TreeNode root) {
        if (root.left != null) {
            father.put(root.left, root);
            traverse(root.left);
        }
        if (root.right != null) {
            father.put(root.right, root);
            traverse(root.right);
        }
    }
}