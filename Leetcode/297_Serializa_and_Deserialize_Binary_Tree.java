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

    public void serial(TreeNode root, List<String> list) {
        list.add(Integer.valueOf(root.val).toString());
        if (root.left != null)
            serial(root.left, list);
        else list.add("null");
        if (root.right != null)
            serial(root.right, list);
        else list.add("null");
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        List<String> list = new ArrayList<String>();
        serial(root, list);
        System.out.println(String.join(",", list));
        return String.join(",", list);
    }

    public int build(TreeNode root, int cur, String[] vals) {
        root.val = Integer.parseInt(vals[cur ++]);
        
        if (vals[cur].equals("null")) {
            root.left = null;
            ++ cur;
        } else {
            root.left = new TreeNode(-1);
            cur = build(root.left, cur, vals);
        }
        
        if (vals[cur].equals("null")) {
            root.right = null;
            ++ cur;
        } else {
            root.right = new TreeNode(-1);
            cur = build(root.right, cur, vals);
        }
        return cur;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null"))
            return null;
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(-1);
        build(root, 0, vals);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));