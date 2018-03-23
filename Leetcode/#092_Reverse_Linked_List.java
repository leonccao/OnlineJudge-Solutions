/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode headNode = new ListNode(-1);
        headNode.next = head;
        ListNode mNode = headNode;
        for (int i = 0; i < m - 1; i ++)
            mNode = mNode.next;
        ListNode nNode = headNode;
        for (int i = 0; i < n; i ++)
            nNode = nNode.next;
        
        ListNode next = mNode.next.next;
        ListNode now = mNode.next;
        ListNode jump = null;
        while (now != nNode) {
            System.out.println(now.val + " " + next.val);
            jump = next.next;
            next.next = now;
            now = next;
            next = jump;
        }
        mNode.next.next = next;
        mNode.next = now;
        return headNode.next;
    }
}