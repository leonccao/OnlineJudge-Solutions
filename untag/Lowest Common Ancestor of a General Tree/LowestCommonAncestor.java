public class LowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode[] children;
        TreeNode(int x, int n) { 
            val = x;
            children = new TreeNode[n];
        }
    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        int count = 0;
        TreeNode last = null;
        for (TreeNode child : root.children) {
            TreeNode tmp = LCA(child, p, q);
            if (tmp != null) {
                count ++;
                last = tmp;
            }
        }
        if (count == 0) return null;
        if (count == 1) return last;
        return root;
    }
    
    public void test() {
        TreeNode root = new TreeNode(0, 4);
        TreeNode n1 = new TreeNode(1, 0);
        TreeNode n2 = new TreeNode(2, 0);
        TreeNode n3 = new TreeNode(3, 2);
        TreeNode n4 = new TreeNode(4, 0);
        TreeNode n5 = new TreeNode(5, 0);
        TreeNode n6 = new TreeNode(6, 0);
        root.children[0] = n1;
        root.children[1] = n2;
        root.children[2] = n3;
        root.children[3] = n4;
        n3.children[0] = n5;
        n3.children[1] = n6;
        System.out.println(LCA(root, n5, n6).val);
    }

    public static void main(String[] args) {
        LowestCommonAncestor sol = new LowestCommonAncestor();
        sol.test();
    }
}