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
        return reverseIter(head, m, n);
    }
    
    private ListNode reverseRecur(ListNode head, int m, int n) {
        if (m == n) return head;
        else if (m > 1) {
            head.next = reverseRecur(head.next, m - 1, n - 1);
            return head;
        } else {
            ListNode newHead = reverseRecur(head.next, m, n - 1);
            ListNode headNext = head.next;
            head.next = head.next.next;
            headNext.next = head;
            return newHead;
        }
    }
    
    private ListNode reverseIter(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode rec = dummy;
        for (int i = 1; i < m; i ++) rec = rec.next;
        ListNode cur, prev = rec.next, next = rec.next.next;
        for (int i = m; i < n; i ++) {
            cur = next;
            next = cur.next;
            cur.next = prev;
            prev = cur;
        }
        rec.next.next = next;
        rec.next = prev;
        return dummy.next;
    }
}