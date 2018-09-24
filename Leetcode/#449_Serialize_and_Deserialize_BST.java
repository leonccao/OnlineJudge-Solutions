/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private void serializeHelper(TreeNode root, List<String> ans) {
        String tmp = root == null ? "null" : 
            Integer.valueOf(root.val).toString();
        ans.add(tmp);
        if (root == null) return;
        serializeHelper(root.left, ans);
        serializeHelper(root.right, ans);
    }
    
    private int deserializeHelper(TreeNode root, int pos, String[] nodes) {
        if (nodes[++ pos].equals("null"))
            root.left = null;
        else {
            root.left = new TreeNode(Integer.parseInt(nodes[pos]));
            pos = deserializeHelper(root.left, pos, nodes);
        } 
        if (nodes[++ pos].equals("null"))
            root.right = null;
        else {
            root.right = new TreeNode(Integer.parseInt(nodes[pos]));
            pos = deserializeHelper(root.right, pos, nodes);
        } 
        return pos;
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        serializeHelper(root, ans);
        return String.join(",", ans);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if (nodes[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        deserializeHelper(root, 0, nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));