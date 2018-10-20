/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode last = head;
        ListNode tmp = null;
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            tmp = next;
            next = tmp.next;
            tmp.next = last;
            last = tmp;
        }
        return last;        
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
    public ListNode reverseList(ListNode head) {
        return reverseIter(head);
    }
    
    ListNode pre;
    
    private ListNode reverseRecur(ListNode head) {
        ListNode dummy = new ListNode(0);
        pre = dummy;
        reverseHelper(head);
        pre.next = null;
        return dummy.next;
    }
    
    private void reverseHelper(ListNode node) {
        if (node == null) return;
        reverseHelper(node.next);
        pre.next = node;
        pre = node;
    }
    
    private ListNode reverseIter(ListNode head) {
        ListNode prev = null, next = null;
        
        for (ListNode cur = head; cur != null; cur = next) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
        }
        return prev;
    }
}