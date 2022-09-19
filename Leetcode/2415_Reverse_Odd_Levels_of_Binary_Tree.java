/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private class Node {
        int level;
        TreeNode tree;
        Node(int level, TreeNode tree) {
            this.level = level;
            this.tree = tree;
        }
    }
    
    public TreeNode reverseOddLevels(TreeNode root) {
        List<Node> list = new ArrayList<>();
        list.add(new Node(0, root));
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            int curLevel = node.level + 1;
            if (node.tree.left != null && node.tree.right != null) {
                list.add(new Node(curLevel, node.tree.left));
                list.add(new Node(curLevel, node.tree.right));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || 
                list.get(i).level == list.get(i - 1).level ||
                list.get(i).level % 2 == 0) {
                continue;
            }
            int j = i;
            while (j + 1 < list.size() && 
                   list.get(i).level == list.get(j + 1).level) {
                j++;
            }
            for (int k = i; k < (i + j + 1) / 2; k++) {
                int tmp = list.get(k).tree.val;
                int pos = i + j - k;
                list.get(k).tree.val = list.get(pos).tree.val;
                list.get(pos).tree.val = tmp;
            }
            i = j;
        }
        return root;
    }
}