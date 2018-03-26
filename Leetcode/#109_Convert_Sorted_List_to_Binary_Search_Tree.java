/*
s: 10:33 AM
e: 10:50 AM
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    ListNode node = null;
        
    public TreeNode buildTree(int start, int end) {
        if (start == end) return null;
        
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(-1);
        root.left = buildTree(start, mid);
        root.val = node.val;
        node = node.next;
        root.right = buildTree(mid + 1, end);
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        node = head;
        int size = 0;
        while (head != null) {
            size ++;
            head = head.next;
        }
        return buildTree(0, size);
    }
}