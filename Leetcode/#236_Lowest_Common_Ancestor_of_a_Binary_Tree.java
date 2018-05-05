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