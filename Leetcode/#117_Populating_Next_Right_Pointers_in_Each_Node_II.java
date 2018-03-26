/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        for (TreeLinkNode first = root; first != null; ) {
            TreeLinkNode cur = first;
            first = null;
            for ( ; cur != null; cur = cur.next) {
                if (first == null) first = cur.left;
                if (first == null) first = cur.right;
                
                TreeLinkNode lastChild = null;
                if (cur.left != null) {
                    lastChild = cur.left;
                    lastChild.next = cur.right;
                }
                if (cur.right != null) lastChild = cur.right;
                if (lastChild == null) continue;
                
                for (TreeLinkNode tmp = cur.next; tmp != null; tmp = tmp.next) {
                    if (tmp.left != null) {
                        lastChild.next = tmp.left;
                        break;
                    }
                    if (tmp.right != null) {
                        lastChild.next = tmp.right;
                        break;
                    }
                }
            }
        }
    }
}